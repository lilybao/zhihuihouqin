package com.lcworld.utils.util;

import java.util.Collection;

public class ValidateUtil {

	/**
	 * �?��字符�?
	 */
	public static boolean isValid(Object str){
		if(str == null || "".equals(str)||"null".equals(str)){
			return false ;
		}
		return true ;
	}
	/**
	 * �?��字符�?
	 */
	public static boolean isValid(String str){
		if(str == null || "".equals(str.trim())||"null".equals(str)){
			return false ;
		}
		return true ;
	}
	
	/**
	 * �?��集合
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isValid(Collection col){
		if(col == null || col.isEmpty()){
			return false ;
		}
		return true ;
	}

	/**
	 * �?��数组
	 */
	public static boolean isValid(Object[] arr) {
		if(arr == null || arr.length == 0){
			return false;
		}
		return true ;
	}

}
