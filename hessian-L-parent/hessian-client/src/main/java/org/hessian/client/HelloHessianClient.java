package org.hessian.client;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.hessian.api.HelloHessian;
import org.hessian.api.bean.Person;

import com.caucho.hessian.client.HessianProxyFactory;

/**
 * 客户端调用远程对象
 * 
 * @author zhangmingjie
 * @date 2018年12月14日 下午4:36:35
 * @version 1.0
 */
public class HelloHessianClient {
	
	public static String urlName = "http://localhost:8080/hessian-server/HelloHessian";
	//public static String urlName = "http://39.108.226.62:8080/hessian-server/HelloHessian";

	public static void main(String[] args) {
		HessianProxyFactory factory = new HessianProxyFactory();

		// 开启方法重载
		factory.setOverloadEnabled(true);
		HelloHessian helloHessian = null;
		try {
			helloHessian = (HelloHessian) factory.create(HelloHessian.class, urlName);

			System.out.println(helloHessian.sayHello());
			System.out.println(helloHessian.sayHello("张明杰"));
			List<Person> persons = helloHessian.getPersons();
			for (Person person : persons) {
				if (person != null) {
					System.out.println(person.toString());
				}
			}

			Person person = helloHessian.getPersonById(2);
			if (person != null) {
				System.out.println("id为2的用户是："+person.toString());
			}
			
			
			
			
			
			// 上传文件
			String fileName = "upload.txt";
			String filePath = System.getProperty("user.dir") + "/upload/" + fileName;
			
			System.out.println("!!!!!!!!!!:"+filePath);
			InputStream data = null;
			try {
				data = new BufferedInputStream(new FileInputStream(filePath));
				if (helloHessian.uploadFile(fileName, data)) {
					System.out.println("Upload file " + filePath + " succeed.");
				} else {
					System.out.println("Upload file " + filePath + " failed.");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				IOUtils.closeQuietly(data);
			}

			// 下载文件
			fileName = "download.txt";
			filePath = System.getProperty("user.dir") + "/upload/" + fileName;
			try {

				byte[] temp = helloHessian.downloadFile(fileName);
				if (null != temp) {
					FileWriter output = new FileWriter(filePath);
					IOUtils.write(temp, output, "UTF-8");
					System.out.println("Download file " + filePath + " succeed.");
					output.close();
				} else {
					System.out.println("Download file " + filePath + " failed.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			
			
			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		
		
		
	}
}
