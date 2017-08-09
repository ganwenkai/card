/**
 *
 */
package org.hzzm.cardval.controller;

import org.apache.log4j.Logger;
import org.hzzm.cardval.application.BankInfoCheck;
import org.hzzm.cardval.dao.CardInfoDao;
import org.hzzm.cardval.dao.PartnerDao;
import org.hzzm.cardval.entity.CardInfo;
import org.hzzm.cardval.entity.PartnerInfo;
import org.hzzm.cardval.entity.PartnerTrans;
import org.hzzm.cardval.entity.Result;
import org.hzzm.cardval.util.Constant;
import org.hzzm.cardval.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Renne66
 * @Description: 服务类
 * @email 465119455@qq.com
 * @date 2016年4月21日
 */
@Component
public class SystemService {

    private static final Logger logger = Logger.getLogger(SystemService.class);
    @Autowired
    private CardInfoDao cardInfoDao;
    @Autowired
    private PartnerDao partnerDao;

    private static final List<String> codeList = new ArrayList<>();

    static {
        codeList.add("01");
    }

    /**
     * 查询合作商
     *
     * @return
     */
    public List<PartnerInfo> getPartnerInfo(String partnerNo) {
        return partnerDao.queryPartners(partnerNo);
    }

    /**
     * 查询合作商的交易记录
     *
     * @param partnerId 合作商ID
     *                  //	 * @param partnerType 交易类型 1-充值 2-消费
     * @return
     */
    public List<PartnerTrans> getPartnerTrans(int partnerId, int transType) {
        return partnerDao.queryPartnerTrans(partnerId, transType);

    }

    /**
     * 添加合作商
     *
     * @param partnerInfo
     */
    public int addPartnerInfo(PartnerInfo partnerInfo) {
        return partnerDao.addPartner(partnerInfo);
    }

    /**
     * 合作商交易
     *
     * @param partnerInfo 合作商信息
     * @param money       交易金额
     * @param transType   交易类型  1 充值 2 消费
     * @return
     */
    public void transPartnerMoney(PartnerInfo partnerInfo, int money, int transType) {
        //添加合作伙伴消费信息
        PartnerTrans partnerTrans = new PartnerTrans();
        partnerTrans.setPARTNER_ID_(partnerInfo.getID_());
        partnerTrans.setTRANS_TYPE_(transType);
        partnerTrans.setTRANS_MONEY_(money);
        partnerDao.addPartnerTrans(partnerTrans);
        int result = transType == 1 ? partnerInfo.getPARTNER_MONEY_() + money : partnerInfo.getPARTNER_MONEY_() - money;
        //更新合作伙伴余额
        partnerDao.updatePartnersMoney(partnerInfo.getPARTNER_NO_(), result);
        partnerInfo.setPARTNER_MONEY_(result);
    }

    public List<CardInfo> getCardInfos(String cardNo) {
        return cardInfoDao.queryCardInfo(new CardInfo(cardNo));
    }

    public int delCardInfos(String cardId) {
        return cardInfoDao.delCardInfo(cardId);
    }

    public int addCardInfo(CardInfo paramsCard) {
        return cardInfoDao.addCardInfo(paramsCard);
    }

    /**
     * 银行卡账户验证
     *
     * @return 0 成功  -1 失败
     */
    public Result validation(CardInfo paramsCard, String partnerNo) {
        //查询合作商是否存在及余额是否充足
        List<PartnerInfo> partnerInfos = partnerDao.queryPartners(partnerNo);
        if (partnerInfos.size() == 0) return new Result("12", "合作商不存在");

        PartnerInfo partnerInfo = partnerInfos.get(0);
        if (partnerInfo.getPARTNER_MONEY_() < Constant.BANK_PRICE)
            return new Result("13", "合作商余额不足", partnerInfo.getPARTNER_MONEY_());
        //查询卡片信息是否在数据库中存在
        List<CardInfo> cardInfos = cardInfoDao.queryCardInfo(paramsCard);
        if (cardInfos.size() > 0) {
            CardInfo card = cardInfos.get(0);
            return new Result(card.getRspCd(), card.getRspDesc(), partnerInfo.getPARTNER_MONEY_());
        }
        //数据库中不存在
        logger.info("数据库中不存在卡片记录，调用四要素接口查询");
        Map<String, String> params = new HashMap<>();
        params.put("acct_pan", paramsCard.getCARD_NO_());
        if (!StringUtil.isEmpty(paramsCard.getCARD_NAME_())) params.put("acct_name", paramsCard.getCARD_NAME_());
        if (!StringUtil.isEmpty(paramsCard.getCARD_MOBILE_())) params.put("phone_num", paramsCard.getCARD_MOBILE_());
        if (!StringUtil.isEmpty(paramsCard.getCARD_IDCARD_())) {
        	//交易送往银联前，需要进行身份证验证
        	
            params.put("cert_type", paramsCard.getCARD_IDTYPE_());
            params.put("cert_id", paramsCard.getCARD_IDCARD_());
        }
        String code = null;
        String desc = null;

        logger.info("----->合作商编码" + partnerNo);

        Map<String, String> map = BankInfoCheck.Call(paramsCard.getCARD_NO_(), paramsCard.getCARD_IDCARD_(), paramsCard.getCARD_MOBILE_(), paramsCard.getCARD_NAME_());
        if (null != map) {
            code = map.get("code");
            desc = map.get("desc");
        } else {
            code = "999";
            desc = "校验失败";
        }

        //将返回结果插入到数据库
        paramsCard.setRspCd(code);
        paramsCard.setRspDesc(desc);
        cardInfoDao.addCardInfo(paramsCard);
        //返回00或者05时扣除消费金额
        if ("00".equals(code) || "05".equals(code)) {
            this.transPartnerMoney(partnerInfo, Constant.BANK_PRICE, 2);
        }
        return new Result(code, desc, partnerInfo.getPARTNER_MONEY_());
    }
}
