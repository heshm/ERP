package com.erp.stm.serviceImpl;

import java.util.List;
import java.util.Map;

import com.erp.stm.IDAO.IDeliveryDAO;
import com.erp.stm.IDAO.IDeliveryDetailDAO;
import com.erp.stm.IDAO.IInventoryDAO;
import com.erp.stm.IService.IDeliveryBillService;
import com.erp.stm.model.Delivery;
import com.erp.stm.model.DeliveryDetail;
import com.erp.stm.model.form.DeliveryBillForm;

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
		
		return null;
	}

}
