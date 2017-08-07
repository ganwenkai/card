/**
 * 
 */
package org.hzzm.cardval.entity;

/** 
 * @Description: 合作商信息
 * @author Renne66
 * @email 465119455@qq.com
 * @date 2016年4月22日 
*/
public class PartnerInfo {
	private int ID_;//合作商ID
	private String PARTNER_NO_;//合作商编号
	private String PARTNER_NAME_;//合作商姓名
	private int PARTNER_MONEY_;//合作商余额（分）
	
	public PartnerInfo(String pARTNER_NO_, String pARTNER_NAME_, int pARTNER_MONEY_) {
		super();
		PARTNER_NO_ = pARTNER_NO_;
		PARTNER_NAME_ = pARTNER_NAME_;
		PARTNER_MONEY_ = pARTNER_MONEY_;
	}
	public PartnerInfo() {
		super();
	}
	public int getID_() {
		return ID_;
	}
	public void setID_(int iD_) {
		ID_ = iD_;
	}
	public String getPARTNER_NO_() {
		return PARTNER_NO_;
	}
	public void setPARTNER_NO_(String pARTNER_NO_) {
		PARTNER_NO_ = pARTNER_NO_;
	}
	public String getPARTNER_NAME_() {
		return PARTNER_NAME_;
	}
	public void setPARTNER_NAME_(String pARTNER_NAME_) {
		PARTNER_NAME_ = pARTNER_NAME_;
	}
	public int getPARTNER_MONEY_() {
		return PARTNER_MONEY_;
	}
	public void setPARTNER_MONEY_(int pARTNER_MONEY_) {
		PARTNER_MONEY_ = pARTNER_MONEY_;
	}
	
}
