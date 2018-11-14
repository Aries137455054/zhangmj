package wymb.service;

import wymb.domain.User;

import com.github.pagehelper.PageInfo;

public interface UserService extends BaseService<User> {

	User findUserByUserName(String userName);

	void deleteBatchByIds(String[] idsStr);

	PageInfo<User> getListByPage(int currentNum, int pageSize, String name);

	/**
	 * 绑定用户和角色
	 * @param userId
	 * @param roleId
	 */
	void saveUserRole(Integer userId, String roleIdsStr);
}
