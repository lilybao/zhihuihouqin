package com.lcworld.utils.wxutil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderUtil {

	static Date today = new Date();
	static int orderIndex = 0;

	@SuppressWarnings("deprecation")
	private static String getIndex() {

		Date n = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String currTime = outFormat.format(n);

		if (orderIndex > 0) {
			if (n.getYear() == today.getYear() && n.getMonth() == today.getMonth() && n.getDay() == today.getDay()) {
				orderIndex += 1;
			} else {
				today = n;
				orderIndex = 1;
			}
		} else {
			today = n;
			orderIndex = 1;
		}
		if (orderIndex > 999999) {
			orderIndex = 1;
		}
		String indexString = String.format("%s%06d", currTime, orderIndex);
		return indexString;
	}

	/**
	 * 生成订单号
	 * 
	 * @param preFixString
	 * @return
	 */
	public static String GetOrderNumber(String preFixString) {
		String orderNumberString = preFixString + getIndex();
		return orderNumberString;
	}

	/**
	 * 获取时间戳
	 * 
	 * @return
	 */
	public static String GetTimestamp() {
		return Long.toString(new Date().getTime() / 1000);
	}

	/**
	 * 生成随机数
	 * 
	 * @return
	 */
	public static String CreateNoncestr() {
		Random random = new Random();
		return MD5.GetMD5String(String.valueOf(random.nextInt(10000)));
	}
	
	public static synchronized String getVisitCode(int length)     
	{     
	    String val = "";     
	             
	    Random random = new Random();     
	    for(int i = 0; i < length; i++)     
	    {     
	        String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字     
	                 
	        if("char".equalsIgnoreCase(charOrNum)) // 字符串     
	        {     
	            int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; //取得大写字母还是小写字母     
	            val += (char) (choice + random.nextInt(26));     
	        }     
	        else if("num".equalsIgnoreCase(charOrNum)) // 数字     
	        {     
	            val += String.valueOf(random.nextInt(10));     
	        }     
	    }     
	             
	    return val.toLowerCase();     
	} 
	public static void main(String[] args) {
		System.out.println(getVisitCode(8));
	}
}
