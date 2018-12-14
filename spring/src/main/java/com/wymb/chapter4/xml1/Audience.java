package com.wymb.chapter4.xml1;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {

	public void method1(JoinPoint jp){
		@SuppressWarnings("unchecked")
		List<String> list = (List) jp.getArgs()[0];
		for (String string : list) {
			System.out.println("传递的参数："+string);
		}
		System.out.println("method1()");
	}
	
	public void method2(){
		System.out.println("method2()");
	}
	
	public void method3(){
		System.out.println("method3()");
		System.out.println("返回通知。。。。。。。。。。");
	}
	
	public void around(ProceedingJoinPoint jp){
		try {
			@SuppressWarnings("unchecked")
			List<String> list = (List<String>) jp.getArgs()[0];
			for (String string : list) {
				System.out.println("参数："+string);
			}
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("环绕通知。。。。。。");
	}
}
