/** 
* @Title: Test.java
* @Package: org.renne.bankValidation
* @Description: TODO(用一句话描述该文件做什么)
* @author:kevin
* @date:2017年8月7日 上午11:04:30
* @version:V1.0 
*/
package org.renne.bankValidation;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hzzm.cardval.util.HttpUtil;
import org.hzzm.cardval.util.MD5Util;

import com.alibaba.fastjson.JSONObject;



public class Test {
	public static String url = "http://139.196.19.100:8080/cardval/validationCard.do";


	public static String partnerCode = "098F6BCD4621D373CADE4E832627B4F6";
	public static String cardNo = "6217002060002327720";
	  public static void main(String[] args) {
	        
//	        Map<String, String> params = new HashMap<>();
//	        params.put("PARTNER_NO_", partnerCode);//合作商编号
//	        params.put("CARD_NO_", cardNo);//银行卡号
//	        params.put("SIGN_", MD5Util.encode(cardNo + "A84632CED6B3BF02" + partnerCode).toLowerCase());//md5签名转小写
//	        params.put("CARD_NAME_", "曾庆达");//姓名
//	        params.put("CARD_MOBILE_", "17794505057");//手机号
//	        params.put("CARD_IDTYPE_", "01");
//	        params.put("CARD_IDCARD_", "420624199209212219");//身份证号码
//
//	        String ret = HttpUtil.sendPost(url, params);//Http Post发送
//	        System.out.println(ret);//{"money":450,"code":"00","desc":"交易成功"}   返回code为00表示成功  非00表示验证失败  money表示合作商剩余金额
		  	append();
	    }
	  public static void append()  {
			try {
				URL url1 = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
				connection.setDoOutput(true);
				connection.setDoInput(true);
				connection.setRequestMethod("POST");
				connection.setUseCaches(false);
				connection.setInstanceFollowRedirects(true);
				connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");         
	            
	            connection.connect(); 
	            
	            //post请求
	            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
	            JSONObject params1 = new JSONObject();
	            //Map<String, String> params1 = new HashMap<>();
		        params1.put("PARTNER_NO_", partnerCode);//合作商编号
		        params1.put("CARD_NO_", cardNo);//银行卡号
		        params1.put("SIGN_", MD5Util.encode(cardNo + "A84632CED6B3BF02" + partnerCode).toLowerCase());//md5签名转小写
		        params1.put("CARD_NAME_", "甘文凯");//姓名
		        params1.put("CARD_MOBILE_", "15579031237");//手机号
		        params1.put("CARD_IDTYPE_", "01");
		        params1.put("CARD_IDCARD_", "362202199801212010");//身份证号码
	            
	            out.write(params1.toString().getBytes("utf-8"));
	            out.flush();
	            out.close();
	            
	            //读取响应
	            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String lines;
	            StringBuffer sb = new StringBuffer("");
	            while((lines = reader.readLine()) != null) {
	            	lines = new String(lines.getBytes(), "utf-8");
	            	sb.append(lines);
	            }
	            System.out.println(sb);
	            reader.close();
	            connection.disconnect();
				
			}  catch (MalformedURLException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } catch (UnsupportedEncodingException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
		}
	
	

}
