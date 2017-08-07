/** 
* @Title: MD5Util.java
* @Package: org.hzzm.cardval.util
* @Description: TODO(MD5加密算法)
* @author:kevin
* @date:2017年8月7日 上午10:16:41
* @version:V1.0 
*/
package org.hzzm.cardval.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	public static String encode(String str) {
		StringBuffer md5Code = new StringBuffer();
		try {
			//获取加密方式的MD5算法对象
			MessageDigest instance = MessageDigest.getInstance("MD5");
			byte[] digest = instance.digest(str.getBytes());
			for(byte b : digest) {
				String hexString = Integer.toHexString(b & 0xff);
				if(hexString.length() < 2) {
					hexString = "0" + hexString;
				}
				 md5Code.append(b);
			}
			return md5Code.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}

}
