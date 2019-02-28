package com.lcworld.utils;

import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.client.utils.URLEncodedUtils;

import com.alibaba.fastjson.JSONObject;

public class GeoUtil {  
	
//	private static String Url = "http://api.map.baidu.com/direction/v2/transit";
	private static String Url = "http://api.map.baidu.com/direction/v1";
	private static String AK = "G4DaPolrvAiR3hr7GsGCpCzQyHo9FsfN";
	private static String getGeo(Double lon1,  Double lat1,Double lon2,  Double lat2){
		
		HttpClient client = new HttpClient(); 

		client.getParams().setContentCharset("GBK");
		String allUri = Url + "?mode=walking&type=2&origin="+lat1+","+lon1+"&destination="+lat2+","+lon2+"&ak="+AK+"&output=json&region="+URLEncoder.encode("北京");
		GetMethod method = new GetMethod(allUri);
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
		try {
			client.executeMethod(method);
			String submitResult =method.getResponseBodyAsString();
			return submitResult;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

    public static void main(String[] args) {
		System.out.println("1距离是："+getDistance(116.422563, 40.012165, 116.422464, 40.011988));
		System.out.println("2距离是："+getDistance(116.425294, 40.009191, 116.422464, 40.011988));
		System.out.println("3距离是："+getDistance(116.422132, 40.011617, 116.422464, 40.011988));
		System.out.println("4距离是："+getDistance(116.414204, 40.012024, 116.422464, 40.011988));
		System.out.println("5距离是："+getDistance(116.410153, 40.014228, 116.422464, 40.011988));
		System.out.println("6距离是："+getDistance(116.399032, 40.016233, 116.422464, 40.011988));
		System.out.println("x距离是："+getDistance(116.413391,40.008334, 116.422464, 40.011988));
	}
    public static Integer getDistance(Double lon1,  Double lat1,Double lon2,  Double lat2){
//    	String geo = getGeo(116.398991,40.016212, 116.398129,40.008503);
//    	String geo = getGeo(lon1, lat1, lon2, lat2);
//		JSONObject geoObj = JSONObject.parseObject(geo);
//		JSONObject rem = JSONObject.parseObject(geoObj.getJSONObject("result").getJSONArray("routes").get(0).toString());
//		Integer distance = rem.getInteger("distance");
//		System.out.println(geoObj.getJSONObject("result").getJSONObject("taxi"));
//		return distance;
    	// 维度  
        double latL1 = (Math.PI / 180) * lat1;  
        double latL2 = (Math.PI / 180) * lat2;  
  
        // 经度  
        double lonL1 = (Math.PI / 180) * lon1;  
        double lonL2 = (Math.PI / 180) * lon2;  
  
        // 地球半径  
        double R = 6371;  
  
        // 两点间距离 km，如果想要米的话，结果*1000就可以了  
        double d = Math.acos(Math.sin(latL1) * Math.sin(latL2) + Math.cos(latL1) * Math.cos(latL2) * Math.cos(lonL2 - lonL1)) * R;  
        int d1 = (int)(d*1000);
        return d1;
    }
    
    
} 
