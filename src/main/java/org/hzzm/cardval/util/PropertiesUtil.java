package org.hzzm.cardval.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties p = null;
	static{ 
		try {
			p = new Properties();
			String dbConfig = "/application.properties"; //设置配置连接资源
			p.load(PropertiesUtil.class.getResourceAsStream(dbConfig));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperties(String key){
		return p.getProperty(key);
	}
	
	public static int getIntProperties(String key){
		return Integer.parseInt(getProperties(key));
	}
	
	public static boolean getBooleanProperties(String key){
		return Boolean.parseBoolean(getProperties(key));
	}
}
