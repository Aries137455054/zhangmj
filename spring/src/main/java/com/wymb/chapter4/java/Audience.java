package com.wymb.chapter4.java;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	
	@Pointcut("execution(** com.wymb.chapter4.java.PerformanceImpl.perform(..))")
	public void per(){};
	
	@Before("per()")
	public void silenceCellPhones(){
		System.out.println("表演之前-手机静音");
	}
	
	@Before("per()")
	public void takeSeats(){
		System.out.println("表演之前-坐下");
	}
	
	@AfterReturning("per()")
	public void applause(){
		System.out.println("表演之后-鼓掌");
	}
	
	@AfterReturning("per()")
	public void demandRefund(){
		System.out.println("表演结束-回家");
	}
	
	@AfterThrowing("per()")
	public void goBack(){
		System.out.println("异常处理。。。。。。。。。。。。。。。。。。。。。。");
	}
	
	
/*	@Before("execution(** com.wymb.chapter4.PerformanceImpl.perform(..))")
	public void silenceCellPhones(){
		System.out.println("表演之前-手机静音");
	}
	
	@Before("execution(** com.wymb.chapter4.PerformanceImpl.perform(..))")
	public void takeSeats(){
		System.out.println("表演之前-坐下");
	}
	
	@AfterReturning("execution(** com.wymb.chapter4.PerformanceImpl.perform(..))")
	public void applause(){
		System.out.println("表演之后-鼓掌");
	}
	
	@AfterReturning("execution(** com.wymb.chapter4.PerformanceImpl.perform(..))")
	public void demandRefund(){
		System.out.println("表演结束-回家");
	}
	
	@AfterThrowing("execution(** com.wymb.chapter4.PerformanceImpl.perform(..))")
	public void goBack(){
		System.out.println("异常处理。。。。。。。。。。。。。。。。。。。。。。");
	}*/
	
}


