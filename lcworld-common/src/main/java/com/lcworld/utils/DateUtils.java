package com.lcworld.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月21日 下午12:53:33
 */
public class DateUtils {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
    public static Date getDate(Date date, int calendarType, int amount) {
    	if(date != null){
    		Calendar calen = Calendar.getInstance();
    		calen.setTime(date);
    		calen.add(calendarType, amount);
    		return calen.getTime();
    	}
    	return null;
    }
    public static Date parse(String date, String pattern) {
    	if(date != null){
    		SimpleDateFormat df = new SimpleDateFormat(pattern);
    		try {
				return df.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
    	}
    	return null;
    }
}
