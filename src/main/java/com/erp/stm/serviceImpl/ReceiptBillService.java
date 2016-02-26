package com.erp.stm.serviceImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.erp.common.model.User;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;
import com.erp.stm.IDAO.IInventoryDAO;
import com.erp.stm.IDAO.IReceiptDAO;
import com.erp.stm.IDAO.IReceiptDetailDAO;
import com.erp.stm.IService.IReceiptBillService;
import com.erp.stm.model.Inventory;
import com.erp.stm.model.Receipt;
import com.erp.stm.model.ReceiptDetail;
import com.erp.stm.model.form.ReceiptBillForm;

@Transactional
public class ReceiptBillService implements IReceiptBillService {

	

	private IReceiptDAO receiptDAO;
	private IReceiptDetailDAO receiptDetailDAO;
	private IInventoryDAO inventoryDAO;
	
	public IReceiptDAO getReceiptDAO() {
		return receiptDAO;
	}

	public void setReceiptDAO(IReceiptDAO receiptDAO) {
		this.receiptDAO = receiptDAO;
	}

	public void setReceiptDetailDAO(IReceiptDetailDAO receiptDetailDAO) {
		this.receiptDetailDAO = receiptDetailDAO;
	}

	public void setInventoryDAO(IInventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
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

	@Override
	public int checkReceiptBillForm(String depotId, String receiptNo ,User user) {
		Map<String,String> parmMap = new HashMap<String,String>();
		parmMap.put("depotId", depotId);
		parmMap.put("receiptNo", receiptNo);
		Receipt receipt = receiptDAO.selectOneReceipt(parmMap);
		//System.out.println(receipt.getStatus());
		if(receipt.getStatus().equals(Const.BILL_UNCONFIRM)){
			List<ReceiptDetail> receiptDetail = receiptDetailDAO.selectMulReceiptDetail(parmMap);
			if (receiptDetail.isEmpty()){
				throw new RuntimeException("单据号为(" + receiptNo + ")的单据下无货品!");
			}
			for (ReceiptDetail detail : receiptDetail){
				Map<String,String> inventoryMap = new HashMap<String,String>();
				inventoryMap.put("depotId", depotId);
				inventoryMap.put("commodityType", detail.getCommodityType());
				Inventory inventory = inventoryDAO.selectOneInventory(inventoryMap);
				if(inventory == null){
					inventory = new Inventory();
					inventory.setDepotId(detail.getDepotId());
					inventory.setCommodityType(detail.getCommodityType());
					inventory.setQuantity(detail.getQuantity());
					inventory.setAveragePrice(detail.getUnitPrice());
					inventory.setAmount(detail.getAmount());
					inventory.setTaxAmt(detail.getTaxAmt());
					inventory.setAverageTaxRate(detail.getTaxRate());
				}else{
					inventory.setQuantity(inventory.getQuantity() + detail.getQuantity());
					BigDecimal quantity = new BigDecimal(inventory.getQuantity().toString());
					inventory.setAmount(
							inventory.getAmount().
							add(detail.getAmount()));
					inventory.setTaxAmt(
							inventory.getTaxAmt().
							add(detail.getTaxAmt()));
					inventory.setAveragePrice(
							inventory.getAmount().
							divide(quantity).
							setScale(Const.DEFAULT_DEC_NO, BigDecimal.ROUND_HALF_UP));
					inventory.setAverageTaxRate(
							inventory.getTaxAmt().
							divide(inventory.getAmount()).
							multiply(new BigDecimal("100")).
							setScale(3, BigDecimal.ROUND_HALF_UP));
				}
				inventoryDAO.insertUpdateOneInventory(inventory);	
			}
			parmMap.put("status", Const.BILL_CONFIRM);
			parmMap.put("auditor", user.getUserName());
			parmMap.put("confirmDate", CommonUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
			receiptDAO.updateOneReceipt(parmMap);
		}else{
			
			throw new RuntimeException("单据号为(" + receiptNo + ")的单据已审核!");
		}
		
		return Const.SUCCESS;
	}

}
