package wymb.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wymb.domain.Permission;
import wymb.domain.User;
import wymb.service.PermissionService;
import wymb.service.UserService;
import wymb.vo.Result;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;

	@RequestMapping("login")
	@ResponseBody
	public Result login(HttpSession session, String userName, String password) {
		User user = userService.findUserByUserName(userName);
		if (user == null) {
			return new Result(404, "用户不存在");
		}

		if (!DigestUtils.md5Hex(password).equals(user.getPassword())) {
			return new Result(403, "用户密码不正确");
		}
		session.setAttribute("loginUser", user);
		return Result.succeed("manageUI");
	}
	
	@RequestMapping("logout")
	@ResponseBody
	public Result logout(HttpSession session){
		session.invalidate();
		return Result.succeed("index.jsp");
	}
	
	@RequestMapping(value="manageUI")
	public String manageUI(HttpSession session){
		Object obj = session.getAttribute("loginUser");
		if(obj == null){
			return "redirect:/index.jsp";
		}
		User user = (User) obj;
		Map<String, List<Permission>> permissionMap = permissionService.getPermissionMapByUserId(user.getId());
		//目录+菜单
		user.setMenuList(permissionMap.get("menuList"));
		
		user.setPermissionList(permissionMap.get("permissionList"));
		return "manageUI";
	}
}
