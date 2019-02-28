package com.lcworld.utils;

import java.util.Date;

public class OrderCodeGenerator {
//	public static String createOrderCode(String uid, String merchantId) {
//		
//		StringBuffer sbf = new StringBuffer();
//		sbf.append(uid.substring(uid.length() - 2, uid.length()));
//		String cur = new Long(System.currentTimeMillis()).toString();
//		sbf.append(new Long(cur).toString().substring(2));
//		sbf.append(merchantId.substring(merchantId.length() - 2, merchantId.length()));
//		sbf.append(RanderNumberUtils.getCheckCode(1));
//		return sbf.toString();
//	}
	/**
	 * 时间戳生成订单号
	 * @param type
	 * @return
	 */
	public static String createOrderCode(Integer type) {
		StringBuffer sbf = new StringBuffer();
		if (type<10) {
			sbf.append("0"+type);
		}else{
			sbf.append(type);
		}
		long time = new Date().getTime();
		sbf.append(time);
		return sbf.toString();
	}

}
