package com.erp.stm.serviceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.erp.stm.IDAO.IReceiptDAO;
import com.erp.stm.IDAO.IReceiptDetailDAO;
import com.erp.stm.IService.IReceiptBillService;
import com.erp.stm.model.Receipt;
import com.erp.stm.model.ReceiptDetail;
import com.erp.stm.model.form.ReceiptBillForm;

public class ReceiptBillService implements IReceiptBillService {

	

	private IReceiptDAO receiptDAO;
	private IReceiptDetailDAO receiptDetailDAO;
	
	public IReceiptDAO getReceiptDAO() {
		return receiptDAO;
	}

	public void setReceiptDAO(IReceiptDAO receiptDAO) {
		this.receiptDAO = receiptDAO;
	}

	public IReceiptDetailDAO getReceiptDetailDAO() {
		return receiptDetailDAO;
	}

	public void setReceiptDetailDAO(IReceiptDetailDAO receiptDetailDAO) {
		this.receiptDetailDAO = receiptDetailDAO;
	}
	
	@Override
	public ReceiptBillForm getOneReceiptBillForm(@SuppressWarnings("rawtypes") Map parmMap) {
		Receipt receipt = receiptDAO.selectOneReceipt(parmMap);
		List<ReceiptDetail> receiptDetail = receiptDetailDAO.selectMulReceiptDetail(parmMap);
		
		ReceiptBillForm receiptBillForm = new ReceiptBillForm(receipt,receiptDetail);
	    float sumQuantity = 0f;
	    BigDecimal sumAmount = new BigDecimal("0.00");
	    BigDecimal sumTaxAmt = new BigDecimal("0.00");
		for(ReceiptDetail detail : receiptDetail){
			sumQuantity += detail.getQuantity();
			sumAmount = sumAmount.add(detail.getAmount());
			sumTaxAmt = sumTaxAmt.add(detail.getTaxAmt());
		}
		
		receiptBillForm.setSumQuantity(sumQuantity);
		receiptBillForm.setSumAmount(sumAmount);
		receiptBillForm.setSumTaxAmt(sumTaxAmt);
		return receiptBillForm;
	}

}
