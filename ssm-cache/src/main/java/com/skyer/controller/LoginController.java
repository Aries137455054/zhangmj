package com.skyer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skyer.service.UserService;
import com.skyer.vo.User;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("login.do")
	public ModelAndView login(HttpSession session,User user){
		User temp = userService.login(user);
		return null;
	}
	
}
