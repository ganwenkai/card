/** 
* @Title: Card.java
* @Package: org.renne.bankValidation
* @Description: TODO(用一句话描述该文件做什么)
* @author:kevin
* @date:2017年8月7日 下午10:50:04
* @version:V1.0 
*/
package org.hzzm.cardval;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hzzm.cardval.util.HttpUtil;
import org.hzzm.cardval.util.MD5;

public class Card {
	public static void main(String[] args) {
		     String url = "http://139.196.19.100:8080/cardval/validationCard.do";
	         String partnerCode = "098F6BCD4621D373CADE4E832627B4F6";
	         String cardNo = "6217002060002327720";
	        //String cardNo = "6226197701696964";
	        /*System.out.println("开始进行传参数：");
	        String cardNo = args[0];
	        String name = args[1];
	        String mobile = args[2];
	        String idType = args[3];
	        String idCard = args[4];*/
	        Map<String, String> params = new HashMap<String, String>();
	        params.put("PARTNER_NO_", partnerCode);
			params.put("CARD_NO_", cardNo);
			params.put("CARD_NAME_", "甘文凯");//姓名
			params.put("CARD_MOBILE_", "15579031237");//手机号
			params.put("CARD_IDTYPE_", "01");
			params.put("CARD_IDCARD_", "362202199801212010");//身份证号码
			params.put("SIGN_", (MD5.encode(cardNo+"A84632CED6B3BF02"+partnerCode)));//签名为小写
	        /*Map<String, String> params = new HashMap<>();
	        params.put("PARTNER_NO_", partnerCode);//合作商编号
	        params.put("CARD_NO_", cardNo);//银行卡号
	        params.put("SIGN_", MD5.encode(cardNo + "A84632CED6B3BF02" + partnerCode).toLowerCase());//md5签名转小写
	        params.put("CARD_NAME_", name);//姓名
	        params.put("CARD_MOBILE_", mobile);//手机号
	        params.put("CARD_IDTYPE_", idType);
	        params.put("CARD_IDCARD_", idCard);//身份证号码
*/
	        String ret = HttpUtil.sendPost(url, params);//Http Post发送
	        System.out.println(ret);
	}

}
