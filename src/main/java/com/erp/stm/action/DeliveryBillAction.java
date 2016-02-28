package com.erp.stm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.erp.common.action.CmAction;
import com.erp.common.model.Page;
import com.erp.common.model.User;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;
import com.erp.stm.IService.IDeliveryBillService;
import com.erp.stm.IService.IDeliveryService;
import com.erp.stm.model.Delivery;

public class DeliveryBillAction extends CmAction{
	
	private String startDate;
	private String endDate;
	private Integer index;
	private String docketType;
	private Page<Delivery> page;
	private String status;
	private String deliveryNo;
	
	private IDeliveryService deliveryService; 
	private IDeliveryBillService deliveryBillService;
	
	public String init(){
		Subject subject = SecurityUtils.getSubject();
	    Session session = subject.getSession();
	    session.setAttribute("docketType", docketType);
		startDate = CommonUtil.getFirstDayOfTheMonth();
	    endDate = CommonUtil.getCurrentDate();
	    index = Const.FIRST_PAGE_INDEX;
		return SUCCESS;
	}
	
	public String query(){
		Subject subject = SecurityUtils.getSubject();
	    Session session = subject.getSession();
		String docketType = (String)session.getAttribute("docketType");
		Map<String,Object> parmMap = new HashMap<String,Object>();
		parmMap.put("depotId", Const.DEFAULT_DEPOT_ID);
		parmMap.put("startDate", startDate);
		parmMap.put("endDate", endDate);
		parmMap.put("type", docketType);
		parmMap.put("status", status);
		parmMap.put("deliveryNo", deliveryNo);
		page = deliveryService.getIndexPage(index, parmMap);
		return SUCCESS;
	}
	
	public String check(){
		try{
			Subject subject = SecurityUtils.getSubject();
		    Session session = subject.getSession();
		    User user = (User)session.getAttribute("user");
		    deliveryBillService.checkDelioveryBill(Const.DEFAULT_DEPOT_ID, deliveryNo, user);
		    this.addActionMessage("单据号为(" + deliveryNo + ")的单据审核成功!");
		}catch(RuntimeException e){
			this.addActionError(e.getMessage());
		}
		//startDate = CommonUtil.getFirstDayOfTheMonth();
	   // endDate = CommonUtil.getCurrentDate();
		
		return SUCCESS;
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

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getDocketType() {
		return docketType;
	}

	public void setDocketType(String docketType) {
		this.docketType = docketType;
	}

	public Page<Delivery> getPage() {
		return page;
	}

	public void setPage(Page<Delivery> page) {
		this.page = page;
	}

	public IDeliveryService getDeliveryService() {
		return deliveryService;
	}

	public void setDeliveryService(IDeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public IDeliveryBillService getDeliveryBillService() {
		return deliveryBillService;
	}

	public void setDeliveryBillService(IDeliveryBillService deliveryBillService) {
		this.deliveryBillService = deliveryBillService;
	}

}
