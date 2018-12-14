package com.wymb.chapter4.xml1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 在XML中声明切面
 * @author zhangmingjie
 * @date 2018年12月12日 下午4:06:42 
 * @version 1.0
 */
public class Test1 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext("D:\\development\\eclipse\\workspace\\spring\\src\\main\\java\\com\\wymb\\chapter4\\xml1\\spring.xml");
		Performance performance = (Performance) context.getBean("performanceImpl");
		List<String> list = new ArrayList<String>();
		list.add("AAA");
		performance.giveMoney(list);
		
		
		
		/**
		 * 引入新方法
		 */
		StudentAdditionalDetail obj = (StudentAdditionalDetail) context.getBean("studentAdditionalDetailImpl");
		((Student)obj).showDetails();
		obj.showAdditionalDetails();
	}
}
