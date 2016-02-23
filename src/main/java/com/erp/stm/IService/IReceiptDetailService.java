package com.erp.stm.IService;

import java.util.List;
import java.util.Map;

import com.erp.stm.model.ReceiptDetail;

public interface IReceiptDetailService {
	
	public abstract List<ReceiptDetail> getMulReceiptDetail(@SuppressWarnings("rawtypes") Map parmMap);

}
