package com.erp.common.model.form;

import com.erp.common.model.ProductGroup;
import com.erp.common.model.ProductType;

public class AjaxProductType extends ProductType{
	
	private Float quantityLeft; //剩余库存

	public AjaxProductType(){
		super();
	}
	
	public AjaxProductType(ProductType productType){
		this.setGroupId(productType.getGroupId());
		this.setTypeId(productType.getTypeId());
		this.setName(productType.getName());
		this.setUnit(productType.getUnit());
		this.setRefInPrice(productType.getRefInPrice());
		this.setRefOutPrice(productType.getRefOutPrice());
		this.setDecNo(productType.getDecNo());
		this.setRemark(productType.getRemark());
		this.setNorm(productType.getNorm());
		this.setProductGroup(productType.getProductGroup());
	}
	
	public Float getQuantityLeft() {
		return quantityLeft;
	}

	public void setQuantityLeft(Float quantityLeft) {
		this.quantityLeft = quantityLeft;
	}

}
