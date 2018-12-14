package com.wymb.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MyInvocationHandler implements InvocationHandler {

	public Object target;

	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	public void print1(){
		System.out.println("打印1");
	}
	public void print2(){
		System.out.println("打印2");
	}
	public void print3(){
		System.out.println("打印3");
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		print1();
		Object object = method.invoke(target, args);
		print2();
		print3();
		return object;
	}
	
}
