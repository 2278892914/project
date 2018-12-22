package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.Department;
import com.vo.register;

@Service
public class DepartmentDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Department> dept() {
		
		return sqlSession.selectList("p1.selectdepartment");
	}

	public void regit(register regs) {
		
		sqlSession.insert("p1.insertemployee", regs);
	}

	public String userexit(String user) {
		
		return sqlSession.selectOne("p1.usrexit",user);
		
	}

	
}
