package com.erp.common.IDAO;

import java.util.List;
import java.util.Map;

import com.erp.common.model.ProductType;

public interface IProductTypeDAO {
	
	public static final String SELECT_MUL_PRODUCT_TYPE = "selectMulProductType";
	public static final String SELECT_ONE_PRODUCT_TYPE = "selectOneProductType";
	public static final String UPDATE_ONE_PRODUCT_TYPE = "updateOneProductType";
	public static final String INSERT_ONE_PRODUCT_TYPE = "insertOneProductType";
	public static final String DELETE_ONE_PRODUCT_TYPE = "deleteOneProductType";
	
	public abstract List<ProductType> selectMulProductType(Map<String,String> map);
	
	public abstract ProductType selectOneProductType(Map<String,String> map);
	
	public abstract int updateOneProductType(ProductType productType);
	
	public abstract int deleteOneProductType(Map<String,String> map);
	
	public abstract int insertOneProductType(ProductType productType);

}
