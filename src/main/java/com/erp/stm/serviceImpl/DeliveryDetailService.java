package com.erp.stm.serviceImpl;

import java.util.List;
import java.util.Map;

import com.erp.stm.IDAO.IDeliveryDetailDAO;
import com.erp.stm.IService.IDeliveryDetailService;
import com.erp.stm.model.DeliveryDetail;

public class DeliveryDetailService implements IDeliveryDetailService {

	private IDeliveryDetailDAO deliveryDetailDAO;
	public IDeliveryDetailDAO getDeliveryDetailDAO() {
		return deliveryDetailDAO;
	}
	public void setDeliveryDetailDAO(IDeliveryDetailDAO deliveryDetailDAO) {
		this.deliveryDetailDAO = deliveryDetailDAO;
	}
	@Override
	public List<DeliveryDetail> getMulDeliveryDetail(Map parmMap) {
		// TODO Auto-generated method stub
		return deliveryDetailDAO.selectMulDeliveryDetail(parmMap);
	}

}
