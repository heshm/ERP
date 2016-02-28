package com.erp.stm.model.form;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;
import com.erp.stm.model.Receipt;
import com.erp.stm.model.ReceiptDetail;

@SuppressWarnings("serial")
public class ReceiptBillForm implements Serializable{
	
	private Receipt receipt;
	private List<ReceiptDetail> receiptDetail;
	private Float sumQuantity;
	private BigDecimal sumAmount;
	private BigDecimal sumTaxAmt;
	private String writeDate;
	private String confirmDate;
	
	public ReceiptBillForm(){
		super();
	}
	
	public ReceiptBillForm(Receipt receipt){
		this.receipt = receipt;
		if(null != receipt.getWriteDate()){
			this.writeDate = CommonUtil.dataFormat(receipt.getWriteDate());
		}
		if(null != receipt.getConfirmDate()){
			this.confirmDate =  CommonUtil.dataFormat(receipt.getConfirmDate());
		}
	}
	
	public ReceiptBillForm(List<ReceiptDetail> receiptDetail){
		this.receiptDetail = receiptDetail;
	}
	
	public ReceiptBillForm(Receipt receipt , List<ReceiptDetail> receiptDetail){
		this.receipt = receipt;;
		this.receiptDetail = receiptDetail;
		if(null != receipt.getWriteDate()){
			this.writeDate = CommonUtil.dataFormat(receipt.getWriteDate());
		}
		if(null != receipt.getConfirmDate()){
			this.confirmDate =  CommonUtil.dataFormat(receipt.getConfirmDate());
		}
	}
	
	public Receipt getReceipt() {
		return receipt;
	}
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	public List<ReceiptDetail> getReceiptDetail() {
		return receiptDetail;
	}
	public void setReceiptDetail(List<ReceiptDetail> receiptDetail) {
		this.receiptDetail = receiptDetail;
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

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}

}
