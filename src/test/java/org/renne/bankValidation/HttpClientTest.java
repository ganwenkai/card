/** 
* @Title: HttpClientTest.java
* @Package: org.renne.bankValidation
* @Description: TODO(用一句话描述该文件做什么)
* @author:kevin
* @date:2017年8月7日 上午11:35:05
* @version:V1.0 
*/
package org.renne.bankValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {
	private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).build();
	
	public static String sendPost(String url, Map<String, String> params) {
		String responseContent = null;
		try{
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for(String key : params.keySet()) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}
		//参数集合传入到一个UrlEncodedFormEntity
		httpPost.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));
		 CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
		 //发送Post,并返回一个HttpResponse对象
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        if(httpEntity != null) {
        	responseContent = EntityUtils.toString(httpEntity, "UTF-8");
        }
		} catch(Exception e) {
			e.printStackTrace();
		}
		//返回应答字符串
        return responseContent;
		
	}
	

}
