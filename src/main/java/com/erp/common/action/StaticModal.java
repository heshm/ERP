package com.erp.common.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.common.IService.IProductTypeService;
import com.erp.common.model.ProductType;
import com.erp.common.model.form.AjaxProductType;
import com.erp.common.util.Const;
import com.erp.stm.IService.IInventoryService;
import com.erp.stm.model.Inventory;

public class StaticModal extends CmAction{
	
	private List<ProductType> productTypeList;
	
	private IProductTypeService productTypeService;
	
	private String groupId;
	
	private String typeId;
	
	private ProductType productType;
	
	private Inventory inventory;
	
	private IInventoryService inventoryService;
	
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
	
	public String ajaxGetInventory(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("depotId", Const.DEFAULT_DEPOT_ID);
		String commodityType = groupId + typeId;
		map.put("commodityType",commodityType);
		inventory = inventoryService.getOneInventory(map);
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

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public IInventoryService getInventoryService() {
		return inventoryService;
	}

	public void setInventoryService(IInventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	
}
