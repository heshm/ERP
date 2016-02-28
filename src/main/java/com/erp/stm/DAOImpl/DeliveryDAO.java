package com.erp.stm.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.stm.IDAO.IDeliveryDAO;
import com.erp.stm.model.Delivery;

public class DeliveryDAO implements IDeliveryDAO {
	
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<Delivery> selectMulDelivery(@SuppressWarnings("rawtypes") Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(SELECT_MUL_RECEIPT, map);
	}

	@Override
	public List<Delivery> selectPageList(Map paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(SELECT_DELIVERY_PAGE_DATA, paramMap);
	}

	@Override
	public int selectTotleCount(Map paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(SELECT_DELIVERY_PAGE_CNT, paramMap);
	}

	@Override
	public Delivery selectOneDelivery(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(SELECT_ONE_DELIVERY, map);
	}

	@Override
	public String selectDeliverySeq(String depotId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(SELECT_DELIVERY_SEQ,depotId);
	}

	@Override
	public int updateOneDelivery(Delivery delivery) {
		// TODO Auto-generated method stub
		return sqlSession.update(UPDATE_ONE_DELIVERY, delivery);
	}

	@Override
	public int insertOneDelivery(Delivery delivery) {
		// TODO Auto-generated method stub
		return sqlSession.insert(INSERT_ONE_DELIVERY, delivery);
	}

}
