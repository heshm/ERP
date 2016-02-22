package com.erp.common.IDAO;

import java.util.List;

import com.erp.common.model.ProductGroup;

public interface IProductGroupDAO {
	
	public static final String SELECT_ONE_PRODUCT_GROUP = "selectOneProductGroup";
	public static final String SELECT_ALL_PRODUCT_GROUP = "selectAllProductGroup";
	public static final String INSERT_ONE_PRODUCT_GROUP = "insertOneProductGroup";
	public static final String DELETE_ONE_PRODUCT_GROUP = "deleteOneProductGroup";
	
	public abstract ProductGroup selectOneProductGroup(String groupId);
	
	public abstract List<ProductGroup> selectAllProductGroup();
	
	public abstract int insertOneProductGroup(ProductGroup productGroup);
	
	public abstract int deleteOneProductGroup(String groupId);

}
