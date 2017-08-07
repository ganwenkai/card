package org.hzzm.cardval.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hzzm.cardval.util.StringUtil;
import org.hzzm.cardval.entity.CardInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/** 
* @ClassName: CardInfoDao 
* @Description: TODO
* @author Renne66  465119455@qq.com
* @date 2016年4月29日 上午10:21:05 
*  
*/
@Repository("cardInfoDao")
public class CardInfoDao {
	
	
	
	private static final Logger logger = Logger.getLogger(CardInfoDao.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 添加卡信息
	 * @param paramsCard
	 * @return
	 */
	public int addCardInfo(CardInfo paramsCard){
		String sql = "INSERT INTO card_info (CARD_NO_, CARD_NAME_, CARD_MOBILE_, CARD_IDCARD_,rspCd,rspDesc) VALUES (?, ?, ?, ?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(paramsCard.getCARD_NO_());
		list.add(paramsCard.getCARD_NAME_());
		list.add(paramsCard.getCARD_MOBILE_());
		list.add(paramsCard.getCARD_IDCARD_());
		list.add(paramsCard.getRspCd());
		list.add(paramsCard.getRspDesc());
		logger.info("addCardInfo:"+sql);
		logger.info("addCardInfo:"+list.toString());
		return jdbcTemplate.update(sql, list.toArray());
	}
	
	/**
	 * 查询卡信息
	 * @param paramsCard
	 * @return
	 */
	public List<CardInfo> queryCardInfo(CardInfo paramsCard){
		StringBuffer buffer = new StringBuffer("SELECT * FROM card_info WHERE CARD_NO_ = ? ");
		List<Object> list = new ArrayList<Object>();
		list.add(paramsCard.getCARD_NO_());
		if(!StringUtil.isEmpty(paramsCard.getCARD_NAME_())){
			buffer.append(" AND CARD_NAME_ = ?");
			list.add(paramsCard.getCARD_NAME_());
		}
		if(!StringUtil.isEmpty(paramsCard.getCARD_MOBILE_())){
			buffer.append(" AND CARD_MOBILE_ = ?");
			list.add(paramsCard.getCARD_MOBILE_());
		}
		if(!StringUtil.isEmpty(paramsCard.getCARD_IDCARD_())){
			buffer.append(" AND CARD_IDCARD_ = ?");
			list.add(paramsCard.getCARD_IDCARD_());
		}
		logger.info("queryCardInfo:"+buffer.toString());
		logger.info("queryCardInfo:"+list.toString());
		List<CardInfo> cardInfos = jdbcTemplate.query(buffer.toString(),list.toArray(), new BeanPropertyRowMapper<CardInfo>(CardInfo.class));
		return cardInfos;
	}

	/** 
	* @Title: delCardInfo 
	* @Description: TODO
	* @param @param cardNo
	* @param @return
	* @return int
	* @throws 
	*/
	public int delCardInfo(String cardId) {
		return jdbcTemplate.update("delete from card_info where ID_ = '"+cardId+"'");
	}
}
