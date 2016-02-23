package com.erp.common.action;

import java.util.HashMap;
import java.util.Map;

import com.erp.common.IService.IProductTypeService;
import com.erp.common.model.ProductType;
import com.erp.common.util.Const;

public class ProductTypeModiAction extends CmAction{
	
	private String commodityType;
	
	private ProductType productType;
	
	private Short isUpdate;
	
	private IProductTypeService productTypeService;
	
	public String init(){
		//System.out.println(isUpdate);
		if(Const.UPDATE_RECORD == isUpdate){
			Map<String,String> map = new HashMap<String,String>();
	
			map.put("groupId", commodityType.substring(0,2));
			map.put("typeId", commodityType.substring(2));
			productType = productTypeService.getOneProductType(map);
		}
		return SUCCESS;
	}
	
	public String update(){
		if (productTypeService.updateOneProductType(productType) == Const.SUCCESS){
			Map<String,String> map = new HashMap<String,String>();
			map.put("groupId", productType.getGroupId());
			map.put("typeId", productType.getTypeId());
			productType = productTypeService.getOneProductType(map);
			this.addActionMessage("数据更新成功!");
		}else{
		    this.addActionError("数据更新失败!");
		}
		return SUCCESS;
	}
	
	public String insert(){
		if(productTypeService.addOneProductType(productType) == Const.SUCCESS){
			this.addActionMessage("数据新增成功!");
		}else{
			this.addActionError("货品编码为(" + productType.getGroupId() + productType.getTypeId() + ")的记录已经存在!");
		}
		return SUCCESS;
	}
	

	public String getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Short isUpdate) {
		this.isUpdate = isUpdate;
	}

	public IProductTypeService getProductTypeService() {
		return productTypeService;
	}

	public void setProductTypeService(IProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}

}
