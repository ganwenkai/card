/** 
* @Title: HttpUtil.java
* @Package: org.hzzm.cardval.util
* @Description: TODO(用一句话描述该文件做什么)
* @author:kevin
* @date:2017年8月4日 下午3:57:31
* @version:V1.0 
*/
package org.hzzm.cardval.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

public class HttpUtil {
	/** 
     * 向指定URL发送POST请求 
     * @param url 
     * @param paramMap 
     * @return 响应结果 
	 * @throws Exception 
     */  
	private static final Logger logger = Logger.getLogger(HttpUtil.class);
	public static String sendPost(String url, Map<String, String> paramMap) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			//打开URL的连接
			URLConnection conn = realUrl.openConnection();
			//设置通用属性
			 conn.setRequestProperty("accept", "*/*");  
	         conn.setRequestProperty("connection", "Keep-Alive");  
	         conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)"); 
	         
	         //发送post请求
	         conn.setDoOutput(true);
	         conn.setDoInput(true);
	         //获取URLConnection对象对应得输出流
	         out = new PrintWriter(conn.getOutputStream());
	         
	         //设置请求属性
	         StringBuffer sbtr = new StringBuffer();
	         String param = "";
	         if(paramMap != null && paramMap.size()>0) {
	        	 Iterator<String> it = paramMap.keySet().iterator();
	        	 while(it.hasNext()) {
	        		 String key = it.next();
	        		 String value = paramMap.get(key);
	        		 sbtr.append(key);
	        		 sbtr.append(value);
	        	 }
	        	 param = sbtr.substring(0, sbtr.length());
	 
	         }
	         
	         //发送请求参数
	         out.print(param);
	         //flush输出流的缓冲
	         out.flush();
	      // 定义BufferedReader输入流来读取URL的响应 
	         in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         String line;
	         while((line = in.readLine())!=null) {
	        	 result += line;
	         }
	         
	         
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			  logger.info("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		 // 使用finally块来关闭输出流、输入流  
        finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }  
		return result;
		
	}

}
