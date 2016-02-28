package com.erp.stm.DAOImpl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.erp.stm.IDAO.IInventoryDAO;
import com.erp.stm.model.Inventory;

public class InventoryDAO implements IInventoryDAO {
	
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertUpdateOneInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return sqlSession.insert(INSERT_UPDATE_ONE_INVENTORY, inventory);
	}

	@Override
	public Inventory selectOneInventory(@SuppressWarnings("rawtypes") Map parmMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(SELECT_ONE_INVENTORY, parmMap);
	}

}
