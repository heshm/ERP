package com.erp.common.DAOImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.erp.common.IDAO.IProductGroupDAO;
import com.erp.common.model.ProductGroup;

public class ProductGroupDAO implements IProductGroupDAO {
	
    private SqlSession sqlSession;
	

	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}


	public List<ProductGroup> selectAllProductGroup() {
		return sqlSession.selectList(SELECT_ALL_PRODUCT_GROUP);
	}

	public int insertOneProductGroup(ProductGroup productGroup) {
		return sqlSession.insert(INSERT_ONE_PRODUCT_GROUP, productGroup);
	}

	public ProductGroup selectOneProductGroup(String groupId) {
		return sqlSession.selectOne(SELECT_ONE_PRODUCT_GROUP, groupId);
	}

	public int deleteOneProductGroup(String groupId) {
		return sqlSession.delete(DELETE_ONE_PRODUCT_GROUP, groupId);
	}

}
