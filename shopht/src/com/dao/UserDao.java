package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.Userlist;

@Service
public class UserDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<Userlist> showuser() {
		
		return sqlSession.selectList("p1.showuser");
	}

	public void delete_user(int id) {
		sqlSession.delete("p1.delete_user", id);
	}
	
}
