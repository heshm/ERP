package com.erp.stm.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.erp.stm.IDAO.IReceiptDetailDAO;
import com.erp.stm.IService.IReceiptDetailService;
import com.erp.stm.model.ReceiptDetail;

@Transactional
public class ReceiptDetailService implements IReceiptDetailService {
	
	private IReceiptDetailDAO receiptDetailDAO;
	
	public IReceiptDetailDAO getReceiptDetailDAO() {
		return receiptDetailDAO;
	}

	public void setReceiptDetailDAO(IReceiptDetailDAO receiptDetailDAO) {
		this.receiptDetailDAO = receiptDetailDAO;
	}

	

	@Override
	public List<ReceiptDetail> getMulReceiptDetail(Map parmMap) {
		// TODO Auto-generated method stub
		return receiptDetailDAO.selectMulReceiptDetail(parmMap);
	}

}
