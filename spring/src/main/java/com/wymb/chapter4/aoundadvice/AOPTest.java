package com.wymb.chapter4.aoundadvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 环绕通知，通知中的参数传递
 * @author Administrator
 *
 */
public class AOPTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext("D:\\development\\eclipse\\workspace\\spring\\src\\main\\java\\com\\wymb\\chapter4\\aoundadvice\\spring.xml");
		Performance performance = (Performance) context.getBean("performanceImpl");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		performance.perform(list);
	}
}
