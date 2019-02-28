package com.lcworld.utils.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.lcworld.utils.wxutil.ConstantUtil;
import com.lcworld.utils.wxutil.MD5;
import com.lcworld.utils.wxutil.MD5Util;
import com.lcworld.utils.wxutil.OrderUtil;

import net.sf.json.JSONObject;


/**
 * 微信调起支付类
 * 
 * @author Sunlight
 * 
 */
public class WXPay {
//	public static String createPackageValue(String appid, String appKey, String prepay_id)  {
//		SortedMap<String, String> nativeObj = new TreeMap<String, String>();
//		nativeObj.put("appId", appid);
//		nativeObj.put("timeStamp", OrderUtil.GetTimestamp());
//		Random random = new Random();
//		String randomStr = MD5.GetMD5String(String.valueOf(random.nextInt(10000)));
//		nativeObj.put("nonceStr", MD5Util.MD5Encode(randomStr, "utf-8").toLowerCase());
//		nativeObj.put("package", "prepay_id=" + prepay_id);
//		nativeObj.put("signType", "MD5");
//		nativeObj.put("paySign", createSign(nativeObj, appKey));
//		System.out.println(JSONObject.fromObject(nativeObj).toString());
//		return JSONObject.fromObject(nativeObj).toString();
//	}
	public static String createPublicPackageValue(String appid, String appKey, String prepay_id)  {
		SortedMap<String, String> nativeObj = new TreeMap<String, String>();
		nativeObj.put("appId", appid);
		nativeObj.put("timeStamp", OrderUtil.GetTimestamp());
		Random random = new Random();
		String randomStr = MD5.GetMD5String(String.valueOf(random.nextInt(1000000)));
		nativeObj.put("nonceStr", MD5Util.MD5Encode(randomStr, "utf-8").toLowerCase());
		nativeObj.put("package", "prepay_id=" + prepay_id);
		nativeObj.put("signType", "MD5");
		nativeObj.put("paySign", createSign(nativeObj, appKey));
		return new org.json.JSONObject(nativeObj).toString();
	}
	public static String createPackageValue(String appid, String appKey, String prepay_id)  {
		SortedMap<String, String> nativeObj = new TreeMap<String, String>();
		nativeObj.put("appid", appid);
		nativeObj.put("timestamp", OrderUtil.GetTimestamp());
		Random random = new Random();
		String randomStr = MD5.GetMD5String(String.valueOf(random.nextInt(10000)));
		System.out.println("randomStr="+randomStr);
		nativeObj.put("noncestr", MD5Util.MD5Encode(randomStr, "utf-8").toLowerCase());
		nativeObj.put("package", "Sign=WXPay");
//		nativeObj.put("signType", "MD5");
		nativeObj.put("prepayid", prepay_id);
		nativeObj.put("partnerid", ConstantUtil.PARTNER);
		String sign = createSign(nativeObj, appKey);
		System.out.println("sign="+sign);
		nativeObj.put("paySign", sign);
		System.out.println(new org.json.JSONObject(nativeObj).toString());
		return new org.json.JSONObject(nativeObj).toString();
	}

	/**
	 * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 */
	public static String createSign(SortedMap<String, String> packageParams, String AppKey) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + AppKey);
		System.out.println("sb="+sb.toString());
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
		return sign;
	}
}
