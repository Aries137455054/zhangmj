package com.wymb.initialize;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Person
		implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
	private String name;
	private int age;
	private String sex;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("执行setName属性");
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("执行setAge属性");
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		System.out.println("执行setSex属性");
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

	public void init() {
		System.out.println("执行自定义的初始化init方法");
	}

	public void destory() {
		System.out.println("执行自定义的destory方法");
	}

	public void fun() {
		System.out.println("执行fun方法");
	}
	public Person() {
		System.out.println("执行构造方法");
	}

	public void setBeanName(String name) {
		System.out.println("执行BeanNameAware的setBeanName()方法");
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("执行BeanFactoryAware的setBeanFactory()方法");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("执行ApplicationContextArea的setApplicationContext()方法");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("执行InitializingBean的afterPropertiesSet()方法");
	}

	public void destroy() throws Exception {
		System.out.println("执行DisposableBean的destroy()方法");
	}
}
