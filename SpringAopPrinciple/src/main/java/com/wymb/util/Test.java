package com.wymb.util;

import java.lang.reflect.Proxy;

import com.wymb.dao.UserDao;
import com.wymb.dao.impl.StudentDao;
import com.wymb.dao.impl.UserDaoImpl;

public class Test {
	
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		/*
		 * Spring AOP(面向切面编程)，扩展功能不修改源代码实现，采用横向抽取机制，取代了传统纵向继承体系重复性代码
		 * 横向抽取机制，底层使用动态代理方式实现 针对有接口的情况时使用JDK中的java.lang.reflect类库提供的动态代理
		 * 针对没有接口的情况时,使用Cglib框架提供的动态代理
		 */
		MyInvocationHandler handler = new MyInvocationHandler(userDao);
		
		UserDao proxyUserDao = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
				userDao.getClass().getInterfaces(), handler);
		proxyUserDao.addUser();

		System.out.println("。。。。。。。。。。。。。");

		CglibProxy proxy = new CglibProxy();
		StudentDao proxyImp = (StudentDao) proxy.getProxy(StudentDao.class);
		proxyImp.addStudent();
	}
}
