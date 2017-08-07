/**
 * 
 */
package org.hzzm.cardval.entity;

/** 
 * @Description: 卡片验证信息
 * @author Renne66
 * @email 465119455@qq.com
 * @date 2016年4月21日 
*/
public class CardInfo {
	public int ID_;
	public String CARD_NO_;
	public String CARD_NAME_;
	public String CARD_IDTYPE_;
	public String CARD_IDCARD_;
	public String CARD_MOBILE_;
	public String rspCd;
	public String rspDesc;
	public CardInfo() {
		super();
	}
	public CardInfo(String cARD_NO_) {
		super();
		CARD_NO_ = cARD_NO_;
	}
	public int getID_() {
		return ID_;
	}
	public void setID_(int iD_) {
		ID_ = iD_;
	}
	public String getCARD_NO_() {
		return CARD_NO_;
	}
	public void setCARD_NO_(String cARD_NO_) {
		CARD_NO_ = cARD_NO_;
	}
	public String getCARD_NAME_() {
		return CARD_NAME_;
	}
	public void setCARD_NAME_(String cARD_NAME_) {
		CARD_NAME_ = cARD_NAME_;
	}
	public String getCARD_IDTYPE_() {
		return CARD_IDTYPE_;
	}
	public void setCARD_IDTYPE_(String cARD_IDTYPE_) {
		CARD_IDTYPE_ = cARD_IDTYPE_;
	}
	public String getCARD_IDCARD_() {
		return CARD_IDCARD_;
	}
	public void setCARD_IDCARD_(String cARD_IDCARD_) {
		CARD_IDCARD_ = cARD_IDCARD_;
	}
	public String getCARD_MOBILE_() {
		return CARD_MOBILE_;
	}
	public void setCARD_MOBILE_(String cARD_MOBILE_) {
		CARD_MOBILE_ = cARD_MOBILE_;
	}
	public String getRspCd() {
		return rspCd;
	}
	public void setRspCd(String rspCd) {
		this.rspCd = rspCd;
	}
	public String getRspDesc() {
		return rspDesc;
	}
	public void setRspDesc(String rspDesc) {
		this.rspDesc = rspDesc;
	}
	
}
