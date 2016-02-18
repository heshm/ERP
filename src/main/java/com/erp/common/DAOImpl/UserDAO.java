package com.erp.common.DAOImpl;

import org.apache.ibatis.session.SqlSession;

import com.erp.common.IDAO.IUserDAO;
import com.erp.common.model.User;

public class UserDAO implements IUserDAO{
	
	private static final String SELECT_ONE_USER = "selectOneUser";
	
    private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int deleteByPrimaryKey(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public User selectByPrimaryKey(String userId) {
		return sqlSession.selectOne(SELECT_ONE_USER, userId);
	}

}
