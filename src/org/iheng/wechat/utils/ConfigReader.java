package org.iheng.wechat.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ConfigReader {
	private static HashMap<String,String> configs;
	
	static{
		Properties properties=new Properties();
		InputStream in=ConfigReader.class.getResourceAsStream("../config.properties");
		try{
			properties.load(in);
			String server_ip=properties.getProperty("SERVER_IP").trim();
			String server_port=properties.getProperty("SERVER_PORT").trim();
			
			configs.put("SERVER_IP", server_ip);
			configs.put("SERVER_PORT", server_port);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
