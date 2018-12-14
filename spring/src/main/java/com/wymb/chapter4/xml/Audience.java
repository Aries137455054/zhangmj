package com.wymb.chapter4.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	
	@Pointcut("execution(** com.wymb.chapter4.xml.PerformanceImpl.perform(..))")
	public void per(){};
	
	@Before("per()")
	public void silenceCellPhones() {
		System.out.println("表演之前-手机静音");
	}
}
