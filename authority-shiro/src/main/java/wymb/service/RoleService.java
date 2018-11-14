package wymb.service;

import java.util.List;

import wymb.domain.Role;

import com.github.pagehelper.PageInfo;

public interface RoleService extends BaseService<Role> {

	PageInfo<Role> getListByPage(int currentNum, int pageSize, String search);

	/**
	 * 绑定角色和权限
	 * @param roleId
	 * @param permissionIds
	 */
	void saveRolePermission(int roleId, String permissionIds);

	List<Role> getRoleListByUser(int userId);

	void deleteBatchByIds(String[] idsStr);
}
