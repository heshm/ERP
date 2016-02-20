package com.erp.common.action;

import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;

import com.erp.common.IService.IProductGroupService;
import com.erp.common.model.ProductGroup;

public class ProductGroupAction extends CmAction {
	
	private List<ProductGroup> productGroupList;
	
	private IProductGroupService productGroupService;
	
	@RequiresRoles(value={"sysadmin","stockman"}, logical= Logical.OR)
	public String init(){
		productGroupList = productGroupService.getAllProductGroup();
		return SUCCESS;
	}

	public List<ProductGroup> getProductGroupList() {
		return productGroupList;
	}

	public void setProductGroupList(List<ProductGroup> productGroupList) {
		this.productGroupList = productGroupList;
	}

	public IProductGroupService getProductGroupService() {
		return productGroupService;
	}

	public void setProductGroupService(IProductGroupService productGroupService) {
		this.productGroupService = productGroupService;
	}

}
