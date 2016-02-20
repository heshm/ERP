package com.erp.common.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.common.IDAO.IProductTypeDAO;
import com.erp.common.model.ProductType;

public class ProductTypeDAO implements IProductTypeDAO {

	private static final String SELECT_MUL_PRODUCT_TYPE = "selectMulProductType";
	
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

}
