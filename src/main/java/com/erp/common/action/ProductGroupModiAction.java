package com.erp.common.action;

import com.erp.common.IService.IProductGroupService;
import com.erp.common.model.ProductGroup;

public class ProductGroupModiAction extends CmAction{
	
	private String groupId;
	private String groupName;
	private IProductGroupService productGroupService;
	
	public String init(){
		//System.out.println("Go Here");
		return SUCCESS;
	}
	
	public String modi(){
		//System.out.println(groupId);
		//System.out.println(groupName);
		ProductGroup productGroup = new ProductGroup();
		productGroup.setGroupId(groupId);
		productGroup.setGroupName(groupName);
		productGroupService.addOneProductGroup(productGroup);
		return SUCCESS;
	}
	
	public String delete(){
		productGroupService.deleteOneProductGroup(groupId);
		return SUCCESS;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public IProductGroupService getProductGroupService() {
		return productGroupService;
	}

	public void setProductGroupService(IProductGroupService productGroupService) {
		this.productGroupService = productGroupService;
	}

}
