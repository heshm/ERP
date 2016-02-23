package com.erp.stm.IDAO;

import java.util.List;
import java.util.Map;

import com.erp.common.IDAO.IPageDAO;
import com.erp.stm.model.Receipt;

public interface IReceiptDAO extends IPageDAO{
	
	public static final String SELECT_RECEIPT_PAGE_DATA = "selectReceiptPageData";
	
	public static final String SELECT_RECEIPT_PAGE_CNT = "selectReceiptPageCnt";
	
	public static final String SELECT_MUL_RECEIPT = "selectMulReceipt";
	
	public static final String SELECT_ONE_RECEIPT = "selectOneReceipt";
	
	public static final String DELETE_ONE_RECEIPT = "deleteOneReceipt";
	
	public static final String UPDATE_ONE_RECEIPT = "updateOneReceipt";
	
	public abstract List<Receipt> selectMulReceipt(@SuppressWarnings("rawtypes") Map parmMap);
	
	public abstract Receipt selectOneReceipt(@SuppressWarnings("rawtypes") Map parmMap);
	
	public abstract int deleteOneReceipt(@SuppressWarnings("rawtypes") Map parmMap);
	
	public abstract int updateOneReceipt(@SuppressWarnings("rawtypes") Map parmMap);

}
