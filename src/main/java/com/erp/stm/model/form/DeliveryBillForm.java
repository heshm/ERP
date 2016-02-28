package com.erp.stm.model.form;

import java.math.BigDecimal;
import java.util.List;

import com.erp.stm.model.Delivery;
import com.erp.stm.model.DeliveryDetail;

public class DeliveryBillForm {
	
	private Delivery delivery;
	private List<DeliveryDetail> deliveryDetailList;
	private Float sumQuantity;  
	private BigDecimal sumAmount;
	private BigDecimal sumTaxAmt;
	
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public List<DeliveryDetail> getDeliveryDetailList() {
		return deliveryDetailList;
	}
	public void setDeliveryDetailList(List<DeliveryDetail> deliveryDetailList) {
		this.deliveryDetailList = deliveryDetailList;
	}
	public Float getSumQuantity() {
		return sumQuantity;
	}
	public void setSumQuantity(Float sumQuantity) {
		this.sumQuantity = sumQuantity;
	}
	public BigDecimal getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(BigDecimal sumAmount) {
		this.sumAmount = sumAmount;
	}
	public BigDecimal getSumTaxAmt() {
		return sumTaxAmt;
	}
	public void setSumTaxAmt(BigDecimal sumTaxAmt) {
		this.sumTaxAmt = sumTaxAmt;
	}

}
