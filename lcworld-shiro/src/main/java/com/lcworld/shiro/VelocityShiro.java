package com.lcworld.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * shiro Velocity版
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017年4月26日 下午7:37:36
 */
public class VelocityShiro {

	/**
	 * 是否拥有该权限
	 * @param permission  权限标识
	 * @return   true：是     false：否
	 */
	public boolean hasPermission(String permission) {
		Subject subject = SecurityUtils.getSubject();
		return subject != null && subject.isPermitted(permission);
	}

}
