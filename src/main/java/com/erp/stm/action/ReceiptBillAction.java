package com.erp.stm.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.transaction.annotation.Transactional;

import com.erp.common.action.CmAction;
import com.erp.common.model.Page;
import com.erp.common.model.User;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;
import com.erp.stm.IService.IReceiptBillService;
import com.erp.stm.IService.IReceiptService;
import com.erp.stm.model.Receipt;


public class ReceiptBillAction extends CmAction{
	
	private String docketType;
	private Page<Receipt> page;
	private String receiptNo;
	private String startDate;
	private String endDate;
	private String status;
	
	private Integer index;
	
	
	private IReceiptService receiptService;
	private IReceiptBillService receiptBillService;
	
	public String init(){
	    startDate = CommonUtil.getFirstDayOfTheMonth();
	    endDate = CommonUtil.getCurrentDate();
	    index = Const.FIRST_PAGE_INDEX;
		return SUCCESS;
	}
	
	public String query(){
		Map<String,Object> parmMap = new HashMap<String,Object>();
		parmMap.put("depotId", Const.DEFAULT_DEPOT_ID);
		parmMap.put("startDate", startDate);
		parmMap.put("endDate", endDate);
		parmMap.put("receiptNo", receiptNo);
		parmMap.put("type", docketType);
		parmMap.put("status", status);
	    page = receiptService.getIndexPage(index, parmMap);
		return SUCCESS;
	}
	
	public String delete(){
		Map<String,Object> parmMap = new HashMap<String,Object>();
		parmMap.put("depotId", Const.DEFAULT_DEPOT_ID);
		parmMap.put("receiptNo", receiptNo);
		receiptService.deleteOneReceipt(parmMap);
		return SUCCESS;
	}

	public String check(){
		try{
			Subject subject = SecurityUtils.getSubject();
		    Session session = subject.getSession();
		    User user = (User)session.getAttribute("user");
		    receiptBillService.checkReceiptBillForm(Const.DEFAULT_DEPOT_ID, receiptNo ,user);
		    this.addActionMessage("单据号为(" + receiptNo + ")的单据审核成功!");
		}catch(RuntimeException e){
			this.addActionError(e.getMessage());
		}
		startDate = CommonUtil.getFirstDayOfTheMonth();
	    endDate = CommonUtil.getCurrentDate();
		Map<String,Object> parmMap = new HashMap<String,Object>();
		parmMap.put("depotId", Const.DEFAULT_DEPOT_ID);
		//parmMap.put("startDate", startDate);
		//parmMap.put("endDate", endDate);
		parmMap.put("receiptNo", receiptNo);
		parmMap.put("type", docketType);
		page = receiptService.getIndexPage(1, parmMap);
		receiptNo = Const.DEFAULT_EMPTY_STRING;
		
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
	

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public IReceiptService getReceiptService() {
		return receiptService;
	}

	public void setReceiptService(IReceiptService receiptService) {
		this.receiptService = receiptService;
	}

	public IReceiptBillService getReceiptBillService() {
		return receiptBillService;
	}

	public void setReceiptBillService(IReceiptBillService receiptBillService) {
		this.receiptBillService = receiptBillService;
	}

}
