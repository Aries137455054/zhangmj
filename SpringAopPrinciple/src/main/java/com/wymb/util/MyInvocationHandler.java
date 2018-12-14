package com.wymb.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

	private Object targetObj;
	public MyInvocationHandler(Object targetObj){
		this.targetObj = targetObj;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("权限验证");
		Object resultObj = method.invoke(targetObj, args);
		System.out.println("日志记录");
		return resultObj;
	}

}
