package com.erp.common.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.common.IService.IProductTypeService;
import com.erp.common.model.ProductType;

public class StaticModal extends CmAction{
	
	private List<ProductType> productTypeList;
	
	private IProductTypeService productTypeService;
	
	private String groupId;
	
	private String typeId;
	
	private ProductType productType;
	
	public String ajaxGetProductTypeList(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("groupId", groupId);
		productTypeList = productTypeService.getMulProductType(map);
		return SUCCESS;
	}
	
	public String ajaxGetProductType(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("groupId", groupId);
		map.put("typeId", typeId);
		productType = productTypeService.getOneProductType(map);
		return SUCCESS;
	}

	public List<ProductType> getProductTypeList() {
		return productTypeList;
	}

	public void setProductTypeList(List<ProductType> productTypeList) {
		this.productTypeList = productTypeList;
	}

	public IProductTypeService getProductTypeService() {
		return productTypeService;
	}

	public void setProductTypeService(IProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	
}
