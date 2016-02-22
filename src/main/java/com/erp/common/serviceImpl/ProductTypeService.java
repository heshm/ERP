package com.erp.common.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.erp.common.IDAO.IProductTypeDAO;
import com.erp.common.IService.IProductTypeService;
import com.erp.common.model.ProductType;
import com.erp.common.util.Const;

@Transactional
public class ProductTypeService implements IProductTypeService {
	
	private IProductTypeDAO productTypeDAO;

	public IProductTypeDAO getProductTypeDAO() {
		return productTypeDAO;
	}

	public void setProductTypeDAO(IProductTypeDAO productTypeDAO) {
		this.productTypeDAO = productTypeDAO;
	}

	public List<ProductType> getMulProductType(Map<String,String> map) {
		return productTypeDAO.selectMulProductType(map);
	}

	public ProductType getOneProductType(Map<String, String> map) {
		return productTypeDAO.selectOneProductType(map);
	}

	public int updateOneProductType(ProductType productType) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("groupId", productType.getGroupId());
		map.put("typeId", productType.getTypeId());
		ProductType temp = productTypeDAO.selectOneProductType(map);
		if (temp == null){
			return Const.FAILURE;
		}else{
			productTypeDAO.updateOneProductType(productType);
		    return Const.SUCCESS;
		}
	}

	@Override
	public int addOneProductType(ProductType productType) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("groupId", productType.getGroupId());
		map.put("typeId", productType.getTypeId());
		ProductType temp = productTypeDAO.selectOneProductType(map);
		if (temp != null){
			return Const.FAILURE;
		}else{
			productTypeDAO.insertOneProductType(productType);
		    return Const.SUCCESS;
		}
	}

	public int deleteOneProductType(Map<String, String> map) {
		return productTypeDAO.deleteOneProductType(map);
	}

}
