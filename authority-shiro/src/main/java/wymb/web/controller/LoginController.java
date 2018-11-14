package wymb.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wymb.domain.User;
import wymb.vo.Result;

@Controller
public class LoginController {

	@RequestMapping("login")
	@ResponseBody
	public Result login(HttpSession session, String userName, String password) {
		
		UsernamePasswordToken token = new UsernamePasswordToken(userName.trim(), DigestUtils.md5Hex(password).toCharArray());
		Subject subject = SecurityUtils.getSubject();
		
		try{
			subject.login(token);
		}catch(UnknownAccountException e){
			return new Result(403, "用户不存在");
		}catch (IncorrectCredentialsException e) {
			return new Result(403, "用户密码不正确");
		}
		return Result.succeed("manageUI");
	}
	
	@RequestMapping("logout")
	@ResponseBody
	public Result logout(HttpSession session){
		session.invalidate();
		return Result.succeed("index.jsp");
	}
	
	@RequestMapping(value="manageUI")
	public String manageUI(HttpServletRequest request){
		Subject subject=  SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		request.setAttribute("loginUser", user);
		return "manageUI";
	}
}
