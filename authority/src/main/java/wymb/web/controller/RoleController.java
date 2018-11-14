package wymb.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import wymb.domain.Role;
import wymb.service.RoleService;
import wymb.vo.Result;

@Controller
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping("listUI")
	public String listUI() {
		return "role/listUI";
	}

	//@RequirePermission("role:listUI")
	@RequestMapping("list")
	@ResponseBody
	public Result list(int offset, int limit, String search) {
		PageInfo<Role> pageInfo = roleService.getListByPage(offset / limit + 1, limit, search);
		return Result.succeed(pageInfo);
	}

	
	@RequestMapping("saveUI")
	public String saveUI(HttpServletRequest request , Integer id) {
		if(id != null){
			Role role = roleService.getById(id);
			request.setAttribute("role", role);
		}
		return "role/saveUI";
	}
	
	@RequestMapping("getRoleListWithSelected/{userId}")
	@ResponseBody
	public Result getRoleListWithSelected(@PathVariable("userId") Integer userId){
		List<Role> roleList = roleService.getRoleListByUser(userId);
		return Result.succeed(roleList);
	}
	
	@RequestMapping("save")
	public String save(Role role) {
		if(role.getId() != null){
			roleService.update(role);
		}else{
			roleService.save(role);
		}
		return "redirect:/role/listUI";
	}
	
	@RequestMapping("delete/{ids}")
	@ResponseBody
	public Result listUI(@PathVariable("ids") String ids) {
		String[] idsStr = ids.split(",");
		try{
			if(idsStr.length == 1){
				this.roleService.deleteById(Integer.valueOf(idsStr[0]));
			}else{
				this.roleService.deleteBatchByIds(idsStr);
			}
		}catch(Exception e){
			e.printStackTrace();
			return Result.fail(403, e.getMessage());
		}
		return Result.succeed();
	}
	
	@RequestMapping("setPermission")
	@ResponseBody
	public Result setPermission(Integer roleId,String permissionIds) {
//		Role role = roleService.getById(roleId);
//		if(role.getName().equals("超级管理员")){
//			return Result.fail(403, "超级管理员禁止编辑");
//		}
		roleService.saveRolePermission(roleId, permissionIds);
		return Result.succeed();
	}
}
