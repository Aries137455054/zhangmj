package com.wymb.chapter5.springmvc1;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {

	@RequestMapping(value = "")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "upload")
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("/")+"fileUpload";
		String fileName = String.valueOf(new Date().getTime())+"_"+file.getOriginalFilename();
		//转存文件
		File destFile = new File(path,fileName);
		try {
			file.transferTo(destFile);
		} catch (Exception e) {
			System.out.println("保存文件出错");
			e.printStackTrace();
		}
		
		//访问url地址
		String url = request.getScheme()+"://"+
				request.getServerName()+
				":"+request.getServerPort()+
				request.getContextPath()+"/fileUpload/"+
				fileName;
		request.setAttribute("url", url);
		return "home";
	}
}
