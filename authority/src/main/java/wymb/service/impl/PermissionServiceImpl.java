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
import wymb.domain.Permission;
import wymb.mapper.PermissionMapper;
import wymb.service.PermissionService;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService{

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	protected Mapper<Permission> getMapper() {
		return permissionMapper;
	}

	@Override
	public void save(Permission permission) {
		if(permission.getPid() != null && permission.getPid() != 0){
			Permission parent = getById(permission.getPid());
			permission.setParentName(parent.getName());
		}
		getMapper().insert(permission);
	}
	
	@Override
	public void update(Permission t) {
		if(t.getPid() != null && t.getPid() != 0){
			Permission parent = getById(t.getPid());
			t.setParentName(parent.getName());
		}
//		getMapper().updateByPrimaryKey(t);
		super.update(t);
	}

	public PageInfo<Permission> getListByPage(int currentNum, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, List<Permission>> getPermissionMapByUserId(Integer id) {
		List<Permission> permissionList = permissionMapper.getPermissionListByUserId(id);
		
		List<Permission> menuList = new ArrayList<Permission>();
		Map<Integer, Permission> map = new HashMap<Integer, Permission>();
		
		//封装目录
		for (Permission permission : permissionList) {
			if(permission.getType() != 3 && permission.getPid() == 0L){
				map.put(permission.getId(),permission);
				menuList.add(permission);
			}
		}
		
		//封装菜单
		for (Permission permission : permissionList) {
			if(permission.getType() !=3 && map.get(permission.getPid()) != null){
				Permission parent = map.get(permission.getPid());
				parent.getChildren().add(permission);
			}
		}
		
		Map<String, List<Permission>> resultMap = new HashMap<String, List<Permission>>();
		resultMap.put("menuList", menuList);
		resultMap.put("permissionList", permissionList);
		return resultMap;
	}

	public PageInfo<Permission> getListByPage(int currentPage, int pageSize, String name) {
		Example cond = new Example(Permission.class);
		if(!StringUtils.isEmpty(name)){
			try {
				name = new String(name.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			cond.createCriteria().andLike("name", name);
		}
		PageHelper.startPage(currentPage, pageSize);
		List<Permission> list = permissionMapper.selectByExample(cond);
		return new PageInfo<Permission>(list);
	}

	public List<Permission> getPermissionWithoutButton() {
		return permissionMapper.getPermissionWithoutButton();
	}

	/**
	 * 获取角色对应的权限
	 */
	public List<Permission> getPermissionListByRoleId(Integer roleId) {
		List<Permission> list = this.permissionMapper.getPermissionListByRoleId(roleId);
		List<Permission> permissionList = this.getList();
		for (Permission permission : permissionList) {
			for (Permission p : list) {
				if(permission.getId() == p.getId()){
					permission.setChecked(true);
				}
			}
		}
		return permissionList;
	}

}
