package com.erp.stm.IDAO;

import java.util.List;
import java.util.Map;

import com.erp.stm.model.ReceiptDetail;

public interface IReceiptDetailDAO {
	
	public static final String SELECT_MUL_RECEIPT_DETAIL = "selectMulReceiptDetail";
	
	public abstract List<ReceiptDetail> selectMulReceiptDetail(@SuppressWarnings("rawtypes") Map parmMap);

}
