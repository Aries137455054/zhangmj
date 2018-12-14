package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ssm.jediscomp.JedisClient;
import com.ssm.mapper.UserMapper;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import com.ssm.util.JsonUtils;
import com.ssm.util.StringUtils;

public class UserServiceImpl implements UserService {
	@Autowired
	private JedisClient jedisClient;
	@Autowired
	private UserMapper userMapper;
	
	@Value("${REDIS_USER_KEY}")
	private String REDIS_USER_KEY;
	@Value("${USER_BASE_INFO_KEY}")
	private String USER_BASE_INFO_KEY;
	@Value("${ITEM_EXPIRE_SECOND}")
	private Integer ITEM_EXPIRE_SECOND;
	
	public User selectByPrimaryKey(Integer id) {
		String json = null;
		try{
			json = jedisClient.get(REDIS_USER_KEY+":"+id+":"+USER_BASE_INFO_KEY);
			System.out.println("从缓存里面获取数据");
			if(!StringUtils.isEmpty(json)){
				User user = JsonUtils.jsonToPojo(json, User.class);
				return user;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("缓存里面没有数据");
		}
		
		//从数据库里面获取数据
		User user = userMapper.selectById(id);
		System.out.println("从数据库里面获取数据");
		
		try{
			//向缓存中添加数据
			jedisClient.set(REDIS_USER_KEY+":"+id+":"+USER_BASE_INFO_KEY, JsonUtils.objectToJson(user));
			
			//设置过期时间
			//jedisClient.expire(REDIS_USER_KEY+":"+id+":"+USER_BASE_INFO_KEY, ITEM_EXPIRE_SECOND);
			System.out.println("向缓存添加用户数据");
		}catch(Exception e){
			System.out.println("向缓存添加用户数据出错");
		}
		return user;
	}

	
	
	
	
	
	
	
	
}




