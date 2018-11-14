package wymb.web.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import wymb.domain.Permission;
import wymb.domain.User;
import wymb.web.annotation.RequirePermission;

public class AuthorizateInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		//获取访问接口对应的权限
		HandlerMethod method = (HandlerMethod) handler;
		RequirePermission requirePermission = method.getMethod().getAnnotation(RequirePermission.class);
		if(requirePermission == null){
			return true;
		}
		
		//获取用户所以权限
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		List<Permission> permissionList = user.getPermissionList();
		
		//当前请求方法需要的权限
		String privilege = requirePermission.value();
		
		//判断权限
		for (Permission permission : permissionList) {
			if(permission.getType() != 1 && privilege.indexOf(permission.getCode()) > -1){
				return true;
			}
		}
		response.sendRedirect("/authority/403.jsp");
		return false;
	}

}
