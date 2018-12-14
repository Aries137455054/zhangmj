package com.wymb.initialize;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("调用BeanPostProcessor的postProcessBeforeInitialization()预初始化方法");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("调用BeanPostProcessor的postProcessBeforeInitialization()初始化后的方法");
		return bean;
	}
}
