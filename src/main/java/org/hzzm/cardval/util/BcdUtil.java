package org.hzzm.cardval.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;



public class BcdUtil {
	/*二进制,字节数组,字符,十六进制,BCD编码转换   
    * 把16进制字符串转换成字节数组
    * @param hex
    * @return
    */
public static byte[] hexStringToByte(String hex) {
    int len = (hex.length() / 2);
    byte[] result = new byte[len];
    char[] achar = hex.toCharArray();
    for (int i = 0; i < len; i++) {
     int pos = i * 2;
     result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
    }
    return result;
}

private static byte toByte(char c) {
    byte b = (byte) "0123456789ABCDEF".indexOf(c);
    return b;
}


public static final String bytesToHexString(byte[] bArray) {
    StringBuffer sb = new StringBuffer(bArray.length);
    String sTemp;
    for (int i = 0; i < bArray.length; i++) {
     sTemp = Integer.toHexString(0xFF & bArray[i]);
     if (sTemp.length() < 2)
      sb.append(0);
     sb.append(sTemp.toUpperCase());
    }
    return sb.toString();
}

/** 
 * 根据byte转换成二进制，8位 
 * @param b 
 * @return 
 */  
public static String byteToBinaryString(byte b)  
{  
    int num = b;  
    String str = "";  
    StringBuffer  sb =new StringBuffer();  
      
    //如果是正数   
    if(b>=0)  
    {  
        str+="0";  
          
        for(int i =1;i<8;i++)  
        {  
            sb.append(num%2);  
            num = num/2;  
        }  

    }  
    //如果是负数   
    //负数以它正值的补码形式表达   
    //补码=反码+1   
    else  
    {  
        str+="1";  
        num = Math.abs(num)-1;  
          
        for(int i =1;i<8;i++)  
        {  
            if(num%2==0)  
            {  
                sb.append(1);  
                num = num/2;  
            }  
            else  
            {  
                sb.append(0);  
                num = num/2;  
            }  
        }  
          
    }  
      
      
    str += sb.reverse().toString();  
      
    return str;  
}  
  
/** 
 * 根据int值转换成二进制值，32位 
 * @param b 
 * @return 
 */  
public static String intToBinaryString(int b)  
{  
    int num = b;  
    String str = "";  
    StringBuffer  sb =new StringBuffer();  
      
    //如果是正数   
    if(b>=0)  
    {  
        str+="0";  
          
        for(int i =1;i<32;i++)  
        {  
            sb.append(num%2);  
            num = num/2;  
        }  

    }  
    //如果是负数   
    //负数以它正值的补码形式表达   
    //补码=反码+1   
    else  
    {  
        str+="1";  
        num = Math.abs(num)-1;  
          
        for(int i =1;i<32;i++)  
        {  
            if(num%2==0)  
            {  
                sb.append(1);  
                num = num/2;  
            }  
            else  
            {  
                sb.append(0);  
                num = num/2;  
            }  
        }  
          
    }  
      
      
    str += sb.reverse().toString();  
      
    return str;  
}  



public static final Object bytesToObject(byte[] bytes) throws IOException, ClassNotFoundException {
    ByteArrayInputStream in = new ByteArrayInputStream(bytes);
    ObjectInputStream oi = new ObjectInputStream(in);
    Object o = oi.readObject();
    oi.close();
    return o;
}


public static final byte[] objectToBytes(Serializable s) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream ot = new ObjectOutputStream(out);
    ot.writeObject(s);
    ot.flush();
    ot.close();
    return out.toByteArray();
}

public static final String objectToHexString(Serializable s) throws IOException{
    return bytesToHexString(objectToBytes(s));
}

public static final Object hexStringToObject(String hex) throws IOException, ClassNotFoundException{
    return bytesToObject(hexStringToByte(hex));
}


public static String bcd2Str(byte[] bytes){
    StringBuffer temp=new StringBuffer(bytes.length*2);

    for(int i=0;i<bytes.length;i++){
     temp.append((byte)((bytes[i]& 0xf0)>>>4));
     temp.append((byte)(bytes[i]& 0x0f));
    }
    return temp.toString().substring(0,1).equalsIgnoreCase("0")?temp.toString().substring(1):temp.toString();
}


public static byte[] str2Bcd(String asc) {
    int len = asc.length();
    int mod = len % 2;

    if (mod != 0) {
     asc = "0" + asc;
     len = asc.length();
    }

    byte abt[] = new byte[len];
    if (len >= 2) {
     len = len / 2;
    }

    byte bbt[] = new byte[len];
    abt = asc.getBytes();
    int j, k;

    for (int p = 0; p < asc.length()/2; p++) {
     if ( (abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
      j = abt[2 * p] - '0';
     } else if ( (abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
      j = abt[2 * p] - 'a' + 0x0a;
     } else {
      j = abt[2 * p] - 'A' + 0x0a;
     }

     if ( (abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
      k = abt[2 * p + 1] - '0';
     } else if ( (abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
      k = abt[2 * p + 1] - 'a' + 0x0a;
     }else {
      k = abt[2 * p + 1] - 'A' + 0x0a;
     }

     int a = (j << 4) + k;
     byte b = (byte) a;
     bbt[p] = b;
    }
    return bbt;
}




public static String MD5EncodeToHex(String origin) {
       return bytesToHexString(MD5Encode(origin));
     }


public static byte[] MD5Encode(String origin){
    return MD5Encode(origin.getBytes());
}


public static byte[] MD5Encode(byte[] bytes){
    MessageDigest md=null;
    try {
     md = MessageDigest.getInstance("MD5");
     return md.digest(bytes);
    } catch (NoSuchAlgorithmException e) {
     e.printStackTrace();
     return new byte[0];
    }
 
}




public static String encryptBy3DES(byte [] plaintext,byte [] bytesKey){
	String cipherText = null;
	try{			
		//byte [] bytesKey = Base64.decode(base64Key);
		System.err.println(bytesKey.length);
		SecretKeySpec key = new SecretKeySpec(bytesKey,"DESede");
		
		Cipher cipher = Cipher.getInstance("DESede/ECB/NOPadding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		//byte [] plaintext = plainText.getBytes("UTF-8");
		
		byte [] cipherbytes = cipher.doFinal(plaintext);
		cipherText = BcdUtil.bytesToHexString(cipherbytes);
		System.out.println("encrypted key:"+cipherText);
	}catch(Exception ex){
		ex.printStackTrace();
	}
	return cipherText;
}

/*
 * 将加密后的密文（HEX格式）单字符再转换成16进制格式显示...
 */
public static String encryptBy3DES4Hex(byte [] plaintext,byte [] bytesKey){
	StringBuffer sb = new StringBuffer();
	try{			
		//byte [] bytesKey = Base64.decode(base64Key);
		System.err.println(bytesKey.length);
		SecretKeySpec key = new SecretKeySpec(bytesKey,"DESede");
		
		Cipher cipher = Cipher.getInstance("DESede/ECB/NOPadding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		//byte [] plaintext = plainText.getBytes("UTF-8");
		
		byte [] cipherbytes = cipher.doFinal(plaintext);
		String cipherText = BcdUtil.bytesToHexString(cipherbytes);
		
		for (int i = 0; i < cipherText.length(); i++) {
			char c = cipherText.charAt(i);
			System.out.println("encrypted key 4 ASCii cipherText["+i+"]:"+c+"=="+Integer.toHexString(c));
			sb.append(Integer.toHexString(c));
		}
		System.out.println("encrypted key 4 Hex:"+sb.toString());
	}catch(Exception ex){
		ex.printStackTrace();
	}
	return sb.toString();
}


public static String decryptBy3DES(byte [] encryptedtext,byte[] bytesKey){
	String cipherText = null;
	try{			
		//byte [] bytesKey = Base64.decode(base64Key);
		System.err.println(bytesKey.length);
		SecretKeySpec key = new SecretKeySpec(bytesKey,"DESede");
		
		Cipher cipher = Cipher.getInstance("DESede/ECB/NOPadding");
		cipher.init(Cipher.DECRYPT_MODE, key);
		
		//byte [] plaintext = plainText.getBytes("UTF-8");
		
		
		byte [] plainbytes = cipher.doFinal(encryptedtext);
		System.out.println(new String(plainbytes));
	}catch(Exception ex){
		ex.printStackTrace();
	}
	return cipherText;
}

	public static byte[] process(String pinPlain, String pinCardS) {
        byte arrAccno[] = BcdUtil.str2Bcd(pinCardS);
        byte arrPin[] = BcdUtil.str2Bcd(pinPlain);
        byte arrRet[] = new byte[8];
        for (int i = 0; i < 8; i++) {
        	arrRet[i] = (byte) (arrPin[i] ^ arrAccno[i]);
        }
        return arrRet;
        }
	
	//short byte array 相互转换
	public static byte[] shortToByteArray(short s) {
		   byte[] shortBuf = new byte[2];
		   for(int i=0;i<2;i++) {
		   int offset = (shortBuf.length - 1 -i)*8;
		   shortBuf[i] = (byte)((s>>>offset)&0xff);
		   }
		   return shortBuf;
		  }
	
	public static final int byteArrayToShort(byte [] b) {
	    return (b[0] << 8)
	            + (b[1] & 0xFF);
	   }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "50415A32363232353338303037393833353635302020202031393632323837363139303530303030343130333823";
		a = new String(BcdUtil.hexStringToByte(a));
		System.out.println(a);
		
	}

}
