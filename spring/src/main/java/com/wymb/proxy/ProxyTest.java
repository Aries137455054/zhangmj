package com.wymb.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		//System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
		
		Subject subject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[]{Subject.class}, new MyInvocationHandler(new SubjectImpl()));
		System.out.println(subject.getClass().getName());
		subject.giveMoney();
		subject.sendMoney();
	}
}
