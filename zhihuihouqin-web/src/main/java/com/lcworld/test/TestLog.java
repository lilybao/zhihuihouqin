package com.lcworld.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestLog {

	private static Logger log = LoggerFactory.getLogger(TestLog.class);
	public static void main(String[] args) {
		log.debug("debug.....123123");
	}
}
