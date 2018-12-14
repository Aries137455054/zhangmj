package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.User;
import com.ssm.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("user")
	public String getUserById(HttpServletRequest request,Model mode){
		User user = userService.selectByPrimaryKey(1);
		request.getSession().setAttribute("u", user);
		mode.addAttribute("cc", user);
		return "index";
	}
}
