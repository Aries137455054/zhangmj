package wymb.mapper;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;
import wymb.domain.Permission;

public interface PermissionMapper extends Mapper<Permission> {

	List<Permission> getPermissionListByUserId(Integer userId);
	
	//int getChildrenCount(Serializable id);
	List<Permission> getPermissionWithoutButton();
	List<Permission> getPermissionListByRoleId(Integer roleId);

	
}
