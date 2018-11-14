package wymb.service.impl;

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
import wymb.domain.Role;
import wymb.mapper.RoleMapper;
import wymb.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	protected Mapper<Role> getMapper() {
		return this.roleMapper;
	}
	
	public PageInfo<Role> getListByPage(int currentNum, int pageSize, String search) {
		Example cond = new Example(Role.class);
		PageHelper.startPage(currentNum, pageSize);
		List<Role> list = getMapper().selectByExample(cond);
		return new PageInfo<Role>(list);
	}

	public void saveRolePermission(int roleId, String permissionIdsStr) {
		//解绑
		this.roleMapper.deleteRolePermissionByRoleId(roleId);
		
		//绑定
		if(StringUtils.isNotEmpty(permissionIdsStr)){
			String[] permissionIds = permissionIdsStr.split(",");
			List<Map<String, Integer>> params = new ArrayList<Map<String, Integer>>(permissionIds.length);
			Map<String, Integer> param = null;
			for (String permissionId : permissionIds) {
				param = new HashMap<String, Integer>(2);
				param.put("roleId", roleId);
				param.put("permissionId", Integer.valueOf(permissionId));
				params.add(param);
			}
			this.roleMapper.saveRolePermission(params);
		}
	}

	public List<Role> getRoleListByUser(int userId) {
		List<Role> list = this.roleMapper.getRoleListByUserId(userId);
		List<Role> roleList = this.getList();
		for (Role role : list) {
			for (Role r : roleList) {
				if(role.getId() == r.getId()){
					r.setSelected(true);
				}
			}
		}
		return roleList;
	}

	public void deleteBatchByIds(String[] idsStr) {
		this.roleMapper.deleteBatchByIds(idsStr);
	}

}
