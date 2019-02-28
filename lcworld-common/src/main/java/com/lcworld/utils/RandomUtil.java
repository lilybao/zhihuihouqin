package com.lcworld.utils;
import java.util.Random;

public class RandomUtil {

	public static String randomFor6() {
		Random random = new Random();
		String result = "";
		for (int i = 0; i < 6; i++) {
			result += random.nextInt(10);
		}
//		System.out.print(result);
		return result;
	}
	public static Integer randomForSize(Integer size){
		Random random = new Random();
		int randomNum = random.nextInt(size);
		return randomNum;
	}
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			Integer r = randomForSize(6);
			System.out.println(r);
		}
	}
}
