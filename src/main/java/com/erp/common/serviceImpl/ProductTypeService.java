package com.erp.common.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.erp.common.IDAO.IProductTypeDAO;
import com.erp.common.IService.IProductTypeService;
import com.erp.common.model.ProductType;

@Transactional
public class ProductTypeService implements IProductTypeService {
	
	private IProductTypeDAO ProductTypeDAO;

	public IProductTypeDAO getProductTypeDAO() {
		return ProductTypeDAO;
	}

	public void setProductTypeDAO(IProductTypeDAO productTypeDAO) {
		ProductTypeDAO = productTypeDAO;
	}

	public List<ProductType> getMulProductType(Map<String,String> map) {
		return ProductTypeDAO.selectMulProductType(map);
	}

}
