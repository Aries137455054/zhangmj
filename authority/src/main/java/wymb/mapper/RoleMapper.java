package wymb.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;
import wymb.domain.Role;

public interface RoleMapper extends Mapper<Role> {

	void deleteRolePermissionByRoleId(Integer id);

	void saveRolePermission(@Param("list") List<Map<String, Integer>> params);

	List<Role> getRoleListByUserId(Integer userId);

	void deleteBatchByIds(@Param("ids") String[] idsStr);
}
