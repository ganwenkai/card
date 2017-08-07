/** 
* @Title: DemoTest.java
* @Package: org.renne.bankValidation
* @Description: TODO(银行卡验证测试类)
* @author:kevin
* @date:2017年8月4日 上午10:23:34
* @version:V1.0 
*/
package org.renne.bankValidation;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.hzzm.cardval.util.HttpUtil;
import org.hzzm.cardval.util.MD5;
import org.junit.Test;




public class DemoTest {
	private static final Logger logger = Logger.getLogger(DemoTest.class);
	private static final String SERVER_URL = "http://139.196.19.100:8080/cardval/validationCard.do";
	private static final String partnerCode = "098F6BCD4621D373CADE4E832627B4F6";
	private static final String cardNo = "6226197701696964";
	@Test
	public void test() throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("PARTNER_NO_", partnerCode);
		params.put("CARD_NO_", cardNo);
		params.put("SIGN_", (MD5.encode(cardNo+"A84632CED6B3BF02"+partnerCode)));//签名为小写
		
		params.put("CARD_NAME_", "曾庆达");//姓名
		params.put("CARD_MOBILE_", "17794505057");//手机号
        params.put("CARD_IDTYPE_", "01");
        params.put("CARD_IDCARD_", "420624199209212219");//身份证号码
        String ret = HttpUtil.sendPost(SERVER_URL, params);//Http Post发送
    
        System.out.println(ret);//{"money":450,"code":"00","desc":"交易成功"}   返回code为00表示成功  非00表示验证失败  money表示合作商剩余金额

	
	}

}
