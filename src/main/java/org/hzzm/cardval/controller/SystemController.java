/**
 *
 */
package org.hzzm.cardval.controller;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.hzzm.cardval.entity.CardInfo;
import org.hzzm.cardval.entity.PartnerInfo;
import org.hzzm.cardval.entity.PartnerTrans;
import org.hzzm.cardval.entity.Result;
import org.hzzm.cardval.util.IdcardVerifyUtil;
import org.hzzm.cardval.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Renne66
 * @Description: 系统控制器
 * @email 465119455@qq.com
 * @date 2016年4月21日
 */
@Controller
public class SystemController {
    private static final Logger logger = Logger.getLogger(SystemController.class);
    @Autowired
    private SystemService systemService;

    /**
     * 银行卡账户验证
     *
     * @param request
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/validationCard", method = RequestMethod.POST)
    public void validationCard(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //初始化返回值
        Result result = null;
        //获取接口参数
        String partnerNo = request.getParameter("PARTNER_NO_");
        String cardNo = request.getParameter("CARD_NO_");
        String sign = request.getParameter("SIGN_");
        String cardName = request.getParameter("CARD_NAME_");
        String cardMobile = request.getParameter("CARD_MOBILE_");
        String cardIdtype = request.getParameter("CARD_IDTYPE_");
        String cardIdcard = request.getParameter("CARD_IDCARD_");
        //账号必须存在
        if (StringUtil.isEmpty(cardNo, partnerNo, sign) ||
                (StringUtil.isEmpty(cardName)) && (StringUtil.isEmpty(cardMobile)) && (StringUtil.isEmpty(cardIdcard))) {
            result = new Result("10", "参数错误");
        } else if (!sign.equals(DigestUtils.md5Hex(cardNo + "A84632CED6B3BF02" + partnerNo))) {
            result = new Result("11", "sign错误");
        } else if (!cardIdtype.equals("01")) {
            result = new Result("12", "不支持证件类型");
        }
        else {
            //初始化参数Map并验证参数
            CardInfo paramsCard = new CardInfo(cardNo);
            //账户名和手机号选填
            if (!StringUtil.isEmpty(cardName)) paramsCard.setCARD_NAME_(cardName);// params.put("acct_name", cardName);
            if (!StringUtil.isEmpty(cardMobile))
                paramsCard.setCARD_MOBILE_(cardMobile);//params.put("phone_num", cardMobile);
            //证件类型和证件号码必须同时存在或不存在
            if (!StringUtil.isEmpty(cardIdtype, cardIdcard)) {
            	
            	//进行身份证验证上送交易前
            	if(IdcardVerifyUtil.validate18Idcard(cardIdcard)) {       		
            		paramsCard.setCARD_IDTYPE_(cardIdtype);
            		paramsCard.setCARD_IDCARD_(cardIdcard);
            	}else {
            		logger.info("Idcard is not right");
            	}
            }
            result = systemService.validation(paramsCard, partnerNo);
        }
        logger.info("validationcard:" + JSONArray.toJSON(result).toString());
        response.setCharacterEncoding("UTF-8"); //设置编码格式
        response.setContentType("text/html");   //设置数据格式
        PrintWriter out = response.getWriter(); //获取写入对象
        out.print(JSONArray.toJSON(result).toString()); //将json数据写入流中
        out.flush();
    }

    /**
     * 根据卡号获取验证信息
     *
     * @param @param  request
     * @param @param  response
     * @param @throws IOException
     * @throws
     */
    @RequestMapping(value = "/getCardInfos.do", method = RequestMethod.GET)
    public void getCardInfos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cardNo = request.getParameter("cardNo");
        if (cardNo != null && !cardNo.trim().equals("")) {
            List<CardInfo> cardInfos = systemService.getCardInfos(cardNo);
            response.setContentType("text/html;charset=UTF-8");   //设置数据格式
            PrintWriter out = response.getWriter(); //获取写入对象
            out.print(JSONArray.toJSON(cardInfos).toString()); //将json数据写入流中
            out.flush();
        }
    }

    @RequestMapping(value = "/delCardInfos.do", method = RequestMethod.POST)
    public void delCardInfos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cardId = request.getParameter("cardId");
        if (cardId != null && !cardId.trim().equals("")) {
            response.setContentType("text/html;charset=UTF-8");   //设置数据格式
            PrintWriter out = response.getWriter(); //获取写入对象
            out.print(systemService.delCardInfos(cardId)); //将数据写入流中
            out.flush();
        }
    }

    /**
     * 获取所有合作商
     *
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/getPartnerInfos.do", method = RequestMethod.GET)
    public void getPartnerInfos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<PartnerInfo> partnerInfos = systemService.getPartnerInfo(null);
        response.setContentType("text/html;charset=UTF-8");   //设置数据格式
        PrintWriter out = response.getWriter(); //获取写入对象
        out.print(JSONArray.toJSON(partnerInfos).toString()); //将json数据写入流中
        out.flush();
    }

    /**
     * 获取合作商交易记录
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getPartnerTrans.do", method = RequestMethod.GET)
    public String getPartnerTrans(HttpServletRequest request) {
        String partnerId = request.getParameter("PARTNER_ID_");
        String transType = request.getParameter("TRANS_TYPE_");
        List<PartnerTrans> partnerTrans = systemService.getPartnerTrans(Integer.valueOf(partnerId), Integer.valueOf(transType));
        return JSONArray.toJSON(partnerTrans).toString();
    }

    /**
     * 添加合作商
     *
     * @param request
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/addPartnerInfo.do", method = RequestMethod.POST)
    public void addPartnerInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = null;
        String partnerNo = request.getParameter("PARTNER_NO_");
        String partnerName = request.getParameter("PARTNER_NAME_");
        String partnerMoney = request.getParameter("PARTNER_MONEY_");
        if (StringUtil.isEmpty(partnerNo, partnerName)) {
            result = new Result("10", "参数不能为空");
        } else {
            PartnerInfo partnerInfo = new PartnerInfo(partnerNo, partnerName, 0);
            int id = systemService.addPartnerInfo(partnerInfo);
            partnerInfo.setID_(id);
            if (StringUtil.isNotEmpty(partnerMoney) && Integer.valueOf(partnerMoney) > 0) {
                systemService.transPartnerMoney(partnerInfo, Integer.valueOf(partnerMoney), 1);
            }
            result = new Result("0", "添加成功");
        }
        logger.info("addPartnerInfo:" + JSONArray.toJSON(result).toString());
        response.setCharacterEncoding("UTF-8"); //设置编码格式
        response.setContentType("text/html");   //设置数据格式
        PrintWriter out = response.getWriter(); //获取写入对象
        out.print(JSONArray.toJSON(result).toString()); //将json数据写入流中
        out.flush();
    }

    /**
     * 合作商充值
     *
     * @param request
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/addPartnerMoney.do", method = RequestMethod.POST)
    public void addPartnerMoney(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = null;
        String partnerNo = request.getParameter("PARTNER_NO_");
        String transMoney = request.getParameter("TRANS_MONEY_");
        if (StringUtil.isEmpty(partnerNo, transMoney)) {
            result = new Result("10", "参数不能为空");
        } else {
            List<PartnerInfo> partnerInfos = systemService.getPartnerInfo(partnerNo);
            if (partnerInfos.size() == 0) {
                result = new Result("12", "合作商不存在");
            } else {
                PartnerInfo partnerInfo = partnerInfos.get(0);
                systemService.transPartnerMoney(partnerInfo, Integer.valueOf(transMoney), 1);
                result = new Result("00", "充值成功");
            }
        }
        logger.info("addPartnerMoney:" + JSONArray.toJSON(result).toString());
        response.setCharacterEncoding("UTF-8"); //设置编码格式
        response.setContentType("text/html");   //设置数据格式
        PrintWriter out = response.getWriter(); //获取写入对象
        out.print(JSONArray.toJSON(result).toString()); //将json数据写入流中
        out.flush();
    }
}