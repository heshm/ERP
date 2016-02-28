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
		if(user.getUserId().equals(receipt.getWriterId())){
			throw new RuntimeException("登记人与审核人不能是同一人!");
		}
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
					//System.out.println("AAAAA");
					inventory.setDepotId(detail.getDepotId());
					inventory.setCommodityType(detail.getCommodityType());
					inventory.setInQuantity(detail.getQuantity());
					inventory.setInAveragePrice(detail.getUnitPrice());
					inventory.setInAmount(detail.getAmount());
					inventory.setInTaxAmt(detail.getTaxAmt());
					inventory.setInAverageTaxRate(detail.getTaxRate());
					
					inventory.setOutQuantity(0f);
					inventory.setOutAveragePrice(new BigDecimal("0.00"));
					inventory.setOutAverageTaxRate(new BigDecimal("0.00"));
					inventory.setOutTaxAmt(new BigDecimal("0.00"));
					inventory.setOutAmount(new BigDecimal("0.00"));
					
				}else{
					inventory.setInQuantity(inventory.getInQuantity() + detail.getQuantity());
					BigDecimal quantity = new BigDecimal(inventory.getInQuantity().toString());
		
					inventory.setInAmount(
							inventory.getInAmount().
							add(detail.getAmount()));
			
					inventory.setInTaxAmt(
							inventory.getInTaxAmt().
							add(detail.getTaxAmt()));
			
					inventory.setInAveragePrice(
							inventory.getInAmount().
							divide(quantity,Const.DEFAULT_DEC_NO,BigDecimal.ROUND_HALF_UP));
					
					inventory.setInAverageTaxRate(
							inventory.getInTaxAmt().
							multiply(new BigDecimal("100")).
							divide(inventory.getInAmount(),3,BigDecimal.ROUND_HALF_UP));
					
					
				}
				inventoryDAO.insertUpdateOneInventory(inventory);	
				//System.out.println("JJJJ");
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

	@Override
	public int updateOneReceiptBill(ReceiptBillForm receiptBillForm,User user) {
		Receipt receipt = receiptBillForm.getReceipt();
		Map<String,String> receiptMap = new HashMap<String,String>();
		receiptMap.put("depotId", receipt.getDepotId());
		receiptMap.put("receiptNo", receipt.getReceiptNo());
		Receipt temp = receiptDAO.selectOneReceipt(receiptMap);
		if(temp != null){
			if(temp.getStatus().equals(Const.BILL_CONFIRM)){
				throw new RuntimeException("单据号为(" + receipt.getReceiptNo() + ")的单据已被审核!");
			}else{
				receipt.setStatus(Const.BILL_UNCONFIRM);
				//System.out.println(receipt.getWriteDate());
				receiptDAO.updateOneReceipt(receipt);
			}
			
		}else{
			receipt.setWriteDate(CommonUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss "));
			receipt.setConfirmDate("");
			receipt.setAuditor("");
			receipt.setStatus(Const.BILL_UNCONFIRM);
			receipt.setWriterId(user.getUserId());
			receipt.setWriterName(user.getUserName());
			receiptDAO.insertOneReceipt(receipt);
		}
		receiptDetailDAO.deleteReceiptDetail(receiptMap);
	
		List<ReceiptDetail> list = receiptBillForm.getReceiptDetail();
		
		if (list != null){
		    for(ReceiptDetail receiptDetial : list){
			    BigDecimal quantity = new BigDecimal(receiptDetial.getQuantity().toString());
			    receiptDetial.setAmount(receiptDetial.getUnitPrice()
					    .multiply(quantity)
					    .setScale(Const.DEFAULT_DEC_NO, BigDecimal.ROUND_HALF_UP));
			    receiptDetial.setTaxAmt(receiptDetial.getUnitPrice()
					    .multiply(quantity)
					    .multiply(receiptDetial.getTaxRate())
					    .divide(new BigDecimal("100"))
					    .setScale(Const.DEFAULT_DEC_NO, BigDecimal.ROUND_HALF_UP));
			    receiptDetial.setDepotId(receipt.getDepotId());
			    receiptDetial.setReceiptNo(receipt.getReceiptNo());
		    }
		    Map<String,List<ReceiptDetail>> detailMap = new HashMap<String,List<ReceiptDetail>>();
			detailMap.put("receiptDetailList", list);
			receiptDetailDAO.insertReceiptDetail(detailMap);
		}else{
			throw new RuntimeException("单据号为(" + receipt.getReceiptNo() + ")的单据下无货品!");
		}
		return Const.SUCCESS;
	}

}
