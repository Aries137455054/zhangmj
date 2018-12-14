package com.ssm.mapper;

import java.util.List;

import com.ssm.pojo.User;

public interface UserMapper {

	List<User> list();

	User selectById(Integer id);
}
