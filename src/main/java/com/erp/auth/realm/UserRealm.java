package com.erp.auth.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.erp.common.IService.IUserService;
import com.erp.common.model.User;

public class UserRealm extends AuthorizingRealm{

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		//Subject subject = SecurityUtils.getSubject();
		//Session session = subject.getSession();
		String userId = (String) principal.getPrimaryPrincipal(); 
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//char level = session.getAttribute("level").toString().charAt(0);
		authorizationInfo.addRoles(userService.getRoles(userId));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		//Subject subject = SecurityUtils.getSubject();
		//Session session = subject.getSession();
		//System.out.println("This is a agf");
		System.out.println("Login Method");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String password = String.valueOf(token.getPassword());
		System.out.println(token.getUsername());
		User user = userService.getOneUser(token.getUsername());
		System.out.println(user.getPassword());
		if(user == null){
			throw new UnknownAccountException();
		}else{
			if(user.getPassword().equals(password)){
				return new SimpleAuthenticationInfo(
						user.getUserId(),
						user.getPassword(),
						user.getUserName());
			}else{
				throw new IncorrectCredentialsException();
			}
		}
	}
	
    private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	


}
