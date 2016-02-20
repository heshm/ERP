package com.erp.common.IService;

import java.util.List;
import java.util.Map;

import com.erp.common.model.ProductGroup;

public interface IProductGroupService {
	
	public abstract List<ProductGroup> getAllProductGroup();
	
	public abstract int addOneProductGroup(ProductGroup productGroup);
	
	public abstract int deleteOneProductGroup(String groupId);

}
