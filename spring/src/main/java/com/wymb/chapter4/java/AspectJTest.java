package com.wymb.chapter4.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectJTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConcertConfig.class);
		Audience bean = (Audience) context.getBean("audience");
		Performance performance = (Performance) context.getBean("performance");
		performance.perform();
	}
}
