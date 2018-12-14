package com.wymb.chapter4.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AOPTest {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("D:\\development\\eclipse\\workspace\\spring\\src\\main\\java\\com\\wymb\\chapter4\\xml\\spring.xml");
		Performance performance = (Performance) context.getBean("performanceImpl");
		performance.perform();
	}
}
