package com.erp.stm.IDAO;

import java.util.List;
import java.util.Map;

import com.erp.stm.model.DeliveryDetail;

public interface IDeliveryDetailDAO {
	
	public static final String SELECT_MUL_DELIVERY_DETAIL = "selectMulDeliveryDetail";
	
	public abstract List<DeliveryDetail> selectMulDeliveryDetail(@SuppressWarnings("rawtypes") Map map);

}
