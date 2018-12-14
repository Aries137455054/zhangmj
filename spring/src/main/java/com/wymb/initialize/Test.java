package com.wymb.initialize;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		//ApplicationContext context = new FileSystemXmlApplicationContext("D:\\development\\eclipse\\workspace\\spring\\src\\main\\java\\com\\wymb\\initialize\\bean.xml");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/com/wymb/initialize/bean.xml");
		context.close();
	}
}
