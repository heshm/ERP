package com.erp.stm.IDAO;

import java.util.List;
import java.util.Map;

import com.erp.stm.model.DeliveryDetail;

public interface IDeliveryDetailDAO {
	
	public static final String SELECT_MUL_DELIVERY_DETAIL = "selectMulDeliveryDetail";
	
	public static final String DELETE_DELIVERY_DETAIL = "deleteDeliveryDetail";
	
	public static final String INSERT_DELIVERY_DETAIL = "insertDeliveryDetail";
	
	public abstract List<DeliveryDetail> selectMulDeliveryDetail(@SuppressWarnings("rawtypes") Map map);
	
	public abstract int deleteDeliveryDetail(@SuppressWarnings("rawtypes") Map map);
	
	public abstract int insertDeliveryDetail(Map<String,List<DeliveryDetail>> detailMap);

}
