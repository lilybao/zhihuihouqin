/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lcworld.utils;
import java.util.Map;


/**
 * 
 * @author yangyang 
 */
public class WebAppConfig {
	private static final String CONFIG_FILE_BASE = "system.properties";
	private static WebAppConfig config = new WebAppConfig();
	private Map<String, String> properties;

	private WebAppConfig() {
		init();
	}

	private void init() {
		// 读取webapp通用配置
		PropertiesFileReader reader1 = new PropertiesFileReader(CONFIG_FILE_BASE);
		properties = reader1.getProperties();
		properties = PropertiesFileReader.mergeProperties(properties,null);
	}

	public static WebAppConfig getInstance() {
		return config;
	}


	/*---------------------读取文件辅助---------------------*/

	public String getAsString(String pName) {
		return properties.get(pName);
	}

	public int getAsInt(String pName) {
		return Integer.parseInt(getAsString(pName));
	}

	public long getAsLong(String pName) {
		return Long.parseLong(getAsString(pName));
	}

	public boolean getAsBoolean(String pName) {
		return Boolean.parseBoolean(getAsString(pName));
	}

	public double getAsDouble(String pName) {
		return Double.parseDouble(getAsString(pName));
	}
  public String getFullPath(String urlPath){
	  String remoteIPAddress=WebAppConfig.getInstance().getAsString("remoteIPAddress");
	   urlPath=remoteIPAddress+urlPath;
	   return urlPath;
  }

	public static  void main(String args[]){
	String dd=	WebAppConfig.getInstance().getAsString("remoteIPAddress");
	System.out.println(dd);
		
	}
	
	

}
