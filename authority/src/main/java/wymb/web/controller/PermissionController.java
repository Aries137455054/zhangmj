package wymb.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import wymb.domain.Permission;
import wymb.service.PermissionService;
import wymb.vo.Result;

@Controller
@RequestMapping("permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	//@RequirePermission("permission:listUI")
	@RequestMapping("listUI")
	public String listUI(){
		return "permission/listUI";
	}
	
	//@RequirePermission("permission:listUI")
	@RequestMapping("list")
	@ResponseBody
	public Result list(int offset,int limit,String search){
		PageInfo<Permission> pageInfo = permissionService.getListByPage(offset/limit+1, limit,search);
		return Result.succeed(pageInfo);
	}
	
	@RequestMapping("saveUI")
	public String saveUI(HttpServletRequest request,Integer id){
		if(id != null){
			Permission permission = permissionService.getById(id);
			if(permission != null){
				request.setAttribute("permission", permission);
			}
		}
		List<Permission> parentList = permissionService.getPermissionWithoutButton();
		
		List<Permission> list = new ArrayList<Permission>();
		recurData(parentList,list,"---");
		
		request.setAttribute("parentList", list);
		return "permission/saveUI";
	}
	
	@RequestMapping("save")
	public String save(Permission permission){
		if(permission.getId() != null){
			this.permissionService.update(permission);
		}else{
			this.permissionService.save(permission);
		}
		return "redirect:/permission/listUI";
	}
	
	@RequestMapping("delete/{id}")
	@ResponseBody
	public Result delete(@PathVariable("id") int id){
		try{
			this.permissionService.deleteById(id);
			return Result.succeed();
		}catch(Exception e){
			e.printStackTrace();
			return Result.fail(403, e.getMessage());
		}
	}
	
	
	@RequestMapping("getPermissionListWithChecked/{roleId}")
	@ResponseBody
	public Result getPermissionListWithChecked(@PathVariable("roleId")Integer roleId){
		List<Permission> permissionList = permissionService.getPermissionListByRoleId(roleId);
		return Result.succeed(permissionList);
	}
	
	private void recurData(List<Permission> source,List<Permission> dest,String prefix){
		for (Permission permission : source) {
			permission.setName("|-"+prefix+permission.getName());
			dest.add(permission);
			if(permission.getChildren() != null && !permission.getChildren().isEmpty()){
				recurData(permission.getChildren(),dest,"---");
			}
		}
	}
}
