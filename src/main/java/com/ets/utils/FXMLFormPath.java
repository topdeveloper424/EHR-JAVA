package com.ets.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FXMLFormPath {

	public static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

	public void closeApplicationContext() {
		this.context.close();
	}

}
