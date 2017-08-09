/**
 *
 */
package org.hzzm.cardval.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Renne66
 * @Description: 字符串工具类
 * @email 465119455@qq.com
 * @date 2016年4月22日
 */
public class StringUtil {
    public static boolean isEmpty(Object obj) {
        if (obj == null) return true;
        String str = obj.toString();
        return str == null ? true : str.trim().length() == 0 || "null".equalsIgnoreCase(str.trim()) ? true : false;
    }

    public static boolean isEmpty(String... checkStr_) {
        for (String temp : checkStr_) {
            if (isEmpty(temp)) return true;
        }
        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    public static String isEmptyReplace(Object checkStr, String replace) {
        return isEmpty(checkStr) ? replace : checkStr.toString();
    }

    public static <T> T isEmptyReplace(T checkStr, T replace) {
        return isEmpty(checkStr) ? replace : checkStr;
    }

    public static Map<String, String> createRespMap(String respCode, String respMsg) {
        Map<String, String> map = new HashMap<>();
        map.put("respCode", respCode);
        map.put("respDesc", respMsg);
        return map;
    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
     */
    public static boolean isMoblie(String mobileString) {
        Pattern mobilePattern = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$");
        Matcher mobileMatcher = mobilePattern.matcher(mobileString);
        return mobileMatcher.matches();
    }

    //身份证简单校验
    public static boolean isIDCard(String idString) {
        Pattern idPattern15 = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
        Matcher idMatcher15 = idPattern15.matcher(idString);
        Pattern idPattern18 = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");
        Matcher idMatcher18 = idPattern18.matcher(idString);
        return (idMatcher15.matches() || idMatcher18.matches());
    }

//    public static void main(String[] args) {
////        System.out.println("------->" + isIDCard("01"));
////        System.out.println("------->" + isMoblie(""));
//    }
    
    /**
     * MD5摘要加密
     * byte[] 转 16进制字符串
     * 2017-08-04-12:34
     * @param arr
     * @return
     */
    public static String bytes2HexString(byte[] arr) {
        return bytes2HexString(arr, true);
    }
    
    /**
     * byte[] 转 16进制字符串
     * 
     * @param arr
     * @param upcase 是否小写
     * @return
     */
    public static String bytes2HexString(byte[] arr, boolean upcase) {
        StringBuilder sbd = new StringBuilder();
        for (byte b : arr) {
            String tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() < 2)
                tmp = "0" + tmp;
            sbd.append(tmp);
        }
        
        if (upcase) {
            return sbd.toString().toLowerCase();            
        } 
        else {
            return sbd.toString();
        }
    }

}
