package com.wymb.chapter4.aoundadvice;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	
	@Pointcut("execution(** com.wymb.chapter4.aoundadvice.PerformanceImpl.perform(..))")
	public void per(){};
	
	@Around("per()")
	public void silenceCellPhones(ProceedingJoinPoint jp) {
		System.out.println("表演1");
		try {
			System.out.println("表演2");
			jp.proceed();
			@SuppressWarnings("unchecked")
			List<String> list = (List<String>) jp.getArgs()[0];
			for (String string : list) {
				System.out.println(string);
			}
			
			
			System.out.println("表演3");
			System.out.println("表演4");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	
}
