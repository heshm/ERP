package com.erp.stm.action;

import java.util.HashMap;
import java.util.Map;

import com.erp.common.action.CmAction;
import com.erp.common.util.Const;
import com.erp.stm.IService.IReceiptBillService;
import com.erp.stm.model.form.ReceiptBillForm;

public class ReceiptBillModiAction extends CmAction{
	
	private Short update;
	private String docketType;
	private String receiptNo;
	private ReceiptBillForm receiptBillForm;
	private IReceiptBillService receiptBillService;
	
	public String init(){
		if(Const.UPDATE_RECORD == update){
			Map<String,String> map = new HashMap<String,String>();
			map.put("depotId", Const.DEFAULT_DEPOT_ID);
			map.put("receiptNo", receiptNo);
			receiptBillForm = receiptBillService.getOneReceiptBillForm(map);
			System.out.println(receiptBillForm.getSumQuantity());
		}
		System.out.println(docketType);
		return SUCCESS;
	}

	public Short getUpdate() {
		return update;
	}

	public void setUpdate(Short update) {
		this.update = update;
	}

	public String getDocketType() {
		return docketType;
	}

	public void setDocketType(String docketType) {
		this.docketType = docketType;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public ReceiptBillForm getReceiptBillForm() {
		return receiptBillForm;
	}

	public void setReceiptBillForm(ReceiptBillForm receiptBillForm) {
		this.receiptBillForm = receiptBillForm;
	}

	public IReceiptBillService getReceiptBillService() {
		return receiptBillService;
	}

	public void setReceiptBillService(IReceiptBillService receiptBillService) {
		this.receiptBillService = receiptBillService;
	}

}
