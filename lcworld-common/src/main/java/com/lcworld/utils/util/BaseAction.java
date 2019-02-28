package com.lcworld.utils.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class BaseAction{
//  protected transient OauthService oauthService = BeanProvider.getBean(OauthService.class);
	private Map<String, Object> codeMap = new HashMap<String, Object>();
//	protected Map<String, Object> conditionMap = new HashMap<String, Object>();
	protected String splitN="\n";
	protected static RandomID r=new RandomID();
	
	public void outSysString(Object str){
//		System.out.println(str);
	}
	public void outSysStringPrint(Object str){
		System.out.println(str);
	}
	public int getPage(String page) {
		return ValidateUtil.isValid(page)?Integer.parseInt(page):1;
	}
	public int getTotalPage(int totalCount) {
		return totalCount / Constants.PAGE_SIZE10
				+ ((totalCount % Constants.PAGE_SIZE10 == 0) ? 0 : 1);
	}
	public static String getRandomPath(String name){
		String str=name;
		if(name.indexOf(".")>-1){
			str=name.substring(name.indexOf(".")+1);
		}
		RandomID r=new RandomID();
		return r.RandomNum()+str;
	}
	public void jsonResult(Object state, String msg) {
		codeMap.put("state", state);
		codeMap.put("msg", msg);
	}

	public void jsonResult(Object state, String msg, Object data) {
		codeMap.put("state", state);
		codeMap.put("msg", msg);
		codeMap.put("data", data);
	}
	
	public void jsonSuccess(String msg) {
		jsonResult(Boolean.TRUE, msg);
	}

	public void jsonSuccess(String msg, Object data) {
		jsonResult(Boolean.TRUE, msg, data);
	}

	public void jsonError(String msg) {
		jsonResult(Boolean.FALSE, msg);
	}

	public void jsonError(String msg, Object data) {
		jsonResult(Boolean.FALSE, msg, data);
	}
	
	/**
	 * 修改-柴浩伟 limit 后跟返回的数量 和oracle不同,不是 rownum 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> page_from_A_to_C(int page,int pageSize) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		int startPage = (page - 1) * pageSize;
//		int endPage = page * rows + 1;
		//int endPage = page * rows ;
//		int endPage =  page * pageSize ;
		queryMap.put("offset", startPage);
		queryMap.put("limit", pageSize);
		return queryMap;
		
		
		
//		Map<String, Object> queryMap = new HashMap<String, Object>();
//		int startPage = (page - 1) * pageSize;
		// int endPage = page * rows + 1;
		// int endPage = page * rows ;

//		queryMap.put("startIndex", startPage);
//		queryMap.put("endIndex", pageSize - 1);
//		return queryMap;
	}
	
	public JSONObject getJsonInfo(HttpServletRequest request) {
		String info=request.getParameter("info");
		outSysStringPrint("info:"+info);
		JSONObject json=new JSONObject(info);
		return json;
	}
	
    
	public Map<String, Object> outJsonObjectSuccess(HttpServletResponse response,Object object){
	 Map<String, Object> json =new HashMap<>();
	 json.put("errCode", 0);
	 json.put("msg", "操作成功");
	 json.put("result",object);
	 return json;
 }
    public Map<String, Object> outJsonObjectSuccess(Object object){
		Map<String, Object> json =new HashMap<>();
		json.put("errCode", 0);
		json.put("msg", "操作成功");
		json.put("result",object);
		return json;
//		return AesUtil.encrypt(json.toString(), Constants.TEST);
	}
    
	public JSONArray getJsonArray(HttpServletRequest request) {
		String info=request.getParameter("info");
		System.out.println("info:"+info);
		JSONArray array=new JSONArray(info);
		return array;
	}
	public void outJsonStringApplication(Object str, HttpServletResponse response2) {
		try {
			response2.setCharacterEncoding("utf-8");
			response2.setContentType("text/json");
			response2.getWriter().write(str.toString());
		} catch (IOException e) {
//			
		}
	}
	
	public Map<String, Object> outJsonObjectFail(Object object,HttpServletResponse response){
		Map<String, Object> json = new HashMap<>();
		//0 成功 1 失败
		json.put("errCode",1);
		json.put("msg", "操作失败");
		json.put("result",object);
		return json;
//		this.outJsonStringApplication(json.toString(),response);
	}
	
	public Map<String, Object> outJsonObjectFail(String object,HttpServletResponse response){
		Map<String, Object> json = new HashMap<>();
		//0 成功 1 失败
		json.put("errCode",1);
		json.put("msg",object);
		return json;
//		this.outJsonStringApplication(json.toString(),response);
	}
	
}
