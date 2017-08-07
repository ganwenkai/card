/** 
* @Title: MD5.java
* @Package: org.hzzm.cardval.util
* @Description: TODO(用一句话描述该文件做什么)
* @author:kevin
* @date:2017年8月4日 下午12:02:44
* @version:V1.0 
*/
package org.hzzm.cardval.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.hzzm.cardval.application.BankInfoCheck;



//MD5加密签名操作
public class MD5 {
	private static final Logger logger = Logger.getLogger(MD5.class);
	
	private static final String ALGORITHM_MD5 = "MD5";
	
	public static String encode(String src) {
		return encode(src, true);
	}

	/**
	 * @param src
	 * @param b
	 * @return 结果是否大写true大写，false小写
	 */
	public static String encode(String src, boolean upcase) {
		// TODO Auto-generated method stub
		String ret = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance(ALGORITHM_MD5);
			byte[] bytes = md5.digest(src.getBytes());//获取消息摘要
			
			ret = StringUtil.bytes2HexString(bytes);//转成16进制字符串小写
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}
			

}
