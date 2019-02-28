package com.lcworld.aop;

import com.alibaba.fastjson.JSON;
import com.lcworld.annotation.SysLog;
import com.lcworld.entity.SysLogEntity;
import com.lcworld.service.SysLogService;
import com.lcworld.utils.HttpContextUtils;
import com.lcworld.utils.IPUtils;
import com.lcworld.utils.ShiroUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 日志切面
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017年4月19日 上午10:37:15
 */
@Aspect
@Component
public class SysLogAspect {
	@Autowired
	private SysLogService sysLogService;

	@Pointcut("@annotation(com.lcworld.annotation.SysLog)")
	public void logPointCut() {
		

	}

	@Before("logPointCut()")
	public void saveSysLog(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		SysLogEntity sysLog = new SysLogEntity();
		SysLog syslog = method.getAnnotation(SysLog.class);
		if (syslog != null) {
			// 注解上的描述
			sysLog.setOperation(syslog.value());
		}

		// 请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");

		// 请求的参数
		Object[] args = joinPoint.getArgs();
		String params = JSON.toJSONString(args[0]);
		sysLog.setParams(params);

		// 获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		// 设置IP地址
		sysLog.setIp(IPUtils.getIpAddr(request));

		// 用户名
		String username = ShiroUtils.getUserEntity().getUsername();
		sysLog.setUsername(username);

		sysLog.setCreateDate(new Date());
		// 保存系统日志
		sysLogService.save(sysLog);
	}

}
