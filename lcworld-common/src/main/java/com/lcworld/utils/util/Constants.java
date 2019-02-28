package com.lcworld.utils.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class Constants {
	public final static String excelPath="upload"+File.separator+"excel";
	public static final String splitReg=";";
	public static final String PROGREM_NAME_API = "lcworld-api";
	public static final String FILE_MANAGER = "fileManagerXYDJ"+File.separator+"upload";
	
	/**
	 * 版本存放路径
	 */
	public static final String VersionPath=FILE_MANAGER+File.separator+"version";
	/**ftl模板存放位置*/
	public static final String ftlPath=FILE_MANAGER+File.separator+"ftl";

	/**UE存放地址*/
	public static final String ueditorPath="/fileManagerQishifu/upload/ueditor/";
	
	
	public static final int PAGE_SIZE=10;
	public static final int PAGE_SIZE10=10;
	public static final int PAGE_SIZE5=5;
	public static final String IMG_FILE_PATH="";
	public static final String QUESTION_CACHE_VERSION="question1";
	public static final String QUESTION_WITH_CACHE_VERSION="questionWithAnswer1";
	
	
	public static String ftlFilePath(HttpServletRequest request) {
		String path =request.getContextPath().replace("resources", ftlPath);
		return path;
	}
	
	public static String VersionFilePath(HttpServletRequest request){
		String url="http://" + request.getServerName() //服务器地址    
        + ":"     
        + request.getServerPort()           //端口号    
        + "/fileManagerQishifu/upload/version/"; 
		
	//	String path =request.getContextPath().replace("resources", "fileManagerQishifu/upload/version/");
		return url;		
	}
	
	public static String imgFilePath(HttpServletRequest request) {
		String path =request.getContextPath().replace("resources", "fileManagerQishifu/upload/photo/");
		return path;
	}
	
	public static String imgRealFilePath(HttpServletRequest request){
    	String absolutePath=request.getRealPath("").replace(Constants.PROGREM_NAME_API,
				Constants.FILE_MANAGER)+File.separator+"photo";
    	
    	return absolutePath;
	}
	
	public static String getUploadDir(String name) {
		String path="upload"+File.separator+name+File.separator;
		if(path.indexOf("\\")>-1){
			path=path.replace("\\", "/");
		}
		return path;
	}
	public static String getUploadDirStr(String name) {
		String[] arr=name.split(Constants.splitReg);
		StringBuilder sb=new StringBuilder();
		sb.append("upload").append(File.separator);
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i]).append(File.separator);
		}
		String path=sb.toString();
		if(path.indexOf("\\")>-1){
			path=path.replace("\\", "/");
		}
		if(path.length()>0&&path.lastIndexOf("/")>0){
			path=path.substring(0, path.lastIndexOf("/"));
		}
		return path;
	}
	public static final String DEFAUT_PASSWORD = "123456";
	public static final String currentUser = "user";
	public static final String TITLE = "七师傅驾校系统";
	public static final String LINE_DOWN = "_";
	public static final int PAGE_THREE = 3;
	public static final String TEST = "test";
	public static final int DAYS = 15;
}
