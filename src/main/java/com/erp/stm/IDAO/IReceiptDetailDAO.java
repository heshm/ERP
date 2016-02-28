package com.erp.stm.IDAO;

import java.util.List;
import java.util.Map;

import com.erp.stm.model.ReceiptDetail;

public interface IReceiptDetailDAO {
	
	public static final String SELECT_MUL_RECEIPT_DETAIL = "selectMulReceiptDetail";
	
	public static final String DELETE_RECEIPT_DETAIL = "deleteReceiptDetail";
	
	public static final String INSERT_RECEIPT_DETAIL = "insertReceiptDetail";
	
	public abstract List<ReceiptDetail> selectMulReceiptDetail(@SuppressWarnings("rawtypes") Map parmMap);
	
	public abstract int deleteReceiptDetail(@SuppressWarnings("rawtypes") Map parmMap);
	
	public abstract int insertReceiptDetail(@SuppressWarnings("rawtypes") Map parmMap);

}
