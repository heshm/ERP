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
	
	public static final String SELECT_DELIVERY_SEQ = "selectDeliverySeq";
	
	public static final String UPDATE_ONE_DELIVERY = "updateOneDelivery";
	
	public static final String INSERT_ONE_DELIVERY = "insertOneDelivery";
	
	public abstract List<Delivery> selectMulDelivery(@SuppressWarnings("rawtypes") Map map);
	
	public abstract Delivery selectOneDelivery(@SuppressWarnings("rawtypes") Map map);
	
	public abstract String selectDeliverySeq(String depotId);
	
	public abstract int updateOneDelivery(Delivery delivery);
	
	public abstract int insertOneDelivery(Delivery delivery);

}
