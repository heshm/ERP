package com.erp.stm.action;

import java.util.HashMap;
import java.util.Map;

import com.erp.common.action.CmAction;
import com.erp.common.util.Const;
import com.erp.stm.IService.IDeliveryBillService;
import com.erp.stm.model.form.DeliveryBillForm;

public class DeliveryBillModiAction extends CmAction{
	
	private String deliveryNo;
	private Short update;
	private DeliveryBillForm deliveryBillForm;
	private IDeliveryBillService deliveryBillService;
	
	public String init(){
		if(Const.UPDATE_RECORD == update){
			Map<String,String> map = new HashMap<String,String>();
			map.put("depotId", Const.DEFAULT_DEPOT_ID);
			map.put("deliveryNo", deliveryNo);
			deliveryBillForm = deliveryBillService.getOneDeliveryBillForm(map);
		}
		return SUCCESS;
		
	}

	public String getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public Short getUpdate() {
		return update;
	}

	public void setUpdate(Short update) {
		this.update = update;
	}

	public DeliveryBillForm getDeliveryBillForm() {
		return deliveryBillForm;
	}

	public void setDeliveryBillForm(DeliveryBillForm deliveryBillForm) {
		this.deliveryBillForm = deliveryBillForm;
	}

	public IDeliveryBillService getDeliveryBillService() {
		return deliveryBillService;
	}

	public void setDeliveryBillService(IDeliveryBillService deliveryBillService) {
		this.deliveryBillService = deliveryBillService;
	}

}
