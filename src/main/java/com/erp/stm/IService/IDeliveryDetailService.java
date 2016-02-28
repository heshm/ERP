package com.erp.stm.IService;

import java.util.List;
import java.util.Map;

import com.erp.stm.model.DeliveryDetail;

public interface IDeliveryDetailService {
	
	public abstract List<DeliveryDetail> getMulDeliveryDetail(@SuppressWarnings("rawtypes") Map parmMap);

}
