package com.erp.stm.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.stm.IDAO.IReceiptDAO;
import com.erp.stm.model.Receipt;

public class ReceiptDAO implements IReceiptDAO {
	
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Receipt> selectPageList(@SuppressWarnings("rawtypes") Map paramMap) {
		return sqlSession.selectList(SELECT_RECEIPT_PAGE_DATA, paramMap);
	}

	@Override
	public int selectTotleCount(@SuppressWarnings("rawtypes") Map paramMap) {
		return sqlSession.selectOne(SELECT_RECEIPT_PAGE_CNT);
	}

	@Override
	public List<Receipt> selectMulReceipt(@SuppressWarnings("rawtypes") Map parmMap) {
		return sqlSession.selectList(SELECT_MUL_RECEIPT, parmMap);
	}

	



}
