package wymb.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import wymb.domain.User;
import wymb.service.UserService;
import wymb.vo.Result;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	//@RequirePermission("user:listUI")
	@RequestMapping("listUI")
	public String listUI() {
		return "user/listUI";
	}

	@RequestMapping("list")
	@ResponseBody
	public Result list(int offset, int limit, String search) {
		
//		Long startTime = System.currentTimeMillis();
//		List<User> list = userService.findUserByUserName1("张明杰1");
//		
//		System.out.println(list.size());
//		System.out.println("****************耗时："+(System.currentTimeMillis()-startTime));
//		
//		return Result.succeed(new PageInfo<User>());
		
		PageInfo<User> pageInfo = userService.getListByPage(offset, limit, search);
		return Result.succeed(pageInfo);
	}

	@RequestMapping("saveUI")
	public String save(Integer id, HttpServletRequest request) {
		if (id != null) {
			User user = userService.getById(id);
			request.setAttribute("user", user);
		}
		return "user/saveUI";
	}

	@RequestMapping("save")
	public String save(User user) {
		if (user.getId() != null) {
			user.setUpdateTime(new Date());
			userService.update(user);
		} else {
			user.setPassword(DigestUtils.md5Hex("123456"));
			user.setCreateTime(new Date());
			user.setUpdateTime(user.getCreateTime());
			userService.save(user);
		}
		return "redirect:/user/listUI";
	}

	@RequestMapping("delete/{ids}")
	@ResponseBody
	public Result delete(@PathVariable("ids") String ids) {
		String[] idsStr = ids.split(",");
		try {
			if (idsStr.length == 1) {
				userService.deleteById(Integer.valueOf(idsStr[0]));
			} else {
				userService.deleteBatchByIds(idsStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Result.fail(403, e.getMessage());
		}
		return Result.succeed();
	}
	
	@RequestMapping("setRole")
	@ResponseBody
	public Result setRole(Integer userId,String roleIds) {
		this.userService.saveUserRole(userId, roleIds);
		return Result.succeed();
	}
	
	@RequestMapping("testInternal")
	@ResponseBody
	public String testInternal(){
		return "<h1 style='text-align:center;'> World!</h1>";
	}
}
