package com.erp.stm.serviceImpl;

import java.util.List;
import java.util.Map;

import com.erp.common.model.Page;
import com.erp.common.util.Const;
import com.erp.stm.IDAO.IReceiptDAO;
import com.erp.stm.IService.IReceiptService;
import com.erp.stm.model.Receipt;

public class ReceiptService implements IReceiptService {
	
	private IReceiptDAO receiptDAO;


	public IReceiptDAO getReceiptDAO() {
		return receiptDAO;
	}


	public void setReceiptDAO(IReceiptDAO receiptDAO) {
		this.receiptDAO = receiptDAO;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Page<Receipt> getIndexPage(int pageIndex, @SuppressWarnings("rawtypes") Map parmMap){
		Page<Receipt> page = new Page<Receipt>(pageIndex,Const.DEFAULT_BILL_PAGE_SIZE);
		int offset = (pageIndex - 1) * Const.DEFAULT_BILL_PAGE_SIZE;
		
		parmMap.put("offset", offset);
		parmMap.put("limit", Const.DEFAULT_BILL_PAGE_SIZE);
		List<Receipt> result = receiptDAO.selectPageList(parmMap);
		page.setPageData(result);
		int totleCnt = receiptDAO.selectTotleCount(parmMap);
        
		if((offset + Const.DEFAULT_BILL_PAGE_SIZE) >= totleCnt){
			page.setHasNextPage(false);
		}else{
			page.setHasNextPage(true);
		}
		
		if(totleCnt%Const.DEFAULT_BILL_PAGE_SIZE ==0){
			page.setPageCnt(totleCnt/Const.DEFAULT_BILL_PAGE_SIZE);
		}else{
			page.setPageCnt(totleCnt/Const.DEFAULT_BILL_PAGE_SIZE + 1);
		}
		return page;
	}

}
