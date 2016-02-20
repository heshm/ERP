package com.erp.common.action;


import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.erp.common.IService.IProductGroupService;
import com.erp.common.model.ProductGroup;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport{
	
	private IProductGroupService productGroupService;
	
	public String init(){
		List<ProductGroup> productGroupList = productGroupService.getAllProductGroup();
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.setAttribute("productGroup", productGroupList);
		return SUCCESS;
	}
	
	public IProductGroupService getProductGroupService() {
		return productGroupService;
	}

	public void setProductGroupService(IProductGroupService productGroupService) {
		this.productGroupService = productGroupService;
	}

}
