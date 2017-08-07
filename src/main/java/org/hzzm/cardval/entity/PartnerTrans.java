/**
 * 
 */
package org.hzzm.cardval.entity;

import java.util.Date;

/** 
 * @Description: 合作伙伴交易信息
 * @author Renne66
 * @email 465119455@qq.com
 * @date 2016年4月22日 
*/
public class PartnerTrans {
	private int ID_;//交易ID
	private int PARTNER_ID_;//合作商ID
	private int TRANS_TYPE_;//交易类型 1-充值  2-消费 
	private int TRANS_MONEY_;//交易金额（分）
	private Date TRANS_DATE_;//交易时间
	
	public PartnerTrans() {
		super();
	}
	public PartnerTrans(int pARTNER_ID_, int tRANS_TYPE_, int tRANS_MONEY_, Date tRANS_DATE_) {
		super();
		PARTNER_ID_ = pARTNER_ID_;
		TRANS_TYPE_ = tRANS_TYPE_;
		TRANS_MONEY_ = tRANS_MONEY_;
		TRANS_DATE_ = tRANS_DATE_;
	}
	public int getID_() {
		return ID_;
	}
	public void setID_(int iD_) {
		ID_ = iD_;
	}
	public int getPARTNER_ID_() {
		return PARTNER_ID_;
	}
	public void setPARTNER_ID_(int pARTNER_ID_) {
		PARTNER_ID_ = pARTNER_ID_;
	}
	public int getTRANS_TYPE_() {
		return TRANS_TYPE_;
	}
	public void setTRANS_TYPE_(int tRANS_TYPE_) {
		TRANS_TYPE_ = tRANS_TYPE_;
	}
	public int getTRANS_MONEY_() {
		return TRANS_MONEY_;
	}
	public void setTRANS_MONEY_(int tRANS_MONEY_) {
		TRANS_MONEY_ = tRANS_MONEY_;
	}
	public Date getTRANS_DATE_() {
		return TRANS_DATE_;
	}
	public void setTRANS_DATE_(Date tRANS_DATE_) {
		TRANS_DATE_ = tRANS_DATE_;
	}
}
