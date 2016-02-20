package com.erp.common.serviceImpl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import com.erp.common.IDAO.IProductGroupDAO;
import com.erp.common.IService.IProductGroupService;
import com.erp.common.model.ProductGroup;

@Transactional
public class ProductGroupService implements IProductGroupService {

	private IProductGroupDAO productGroupDAO;
	public IProductGroupDAO getProductGroupDAO() {
		return productGroupDAO;
	}
	public void setProductGroupDAO(IProductGroupDAO productGroupDAO) {
		this.productGroupDAO = productGroupDAO;
	}
	
	public List<ProductGroup> getAllProductGroup() {
		return productGroupDAO.selectAllProductGroup();
	}
	public int addOneProductGroup(ProductGroup productGroup) {
		ProductGroup temp = productGroupDAO.selectOneProductGroup(productGroup.getGroupId());
		if(temp != null){
			return 0;
		}else{
			productGroupDAO.insertOneProductGroup(productGroup);
			return 1;
		}
	}

	public int deleteOneProductGroup(String groupId) {
		return productGroupDAO.deleteOneProductGroup(groupId);
	}

}
