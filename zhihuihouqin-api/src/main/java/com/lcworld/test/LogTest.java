package com.lcworld.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
	private Logger log = LoggerFactory.getLogger(LogTest.class);
	public static void main(String[] args) {
//		log.debug("我是好人");
	}
	@Test
	public void myTest(){
		log.debug("神经呀");
	}
}
