package com.lcworld.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
/**
 * fastjson工具类
 *
 * @author Administrator
 * @email xlfbe696@gmail.com
 * @date 2017年7月12日 下午2:27:42
 */
public class FastJSONUtils {

	public static <T> T getObject(String biz, Class<T> clazz) {

		T obj = JSON.parseObject(biz, clazz);

		return obj;

	}

	public static JSONObject getJSONObject(String biz) {

		JSONObject obj = (JSONObject) JSON.parse(biz);

		return obj;

	}
}
