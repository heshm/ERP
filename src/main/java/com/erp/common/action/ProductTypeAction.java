package com.erp.common.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.common.IService.IProductTypeService;
import com.erp.common.model.ProductType;

public class ProductTypeAction extends CmAction{
	
	private List<ProductType> productTypeList;
	
	private IProductTypeService productTypeService;
	
	private String groupId;
	
	private String productName;
	
	private String commodityType;
	
	public String init(){
		productTypeList = productTypeService.getMulProductType(new HashMap<String,String>());
		return SUCCESS;
	}
	
	public String query(){
		Map<String,String> map = new HashMap<String,String>();
		//System.out.println("groupId:"+groupId);
		map.put("groupId", groupId);
		map.put("name", productName);
		productTypeList = productTypeService.getMulProductType(map);
		return SUCCESS;
	}
	
	public String delete(){
		//System.out.println(commodityType);
		Map<String,String> delMap = new HashMap<String,String>();
		delMap.put("groupId", commodityType.substring(0,2));
		delMap.put("typeId", commodityType.substring(2));
		productTypeService.deleteOneProductType(delMap);
		
		Map<String,String> selMap = new HashMap<String,String>();
		//System.out.println("groupId:"+groupId);
		selMap.put("groupId", groupId);
		selMap.put("name", productName);
		productTypeList = productTypeService.getMulProductType(selMap);
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

}
