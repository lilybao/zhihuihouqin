package com.lcworld.utils.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

	
	public static Map<String, Object> putToMap(Object ... obj) {
		Map<String, Object> resultMap=new HashMap<>();
		if(ValidateUtil.isValid(obj))
		for(int i=0;i<obj.length;i++){
			if(i%2==0){
				resultMap.put(obj[i]+"", obj[i+1]);
			}
		}
		return resultMap;
	}

}
