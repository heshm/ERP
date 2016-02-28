package com.erp.stm.DAOImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.stm.IDAO.IReceiptDetailDAO;
import com.erp.stm.model.ReceiptDetail;

public class ReceiptDetailDAO implements IReceiptDetailDAO{

	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<ReceiptDetail> selectMulReceiptDetail(@SuppressWarnings("rawtypes") Map parmMap) {
		return sqlSession.selectList(SELECT_MUL_RECEIPT_DETAIL, parmMap);
	}

	@Override
	public int deleteReceiptDetail(@SuppressWarnings("rawtypes") Map parmMap) {
		// TODO Auto-generated method stub
		return sqlSession.delete(DELETE_RECEIPT_DETAIL,parmMap);
	}

	@Override
	public int insertReceiptDetail(Map parmMap) {
		// TODO Auto-generated method stub
		return sqlSession.insert(INSERT_RECEIPT_DETAIL, parmMap);
	}

}
