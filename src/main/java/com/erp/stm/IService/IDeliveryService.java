package com.erp.stm.IService;

import java.util.List;
import java.util.Map;

import com.erp.common.IService.IPageService;
import com.erp.stm.model.Delivery;

public interface IDeliveryService extends IPageService<Delivery>{
	
	public abstract List<Delivery> gettMulDelivery(@SuppressWarnings("rawtypes") Map map);

}
