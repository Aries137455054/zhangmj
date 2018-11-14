package wymb.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import wymb.domain.User;

public class LoginInterceptor implements HandlerInterceptor {

	//最终执行的方法
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.err.println("拦截器：最终执行的方法");
	}

	//执行方法之后执行
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.err.println("拦截器：执行方法之后执行");
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		if(user != null){
			return true;
		}
		response.sendRedirect("index.jsp");
		return false;
	}

}
