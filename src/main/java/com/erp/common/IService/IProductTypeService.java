package com.erp.common.IService;

import java.util.List;
import java.util.Map;

import com.erp.common.model.ProductType;

public interface IProductTypeService {
	
	public abstract List<ProductType> getMulProductType(Map<String,String> map);
	
	public abstract ProductType getOneProductType(Map<String,String> map);
	
	public abstract int updateOneProductType(ProductType productType);
	
	public abstract int addOneProductType(ProductType productType);
	
	public abstract int deleteOneProductType(Map<String,String> map);

}
