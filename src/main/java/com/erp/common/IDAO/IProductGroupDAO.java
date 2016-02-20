package com.erp.common.IDAO;

import java.util.List;

import com.erp.common.model.ProductGroup;

public interface IProductGroupDAO {
	
	public abstract ProductGroup selectOneProductGroup(String groupId);
	
	public abstract List<ProductGroup> selectAllProductGroup();
	
	public abstract int insertOneProductGroup(ProductGroup productGroup);
	
	public abstract int deleteOneProductGroup(String groupId);

}
