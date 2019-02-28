package com.lcworld.utils;

/**
 * Created by yuliang on 2015/3/20.
 */
public class DistanceUtils {
	private static double EARTH_RADIUS = 6378.137;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 通过经纬度获取距离(单位：米)
	 * 
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return
	 */
	public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(
				Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 100000d) / 100000d;
		s = s * 1000;
		return s;
	}

	/**
	 * 高德地图计算两个点之间距离的算法
	 * @param longitude1
	 * @param latitude1
	 * @param longitude2
	 * @param latitude2
	 * @return
	 */
	public static float calculateLineDistance(double longitude1, double latitude1, double longitude2,
			double latitude2) {
		double var2 = 0.01745329251994329D;
		double var4 = longitude1;
		double var6 = latitude1;
		double var8 = longitude2;
		double var10 = latitude2;
		var4 *= 0.01745329251994329D;
		var6 *= 0.01745329251994329D;
		var8 *= 0.01745329251994329D;
		var10 *= 0.01745329251994329D;
		double var12 = Math.sin(var4);
		double var14 = Math.sin(var6);
		double var16 = Math.cos(var4);
		double var18 = Math.cos(var6);
		double var20 = Math.sin(var8);
		double var22 = Math.sin(var10);
		double var24 = Math.cos(var8);
		double var26 = Math.cos(var10);
		double[] var28 = new double[3];
		double[] var29 = new double[3];
		var28[0] = var18 * var16;
		var28[1] = var18 * var12;
		var28[2] = var14;
		var29[0] = var26 * var24;
		var29[1] = var26 * var20;
		var29[2] = var22;
		double var30 = Math.sqrt((var28[0] - var29[0]) * (var28[0] - var29[0])
				+ (var28[1] - var29[1]) * (var28[1] - var29[1]) + (var28[2] - var29[2]) * (var28[2] - var29[2]));
		return (float) (Math.asin(var30 / 2.0D) * 1.27420015798544E7D);
	}

	public static void main(String[] args) {
		float distance = calculateLineDistance(116.469515, 39.926465, 116.469411, 39.926461);

		System.out.println(distance);
	}

}