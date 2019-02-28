package com.lcworld.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.alibaba.fastjson.JSONObject;
import com.lcworld.annotation.IgnoreToken;
import com.lcworld.entity.TokenEntity;
import com.lcworld.service.TokenService;
import com.lcworld.test.MyHttpRequest;
import com.lcworld.utils.RRException;
import com.lcworld.utils.util.ValidateUtil;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * sign验证
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017年4月19日 上午11:30:58
 */
@Component
public class TokenCheckInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private TokenService tokenService;

	public static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		IgnoreToken annotation;
		if (handler instanceof HandlerMethod) {
			annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreToken.class);
		} else {
			return true;
		}
		// 如果有@IgnoreAuth注解，则不验证token
		if (annotation != null) {
			return true;
		}

		// 从header中获取token
		String token = request.getHeader("token");
		// 如果header中不存在token，则从参数中获取token
		if (StringUtils.isBlank(token)) {
			token = request.getParameter("token");
		}

		// token为空
		if (StringUtils.isBlank(token)) {
			throw new RRException("token不能为空", 1);
		}

//		 查询token信息
		TokenEntity tokenEntity = tokenService.queryByToken(token);
		if (tokenEntity == null ) {
			throw new RRException("token无效，请重新登录", 2);
		}

		// 设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute(LOGIN_USER_KEY,tokenEntity.getUserId());
        
        //将request强转为他的包装类并将uid保存入biz中
//        MyHttpRequest httpRequest = (MyHttpRequest)request;
//        HashMap<String,String[]> bizMap = new HashMap<>();
//		String biz = httpRequest.getParameter("biz");
//		JSONObject bizObj = JSONObject.parseObject(biz);
//		bizObj.put("uid", 1);
//		bizMap.put("biz",new String[] {bizObj.toJSONString()});
//		httpRequest.addParameterMap(bizMap);
		return true;
	}
}
