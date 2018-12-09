package wymb.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import wymb.domain.User;

public interface UserService extends BaseService<User> {

	User findUserByUserName(String userName);
	
	List<User> findUserByUserName1(String userName);

	void deleteBatchByIds(String[] idsStr);

	PageInfo<User> getListByPage(int currentNum, int pageSize, String name);

	/**
	 * 绑定用户和角色
	 * @param userId
	 * @param roleId
	 */
	void saveUserRole(Integer userId, String roleIdsStr);
}
