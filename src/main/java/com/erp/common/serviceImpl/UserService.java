package com.erp.common.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.erp.common.IDAO.IUserDAO;
import com.erp.common.IService.IUserService;
import com.erp.common.model.User;

public class UserService implements IUserService {
	
	private IUserDAO userDAO;

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User getOneUser(String userId) {
		return userDAO.selectByPrimaryKey(userId);
	}

	public List<String> getRoles(String userId) {
		User user = userDAO.selectByPrimaryKey(userId);
		String sroles[] = user.getRole().split(",");
		List<String> roles = new ArrayList<String>();
		for(String s:sroles){
			roles.add(s.trim());
		}
		return roles;
	}

}
