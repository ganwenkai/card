/** 
* @Title: DemoTest.java
* @Package: org.renne.bankValidation
* @Description: TODO(银行卡验证测试类)
* @author:kevin
* @date:2017年8月4日 上午10:23:34
* @version:V1.0 
*/
package org.renne.bankValidation;




import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hzzm.cardval.util.HttpUtil;
import org.hzzm.cardval.util.MD5;
import org.junit.Test;




public class DemoTest {
	private static final Logger logger = Logger.getLogger(DemoTest.class);
	private static final String SERVER_URL = "http://139.196.19.100:8080/cardval/validationCard.do";
	private static final String partnerCode = "098F6BCD4621D373CADE4E832627B4F6";
	private static final String cardNo = "6217002060003308018";
	@Test
	public void test() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("PARTNER_NO_", partnerCode);
		params.put("CARD_NO_", cardNo);
		params.put("CARD_NAME_", "甘文凯");//姓名
		params.put("CARD_MOBILE_", "15579031237");//手机号
		params.put("CARD_IDTYPE_", "01");
		params.put("CARD_IDCARD_", "362202199801212010");//身份证号码
		params.put("SIGN_", (MD5.encode(cardNo+"A84632CED6B3BF02"+partnerCode)));//签名为小写
		
        String ret = HttpUtil.sendPost(SERVER_URL, params);//Http Post发送
    
        System.out.println(ret);//{"money":450,"code":"00","desc":"交易成功"}   返回code为00表示成功  非00表示验证失败  money表示合作商剩余金额
        System.out.println(MD5.encode(cardNo+"A84632CED6B3BF02"+partnerCode));

	}

}
