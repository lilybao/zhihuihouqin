package com.lcworld.validator;

import org.apache.commons.lang.StringUtils;

import com.lcworld.utils.RRException;

/**
 * 测试数据校验
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017年4月19日 上午11:26:53
 */
public abstract class Assert {

	public static void isBlank(String str, String message) {
		if (StringUtils.isBlank(str)) {
			throw new RRException(message, 1);
		}
	}

	public static void isNotBlank(String str, String message) {
		if (!StringUtils.isBlank(str)) {
			throw new RRException(message, 1);
		}
	}

	public static void isNull(Object object, String message) {
		if (object == null) {
			throw new RRException(message, 1);
		}
	}

	public static void isNull(Long[] object, String message) {
		if (object.length == 0) {
			throw new RRException(message, 1);
		}
	}

	/**
	 * 
	 * @param message
	 *            错误信息
	 * @param object
	 *            待校验的多个对象
	 */
	public static void isNull(String message, Object... object) {
		if (object.length == 0) {
			throw new RRException(message, 1);
		}

		for (int i = 0; i < object.length; i++) {

			if (object[i] instanceof String) {

				String str = (String) object[i];

				if (StringUtils.isBlank(str)) {
					throw new RRException(message, 1);
				}
			} else {
				if (object[i] == null) {
					throw new RRException(message, 1);
				}

			}

		}
	}

}
