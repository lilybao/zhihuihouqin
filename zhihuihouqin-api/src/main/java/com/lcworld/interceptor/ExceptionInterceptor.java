package com.lcworld.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.lcworld.exception.ZHHQException;
import com.lcworld.utils.R;

@Component
public class ExceptionInterceptor implements HandlerInterceptor {

	// 7天

	private Log log = LogFactory.getLog(ExceptionInterceptor.class);

	public ExceptionInterceptor() {
	}

	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用
	 * 
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (ex != null) {
			log.error(ex);
			if(ex instanceof ZHHQException){
			    responseData(new R(((ZHHQException)ex).getErrorCode(),((ZHHQException)ex).getErrMsg()) ,response);
			}else{
			    responseData(new R(R.EXCEPTIONCODE, R.EXCEPTION), response);
			}
		}
	}

	private void responseData(R responceResult, HttpServletResponse response) {

		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(JSON.toJSON(responceResult));
			out.flush();
			out.close();
		} catch (IOException e) {
			log.error(e);
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

}