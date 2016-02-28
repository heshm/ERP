package com.erp.stm.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.stm.IDAO.IDeliveryDetailDAO;
import com.erp.stm.model.DeliveryDetail;

public class DeliveryDetailDAO implements IDeliveryDetailDAO {

	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<DeliveryDetail> selectMulDeliveryDetail(@SuppressWarnings("rawtypes") Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(SELECT_MUL_DELIVERY_DETAIL, map);
	}

	@Override
	public int deleteDeliveryDetail(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.delete(DELETE_DELIVERY_DETAIL, map);
	}

	@Override
	public int insertDeliveryDetail(Map<String, List<DeliveryDetail>> detailMap) {
		// TODO Auto-generated method stub
		return sqlSession.insert(INSERT_DELIVERY_DETAIL, detailMap);
	}

}
