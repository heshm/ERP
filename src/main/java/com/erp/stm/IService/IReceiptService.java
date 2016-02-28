package com.erp.stm.IService;

import java.util.Map;

import com.erp.common.IService.IPageService;
import com.erp.stm.model.Receipt;

public interface IReceiptService extends IPageService<Receipt>{
	
	public abstract int deleteOneReceipt(@SuppressWarnings("rawtypes") Map map);
	
	public abstract String getReceiptSeq(String depotId);

}
