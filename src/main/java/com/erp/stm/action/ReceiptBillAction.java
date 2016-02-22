package com.erp.stm.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.erp.common.action.CmAction;
import com.erp.common.model.Page;
import com.erp.common.util.CommonUtil;
import com.erp.stm.IService.IReceiptService;
import com.erp.stm.model.Receipt;

public class ReceiptBillAction extends CmAction{
	
	private String docketType;
	private Page<Receipt> page;
	private String receiptNo;
	private String startDate;
	private String endDate;
	private String status;
	
	
	private IReceiptService receiptService;
	
	public String init(){
	    startDate = CommonUtil.getFirstDayOfTheMonth();
	    endDate = CommonUtil.getCurrentDate();
		
		return SUCCESS;
	}
	
	public String query(){
		System.out.println("BBBBBB");
		Map<String,Object> parmMap = new HashMap<String,Object>();
		parmMap.put("depotId", "01");
		parmMap.put("startDate", startDate);
		parmMap.put("endDate", endDate);
		page = receiptService.getIndexPage(1, parmMap);
		
		return SUCCESS;
	}

	public String getDocketType() {
		return docketType;
	}

	public void setDocketType(String docketType) {
		this.docketType = docketType;
	}

	public Page<Receipt> getPage() {
		return page;
	}

	public void setPage(Page<Receipt> page) {
		this.page = page;
	}


	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public IReceiptService getReceiptService() {
		return receiptService;
	}

	public void setReceiptService(IReceiptService receiptService) {
		this.receiptService = receiptService;
	}

}
