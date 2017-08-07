package org.hzzm.cardval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hzzm.cardval.util.DateUtil;
import org.hzzm.cardval.util.StringUtil;
import org.hzzm.cardval.entity.PartnerInfo;
import org.hzzm.cardval.entity.PartnerTrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/** 
* @ClassName: PartnerDao 
* @Description: TODO
* @author Renne66  465119455@qq.com
* @date 2016年4月29日 上午10:23:53 
*  
*/
@Repository("partnerDao")
public class PartnerDao {
	private static final Logger logger = Logger.getLogger(PartnerDao.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 添加合作商伙伴
	 * @param partner
	 * @return
	 */
	public int addPartner(final PartnerInfo partner){
		final String sql = "INSERT INTO partner_info (PARTNER_NO_,PARTNER_NAME_,PARTNER_MONEY_) VALUES (?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, partner.getPARTNER_NO_());
                ps.setString(2, partner.getPARTNER_NAME_());
                ps.setInt(3, partner.getPARTNER_MONEY_());
                return ps;
            }
        }, keyHolder);
		logger.info("addPartner:"+sql);
		return keyHolder.getKey().intValue();
	}
	
	/**
	 * 查询合作商伙伴
	 * @param PARTNER_NO_ 合作商编号
	 * @return
	 */
	public List<PartnerInfo> queryPartners(String PARTNER_NO_){
		String sql = "SELECT * FROM partner_info";
		if(StringUtil.isNotEmpty(PARTNER_NO_)){
			sql += " WHERE PARTNER_NO_ = '" + PARTNER_NO_ + "'";
		}
		logger.info("queryPartners:"+sql);
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<PartnerInfo>(PartnerInfo.class));
	}
	
	/**
	 * 更新合作商余额
	 * @param PARTNER_ID_  合作商ID
	 * @param PARTNER_MONEY_ 合作商余额
	 * @return
	 */
	public int updatePartnersMoney(String PARTNER_NO_,int PARTNER_MONEY_){
		String sql = "UPDATE partner_info SET PARTNER_MONEY_ = ? WHERE PARTNER_NO_ = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(PARTNER_MONEY_);
		list.add(PARTNER_NO_);
		logger.info("updatePartnersMoney:"+sql);
		logger.info("updatePartnersMoney:"+list.toString());
		return jdbcTemplate.update(sql,list.toArray());
	}
	
	/**
	 * 添加合作商交易信息
	 * @param trans
	 * @return
	 */
	public int addPartnerTrans(PartnerTrans partnerTrans){
		String sql = "INSERT INTO partner_trans (PARTNER_ID_,TRANS_TYPE_,TRANS_MONEY_,TRANS_DATE_) VALUES (?,?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(partnerTrans.getPARTNER_ID_());
		list.add(partnerTrans.getTRANS_TYPE_());
		list.add(partnerTrans.getTRANS_MONEY_());
		list.add(StringUtil.isEmptyReplace(partnerTrans.getTRANS_DATE_(), DateUtil.getCurDate()));
		logger.info("addPartnerTrans:"+sql);
		logger.info("addPartnerTrans:"+list.toString());
		return jdbcTemplate.update(sql, list.toArray());
	}
	
	/**
	 * 查询合作商交易信息
	 * @param partnerId  合作商ID
	 * @param transType 交易类型  1 充值 2 消费
	 * @return
	 */
	public List<PartnerTrans> queryPartnerTrans(int PARTNER_ID_,int TRANS_TYPE_){
		String sql = "SELECT * FROM partner_trans WHERE 1 = 1";
		if(StringUtil.isNotEmpty(PARTNER_ID_)){
			sql += " AND PARTNER_ID_ = " + PARTNER_ID_ + "";
		}
		if(StringUtil.isNotEmpty(TRANS_TYPE_)){
			sql += " AND TRANS_TYPE_ = " + TRANS_TYPE_ + "";
		}
		sql += " ORDER BY TRANS_DATE_ DESC LIMIT 20";
		logger.info("queryPartnerTrans:"+sql);
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<PartnerTrans>(PartnerTrans.class));
	}

}
