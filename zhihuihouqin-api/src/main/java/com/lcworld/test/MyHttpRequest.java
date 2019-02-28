package com.lcworld.test;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.lcworld.utils.util.ValidateUtil;

public class MyHttpRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	private Map<String,String[]> paramMap = new HashMap<>();
	public MyHttpRequest(HttpServletRequest request2) {
		super(request2);
		this.request = request2;
		paramMap.putAll(request2.getParameterMap());
	}
	@Override
	public String getParameter(String name) {
		String[] strings = paramMap.get(name);
		if (ValidateUtil.isValid(strings)) {
			return strings[0];
		}
		return null;
	}
	@Override
    public Map<String, String[]> getParameterMap() {
        return paramMap;
    }
    @Override
    public Enumeration<String> getParameterNames() {
        return this.request.getParameterNames();
    }
    @Override
    public String[] getParameterValues(String name) {
        return paramMap.get(name);
    }
    public void addParameterMap(Map<String,String[]> map){
    	paramMap.putAll(map);
    }
}
