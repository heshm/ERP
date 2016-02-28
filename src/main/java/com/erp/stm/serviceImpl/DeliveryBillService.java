package com.erp.stm.serviceImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.erp.common.model.User;
import com.erp.common.util.CommonUtil;
import com.erp.common.util.Const;
import com.erp.stm.IDAO.IDeliveryDAO;
import com.erp.stm.IDAO.IDeliveryDetailDAO;
import com.erp.stm.IDAO.IInventoryDAO;
import com.erp.stm.IService.IDeliveryBillService;
import com.erp.stm.model.Delivery;
import com.erp.stm.model.DeliveryDetail;
import com.erp.stm.model.Inventory;
import com.erp.stm.model.form.DeliveryBillForm;

@Transactional
public class DeliveryBillService implements IDeliveryBillService{

	private IDeliveryDAO deliveryDAO;
	private IDeliveryDetailDAO deliveryDetailDAO;
	private IInventoryDAO inventoryDAO;
	
	public IDeliveryDAO getDeliveryDAO() {
		return deliveryDAO;
	}

	public void setDeliveryDAO(IDeliveryDAO deliveryDAO) {
		this.deliveryDAO = deliveryDAO;
	}

	public IDeliveryDetailDAO getDeliveryDetailDAO() {
		return deliveryDetailDAO;
	}

	public void setDeliveryDetailDAO(IDeliveryDetailDAO deliveryDetailDAO) {
		this.deliveryDetailDAO = deliveryDetailDAO;
	}

	public IInventoryDAO getInventoryDAO() {
		return inventoryDAO;
	}

	public void setInventoryDAO(IInventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}
	
	public DeliveryBillForm getOneDeliveryBillForm(Map map) {
		Delivery delivery = deliveryDAO.selectOneDelivery(map);
		List<DeliveryDetail> deliveryDetailList = deliveryDetailDAO.selectMulDeliveryDetail(map);
		DeliveryBillForm deliveryBillForm = new DeliveryBillForm(delivery , deliveryDetailList);
		
		float sumQuantity = 0f;
	    BigDecimal sumAmount = new BigDecimal("0.00");
	    BigDecimal sumTaxAmt = new BigDecimal("0.00");
	    
	    for(DeliveryDetail deliveryDetail : deliveryDetailList){
	    	sumQuantity += deliveryDetail.getQuantity();
	    	sumAmount = sumAmount.add(deliveryDetail.getAmount());
	    	sumTaxAmt = sumTaxAmt.add(deliveryDetail.getTaxAmt());
	    }
	    deliveryBillForm.setSumQuantity(sumQuantity);
	    deliveryBillForm.setSumAmount(sumAmount);
	    deliveryBillForm.setSumTaxAmt(sumTaxAmt);
	    
		return deliveryBillForm;
	}

	@Override
	public int updateOneDeliveryBill(DeliveryBillForm deliveryBillForm, User user) {
		Delivery delivery = deliveryBillForm.getDelivery();
		
		Map<String,String> deliveryMap = new HashMap<String,String>();
		deliveryMap.put("depotId", delivery.getDepotId());
		deliveryMap.put("deliveryNo", delivery.getDeliveryNo());
		
		Delivery dbrecord = deliveryDAO.selectOneDelivery(deliveryMap);
		if(dbrecord != null){
			System.out.println("AAAAAAAAAAAAAAA");
			if(dbrecord.getStatus().equals(Const.BILL_CONFIRM)){
				throw new RuntimeException("单据号为(" + delivery.getDeliveryNo() + ")的单据已被审核!");
			}else{
				delivery.setStatus(Const.BILL_UNCONFIRM);
				deliveryDAO.updateOneDelivery(delivery);
			}
		}else{
			//Do insert
			System.out.println("BBBBBBBBBBBBBBBBBB");
			delivery.setWriteDate(CommonUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss "));
			delivery.setConfirmDate("");
			delivery.setAuditorId("");
			delivery.setAuditor("");
			delivery.setStatus(Const.BILL_UNCONFIRM);
			delivery.setRegistrantId(user.getUserId());
			delivery.setRegistrant(user.getUserName());
			deliveryDAO.insertOneDelivery(delivery);
		}
		deliveryDetailDAO.deleteDeliveryDetail(deliveryMap);
		List<DeliveryDetail> formList = deliveryBillForm.getDeliveryDetailList();
		if((null != formList)&&(formList.size()!=0)){
			
			//总金额计算
			for(DeliveryDetail detail : formList){
				detail.setDepotId(delivery.getDepotId());
				BigDecimal quantity = new BigDecimal(detail.getQuantity().toString());
				detail.setAmount(detail.getUnitPrice()
					    .multiply(quantity)
					    .setScale(Const.DEFAULT_DEC_NO, BigDecimal.ROUND_HALF_UP));
				detail.setTaxAmt(detail.getUnitPrice()
					    .multiply(quantity)
					    .multiply(detail.getTaxRate())
					    .divide(new BigDecimal("100"))
					    .setScale(Const.DEFAULT_DEC_NO, BigDecimal.ROUND_HALF_UP));
				detail.setDepotId(delivery.getDepotId());
				detail.setDeliveryNo(delivery.getDeliveryNo());
			}
			Map<String,List<DeliveryDetail>> detailMap = new HashMap<String,List<DeliveryDetail>>();
			detailMap.put("deliveryDetailList", formList);
			deliveryDetailDAO.insertDeliveryDetail(detailMap);
		}else{
			throw new RuntimeException("单据号为(" + delivery.getDeliveryNo() + ")的单据下无货品!");
		}
		
		return Const.SUCCESS;
	}
    /**
     * 审核出库单据
     */
	@Override
	public int checkDelioveryBill(String depotId, String deliveryNo, User user) {
		// TODO Auto-generated method stub
		Map<String,String> parmMap = new HashMap<String,String>();
		parmMap.put("depotId", depotId);
		parmMap.put("deliveryNo", deliveryNo);
		
		Delivery delivery = deliveryDAO.selectOneDelivery(parmMap);
		if(delivery.getStatus().equals(Const.BILL_UNCONFIRM)){
			List<DeliveryDetail> detailList = deliveryDetailDAO.selectMulDeliveryDetail(parmMap);
			for(DeliveryDetail detail : detailList){
				Map<String,String> inventoryMap = new HashMap<String,String>();
				inventoryMap.put("depotId", depotId);
				inventoryMap.put("commodityType", detail.getCommodityType());
				Inventory inventory = inventoryDAO.selectOneInventory(inventoryMap);
				
				if(null == inventory){
					throw new RuntimeException("货品(" + detail.getCommodityType() + ")的库存为0!");
				}else{
					inventory.setOutQuantity(inventory.getOutQuantity() + detail.getQuantity());
					
					if(inventory.getOutQuantity() > inventory.getInQuantity()){
						throw new RuntimeException("货品(" + detail.getCommodityType() + ")的库存数量不足!");
					}
					
					BigDecimal quantity = new BigDecimal(inventory.getOutQuantity().toString());
					
					inventory.setOutAmount(
							inventory.getOutAmount().
							add(detail.getAmount()));
			
					inventory.setOutTaxAmt(
							inventory.getOutTaxAmt().
							add(detail.getTaxAmt()));
			
					inventory.setOutAveragePrice(
							inventory.getOutAmount().
							divide(quantity,Const.DEFAULT_DEC_NO,BigDecimal.ROUND_HALF_UP));
					
					inventory.setOutAverageTaxRate(
							inventory.getOutTaxAmt().
							multiply(new BigDecimal("100")).
							divide(inventory.getInAmount(),3,BigDecimal.ROUND_HALF_UP));	
				}
				inventoryDAO.insertUpdateOneInventory(inventory);
			}
			delivery.setStatus(Const.BILL_CONFIRM);
			delivery.setConfirmDate(CommonUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
			delivery.setAuditorId(user.getUserId());
			delivery.setAuditor(user.getUserName());
			deliveryDAO.updateOneDelivery(delivery);
		}else{
			throw new RuntimeException("单据号为(" + deliveryNo + ")的单据已审核!");
		}
		return Const.SUCCESS;
	}

}
