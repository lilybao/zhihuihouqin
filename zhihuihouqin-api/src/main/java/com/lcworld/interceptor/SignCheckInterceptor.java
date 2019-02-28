package com.lcworld.interceptor;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.lcworld.annotation.IgnoreSign;
import com.lcworld.utils.RRException;
import com.lcworld.xss.XssHttpServletRequestWrapper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * sign验证
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017年4月19日 上午11:30:58
 */
@Component
public class SignCheckInterceptor extends HandlerInterceptorAdapter {

	public static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";

	public static final String SECRETKEY = "zxcadsadwa@2321$";

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		IgnoreSign annotation;
		if (handler instanceof HandlerMethod) {
			annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreSign.class);
		} else {
			return true;
		}
		String biz = request.getParameter("biz");
//		XssHttpServletRequestWrapper request = (XssHttpServletRequestWrapper) request1;

		// 如果有@IgnoreSign注解，则不验证sign
		if (annotation != null) {
			return true;
		}

		// 从header中获取sign
		String sign = request.getHeader("sign");
		// 如果header中不存在sign，则从参数中获取sign
		if (StringUtils.isBlank(sign)) {
			sign = request.getParameter("sign");
		}

		// sign为空
		if (StringUtils.isBlank(sign)) {
			throw new RRException("sign不能为空", 1);
		}


		String timestamp = request.getParameter("timestamp");

		String signString = URLEncoder.encode(biz, "UTF-8") + timestamp + SECRETKEY;

		String serverSign = DigestUtils.md5Hex(signString);
		
		if (!sign.equals(serverSign)) {
			throw new RRException("sign错误!", 1);
		}
		return true;

	}
	
/*	public static void main(String[] args) throws UnsupportedEncodingException {
		
		JSONObject biz = new JSONObject();
		biz.fluentPut("uid", "11");
		String str = URLEncoder.encode(biz.toJSONString(), "UTF-8");
		
		System.out.println(str);
	}*/
}
