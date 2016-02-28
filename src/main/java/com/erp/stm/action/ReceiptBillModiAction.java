package com.erp.stm.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.erp.common.action.CmAction;
import com.erp.common.model.User;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;
import com.erp.stm.IService.IReceiptBillService;
import com.erp.stm.IService.IReceiptService;
import com.erp.stm.model.form.ReceiptBillForm;

public class ReceiptBillModiAction extends CmAction{
	
	private Short update;
	private String docketType;
	private String receiptNo;
	private String writeDate;
	private ReceiptBillForm receiptBillForm;
	private IReceiptBillService receiptBillService;
	private IReceiptService receiptService;
	
	public String init(){
		if(Const.UPDATE_RECORD == update){
			Map<String,String> map = new HashMap<String,String>();
			map.put("depotId", Const.DEFAULT_DEPOT_ID);
			map.put("receiptNo", receiptNo);
			receiptBillForm = receiptBillService.getOneReceiptBillForm(map);
			//System.out.println(receiptBillForm.getSumQuantity());
		}else{
			String sqNo = receiptService.getReceiptSeq(Const.DEFAULT_DEPOT_ID);
			//System.out.println(sqNo);
			writeDate = CommonUtil.getCurrentDate("yyyy-MM-dd");
			receiptNo = CommonUtil.getNextRKSeqNo(sqNo);
		}
		//System.out.println(docketType);
		return SUCCESS;
	}
	
	public String modi(){
		//System.out.println(receiptBillForm.toString());
		receiptBillForm.getReceipt().setType(docketType);
		try{
			//System.out.println("sssssss" + receiptBillForm.getReceipt().getWriteDate());
		    Subject subject = SecurityUtils.getSubject();
	        Session session = subject.getSession();
	        User user = (User)session.getAttribute("user");
	        receiptBillForm.getReceipt().setDepotId(Const.DEFAULT_DEPOT_ID);
		    receiptBillService.updateOneReceiptBill(receiptBillForm, user);
		    this.addActionMessage("单据号为(" + receiptBillForm.getReceipt().getReceiptNo() + ")的单据修改成功!");
		    Map<String,String> map = new HashMap<String,String>();
			map.put("depotId", Const.DEFAULT_DEPOT_ID);
			map.put("receiptNo", receiptBillForm.getReceipt().getReceiptNo());
			receiptBillForm = receiptBillService.getOneReceiptBillForm(map);
		}catch(RuntimeException e){
			this.addActionError(e.getMessage());
		}
		//System.out.println("AAAAAAAAAAAAAA");
		//System.out.println(receiptNo);
		
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

	public IReceiptService getReceiptService() {
		return receiptService;
	}

	public void setReceiptService(IReceiptService receiptService) {
		this.receiptService = receiptService;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

}
