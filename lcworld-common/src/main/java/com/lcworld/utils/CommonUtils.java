package com.lcworld.utils;

public class CommonUtils {
	public static String concatWithSeparater(Object[] arr,String separater){
		if (ValidateUtil.isValid(arr)) {
			StringBuffer str = new StringBuffer();
			for (int i = 0; i < arr.length; i++) {
				str.append(arr[i].toString());
				//xxxxxxx
				str.append(separater);
			}
			return str.substring(0, (str.length()-separater.length()));
		}
		return null;
	}
	public static void main(String[] args) {
		String[] a = {"123","456","789"};
		String concatWithSeparater = concatWithSeparater(a, "#@!");
		System.out.println(concatWithSeparater);
	}
}