package com.erp.common.IDAO;

import java.util.List;
import java.util.Map;

import com.erp.common.model.ProductType;

public interface IProductTypeDAO {
	
	public abstract List<ProductType> selectMulProductType(Map<String,String> map);

}
