package wymb.service;

import java.util.List;
import java.util.Map;

import wymb.domain.Permission;

import com.github.pagehelper.PageInfo;

public interface PermissionService extends BaseService<Permission> {

	/**
	 * 获取用户可以查看的菜单列表
	 * @param id
	 * @return
	 */
	Map<String, List<Permission>> getPermissionMapByUserId(Integer id);

	PageInfo<Permission> getListByPage(int currentPage, int pageSize,
			String name);

	List<Permission> getPermissionWithoutButton();

	List<Permission> getPermissionListByRoleId(Integer roleId);

	
	
}
