package wymb.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import wymb.domain.User;
import wymb.mapper.UserMapper;
import wymb.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	@Autowired
	private UserMapper userMapper;

	@Override 
	protected Mapper<User> getMapper() {
		return this.userMapper;
	}

	public User findUserByUserName(String userName) {
		return this.userMapper.getUserByUserName(userName);
	}
	
	public List<User> findUserByUserName1(String userName) {
		return this.userMapper.getUserByUserName1(userName);
	}

	public void deleteBatchByIds(String[] idsStr) {
		this.userMapper.deleteBatchByIds(idsStr);

	}

	public PageInfo<User> getListByPage(int currentNum, int pageSize,
			String name) {
		Example cond = new Example(User.class);
		if (!StringUtils.isEmpty(name)) {
			try {
				name = new String(name.getBytes("iso8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			cond.createCriteria().andLike("userName", name);
		}

		PageHelper.startPage(currentNum, pageSize);
		List<User> list = userMapper.selectByExample(cond);
		return new PageInfo<User>(list);
	}

	public void saveUserRole(Integer userId, String roleIdsStr) {
		this.userMapper.deleteUserRoleByUserId(userId);
		
		if (StringUtils.isNotEmpty(roleIdsStr)) {
			String[] roleIds = roleIdsStr.split(",");
			List<Map<String,Integer>> params = new ArrayList<Map<String,Integer>>(roleIds.length);
			Map<String,Integer> param;
			for (String roleId : roleIds) {
				param = new HashMap<String, Integer>(2);
				param.put("userId", userId);
				param.put("roleId", Integer.valueOf(roleId));
				
				params.add(param);
			}
			userMapper.saveUserRole(params);
		}
	}
	
}
