package com.erp.common.IService;

import java.util.List;

import com.erp.common.model.User;

public interface IUserService {
	
	public abstract User getOneUser(String userId);
	
	public abstract List<String> getRoles(String userId);

}
