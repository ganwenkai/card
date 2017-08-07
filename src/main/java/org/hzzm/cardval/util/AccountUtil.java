package org.hzzm.cardval.util;

import org.apache.log4j.Logger;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;


public class AccountUtil {
	private static final Logger logger = Logger.getLogger(AccountUtil.class);
	
	public static Map<String, String> account(String acctNo, String certId, String userName, String mobile){
		try {
			StringBuffer message = new StringBuffer("|8236|898331033330004|00000001|").append(acctNo).append("||||000001|")
					.append(String.format("%06d", (int)(Math.random() * 1000000)))
					.append("||ID18").append(certId).append("NM").append(String.format("%02d", userName.getBytes("GBK").length))
					.append(userName);
			if (!StringUtil.isEmpty(mobile)) {
				message.append("MPN11").append(mobile);
			}
			message.append("||||||||");
			byte[] messageArr = message.toString().getBytes("GBK");
			String mac = mac(BcdUtil.bytesToHexString(messageArr), "30473306E3E29A2393203E6BBEDB270B");
			messageArr = byteAdd(messageArr, BcdUtil.str2Bcd(mac));
			
			
			messageArr = byteAdd(BcdUtil.str2Bcd("0003"), messageArr);
			messageArr = byteAdd("3006".getBytes(), messageArr);
			messageArr = byteAdd(BcdUtil.str2Bcd("6002050000"), messageArr);
			messageArr = byteAdd(getPackageLenByte(messageArr.length, 2), messageArr);
			return getRetMap(messageArr);
		} catch (Exception e) {
			logger.error(e);
			return StringUtil.createRespMap("10", e.getMessage());
		}
	}
	
	private static Map<String, String> getRetMap(byte[] messageArr) throws Exception{
		SSLContext context = SSLContext.getInstance("SSLv3");
		X509TrustManager x509m = new X509TrustManager() {

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkClientTrusted(X509Certificate[] arg0, String arg1)
					throws CertificateException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void checkServerTrusted(X509Certificate[] arg0, String arg1)
					throws CertificateException {
				// TODO Auto-generated method stub
				
			}
		};
		// 初始化SSLContext实例  
		context.init(null, new TrustManager[] { x509m },  new java.security.SecureRandom());
		SSLSocketFactory factory = context.getSocketFactory();
//		SSLSocket s = (SSLSocket) factory.createSocket("112.124.101.107", 11001);
		SSLSocket s = (SSLSocket) factory.createSocket("121.199.32.189", 11001);
		if(s != null){
			OutputStream output = s.getOutputStream();
			output.write(messageArr);
			output.flush();
			// 读取请求内容
			InputStream input = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(input, "GBK"));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine())!=null) sb.append(line);
			String ret = sb.toString();
			output.close();
			input.close();
			s.close();
			String[] rets = ret.split("\\|");
			if(rets.length > 19 ) return StringUtil.createRespMap(rets[13], rets[14]);
			logger.info("返回数据格式错误:"+ret);
			return StringUtil.createRespMap("10", "返回数据格式错误");
		}
		return StringUtil.createRespMap("10", "网络连接失败");
	}
	
	private static byte[] getPackageLenByte(int cmdLen, int lengthBytes) {
		int l = cmdLen;
		byte[] buf = new byte[lengthBytes];
		int pos = 0;
		if (lengthBytes == 4) {
			buf[0] = (byte) ((l & 0xff000000) >> 24);
			pos++;
		}
		if (lengthBytes > 2) {
			buf[pos] = (byte) ((l & 0xff0000) >> 16);
			pos++;
		}
		if (lengthBytes > 1) {
			buf[pos] = (byte) ((l & 0xff00) >> 8);
			pos++;
		}
		buf[pos] = (byte) (l & 0xff);
		return buf;

	}
	
	public static byte[] byteAdd(byte[] a, byte[] b){
		byte[] ret = new byte[a.length+b.length];
		for(int i=0; i<a.length; i++){
			ret[i] = a[i];
		}
		for(int j=0; j<b.length; j++){
			ret[a.length+j] = b[j];
		}
		return ret;
		
	}
	
	public static String mac(String macblock, String mackey) {
		macblock = getMacData(macblock);
		String des = Des.DES_3(macblock, mackey, 0);
		return des;
	}
	
	public static String getMacData(String MAB){
		byte[] data = BcdUtil.hexStringToByte(MAB);
		   int group = (data.length + (8 - 1)) / 8;
	        //偏移量
	       int offset = 0 ;
	        //输入计算数据
	       byte[] edata = null;
	       byte[] temp = null;
	        for(int i = 0 ; i < group; i++){
	            temp = new byte[8];
	            if(i != group - 1){ 
	                System.arraycopy(data, offset, temp, 0, 8);
	                offset += 8;
	            }else{//只有最后一组数据才进行填充0x00
	                System.arraycopy(data, offset, temp, 0, data.length - offset);
	            }


	            if(i != 0){//只有第一次不做异或
	               edata = XOR(edata,temp);
	            }else{
	            	edata = temp;
	            }
	        }
	        String hex = BcdUtil.bytesToHexString(edata);
	        return hex;
	}
	private static byte[] XOR(byte[] edata, byte[] temp) {
        byte [] result = new byte[8];
        for (int i = 0 , j = result.length ; i < j; i++) {
            result [i] = (byte) (edata[i] ^ temp[i]);
        }
        return result;
    }
	
	public static void main(String[] args) throws Exception {
//		System.out.println(account("6225750016645976", "441522199202132765", "温创文", "13729919140"));
//		System.out.println(account("6222520178434516", "330327198001090634", "吴联胜", "13588876163"));
	}
}
