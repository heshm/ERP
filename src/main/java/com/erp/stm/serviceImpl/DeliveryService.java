package com.erp.stm.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.erp.common.model.Page;
import com.erp.common.util.Const;
import com.erp.stm.IDAO.IDeliveryDAO;
import com.erp.stm.IService.IDeliveryService;
import com.erp.stm.model.Delivery;
import com.erp.stm.model.Receipt;

@Transactional
public class DeliveryService implements IDeliveryService{
	
	private IDeliveryDAO deliveryDAO;

	public IDeliveryDAO getDeliveryDAO() {
		return deliveryDAO;
	}

	public void setDeliveryDAO(IDeliveryDAO deliveryDAO) {
		this.deliveryDAO = deliveryDAO;
	}

	@Override
	public List<Delivery> gettMulDelivery(@SuppressWarnings("rawtypes") Map map) {
		// TODO Auto-generated method stub
		return deliveryDAO.selectMulDelivery(map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<Delivery> getIndexPage(int pageIndex, @SuppressWarnings("rawtypes") Map parmMap) {
		
		Page<Delivery> page = new Page<Delivery>(pageIndex,Const.DEFAULT_BILL_PAGE_SIZE);
		int offset = (pageIndex - 1) * Const.DEFAULT_BILL_PAGE_SIZE;
		
		//temp.put("type", "1");
		int totleCnt = deliveryDAO.selectTotleCount(parmMap);
		
		parmMap.put("offset", offset);
		parmMap.put("limit", Const.DEFAULT_BILL_PAGE_SIZE);
		List<Delivery> result = deliveryDAO.selectPageList(parmMap);
		
		page.setPageData(result);
		
	
		if((offset + Const.DEFAULT_BILL_PAGE_SIZE) >= totleCnt){
			page.setHasNextPage(false);
		}else{
			page.setHasNextPage(true);
		}
		
		if(totleCnt%Const.DEFAULT_BILL_PAGE_SIZE ==0){
			page.setPageCnt(totleCnt/Const.DEFAULT_BILL_PAGE_SIZE);
		}else{
			page.setPageCnt(totleCnt/Const.DEFAULT_BILL_PAGE_SIZE + 1);
		}
		return page;
	}

	@Override
	public String getDeliverySeq(String depotId) {
		// TODO Auto-generated method stub
		return deliveryDAO.selectDeliverySeq(depotId);
	}

}
