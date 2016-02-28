package com.erp.stm.IDAO;

import java.util.List;
import java.util.Map;

import com.erp.common.IDAO.IPageDAO;
import com.erp.stm.model.Delivery;

public interface IDeliveryDAO extends IPageDAO{
	
	public static final String SELECT_MUL_RECEIPT = "selectMulDelivery";
	
	public static final String SELECT_DELIVERY_PAGE_DATA = "selectDeliveryPageData";
	
	public static final String SELECT_DELIVERY_PAGE_CNT = "selectDeliveryPageCnt";
	
	public static final String SELECT_ONE_DELIVERY = "seletOneDelivery";
	
	public abstract List<Delivery> selectMulDelivery(@SuppressWarnings("rawtypes") Map map);
	
	public Delivery selectOneDelivery(@SuppressWarnings("rawtypes") Map map);
	
	

}
