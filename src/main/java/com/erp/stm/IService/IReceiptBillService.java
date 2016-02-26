package com.erp.stm.IService;

import java.util.Map;

import com.erp.common.model.User;
import com.erp.stm.model.form.ReceiptBillForm;

public interface IReceiptBillService {
	
	public abstract ReceiptBillForm getOneReceiptBillForm(@SuppressWarnings("rawtypes") Map parmMap);
	
	public abstract int checkReceiptBillForm(String depotId,String receiptNo,User user);

}
