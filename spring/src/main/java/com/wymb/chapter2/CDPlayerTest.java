package com.wymb.chapter2;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CDPlayerTest {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
		SgtPeppers sgtPeppers = (SgtPeppers) context.getBean("sgtPeppers");
		sgtPeppers.play();
	}

}
