package com.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.Password;

@Service
public class PasswordDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public String getuserpassword(String username) {
		
		return sqlSession.selectOne("p2.getuserpassword",username);
	}

	public void updatepassword(Password pass) {
		sqlSession.update("p2.changepassword", pass);
	}
	
}
