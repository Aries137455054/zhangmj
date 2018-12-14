package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String test(){
		return "hello springboot!!!";
	}
	
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request,ModelAndView mv){
		request.setAttribute("obj", "后台返回来的对象12");
		mv.setViewName("index");
		return mv;
	}
}
