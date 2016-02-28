package com.erp.stm.IService;

import java.util.Map;

import com.erp.common.model.User;
import com.erp.stm.model.form.DeliveryBillForm;

public interface IDeliveryBillService {
	
	public abstract DeliveryBillForm getOneDeliveryBillForm(Map map);
	
	public abstract int updateOneDeliveryBill(DeliveryBillForm form,User user);
	
	public abstract int checkDelioveryBill(String depotId,String deliveryNo,User user);

}
