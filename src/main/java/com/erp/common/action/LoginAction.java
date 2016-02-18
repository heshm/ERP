package com.erp.common.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;

import com.erp.common.IService.IUserService;
import com.erp.common.util.Const;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	private String userName;
	private String passWord;
	
	public String login(){
		char[] passwd = new Md5Hash(passWord).toString().toCharArray();
		//System.out.println("AAAA");
		Subject subject = SecurityUtils.getSubject();
		//System.out.println("BBBB");
		UsernamePasswordToken token = new UsernamePasswordToken();
		token.setUsername(userName);
		token.setPassword(passwd);
		token.setRememberMe(false);
		
		try{
			subject.login(token);
		}catch(AuthenticationException e){
			this.addActionError(Const.LOGIN_ERROR_MESSAGE);
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
