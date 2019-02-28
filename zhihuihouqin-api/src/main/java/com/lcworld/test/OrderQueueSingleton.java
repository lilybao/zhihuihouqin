package com.lcworld.test;

public class OrderQueueSingleton{
	private static SearchQueue queue = new SearchQueue();
	private OrderQueueSingleton(){
		
	}
	public static SearchQueue getQueue(){
		return queue;
	}
}
