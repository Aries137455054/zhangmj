package wymb.web.realm;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import wymb.domain.Permission;
import wymb.domain.User;
import wymb.service.PermissionService;
import wymb.service.UserService;

public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;
	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		User user = userService.findUserByUserName(userName);
		if(user == null)return null;
		
		Map<String, List<Permission>> permissionMap = permissionService.getPermissionMapByUserId(user.getId());
		//目录+菜单
		user.setMenuList(permissionMap.get("menuList"));
		//目录+菜单+按钮
		user.setPermissionList(permissionMap.get("permissionList"));
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		return info;
		
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		//目录 + 菜单 + 按钮
		List<Permission> permissionList = user.getPermissionList();
		for (Permission permission : permissionList) {
			if(StringUtils.isNotEmpty(permission.getCode())){
				info.addStringPermission(permission.getCode());
			}
		}
		return info;
	}
}
