package com.skyer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyer.service.UserService;
import com.skyer.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("list.do")
	@ResponseBody
	public Object list(){
		List<User> list = userService.findAll();
		return list;
	}
	
	@RequestMapping("findById.do")
	@ResponseBody
	public Object findById(int id){
		List<User> list = userService.findById(id);
		return list;
	}
	
	@RequestMapping("removeCache.do")
	@ResponseBody
	public Object removeCache(){
		userService.removeCache();
		userService.removeCache1();
		return "移除缓存成功a";
	}
	
	
}
