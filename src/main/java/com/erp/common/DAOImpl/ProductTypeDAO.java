package com.erp.common.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.common.IDAO.IProductTypeDAO;
import com.erp.common.model.ProductType;

public class ProductTypeDAO implements IProductTypeDAO {
	
    private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<ProductType> selectMulProductType(Map<String, String> map) {
		return sqlSession.selectList(SELECT_MUL_PRODUCT_TYPE, map);
	}

	public ProductType selectOneProductType(Map<String, String> map) {
		return sqlSession.selectOne(SELECT_ONE_PRODUCT_TYPE, map);
	}

	public int updateOneProductType(ProductType productType) {
		return sqlSession.update(UPDATE_ONE_PRODUCT_TYPE, productType);
	}

	@Override
	public int deleteOneProductType(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.delete(DELETE_ONE_PRODUCT_TYPE, map);
	}

	public int insertOneProductType(ProductType productType) {
		return sqlSession.insert(INSERT_ONE_PRODUCT_TYPE, productType);
	}

}
