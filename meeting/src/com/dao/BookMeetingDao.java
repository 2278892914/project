package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.Department;
import com.vo.domeeting;
import com.vo.employee;
import com.vo.meeting;

@Service
public class BookMeetingDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<meeting> lookmeetname() {
		
		return sqlSession.selectList("p1.lookmeetname");
	}

	public List<Department> listdept() {
		
		return sqlSession.selectList("p1.selectdepartment");
	}

	public List<employee> listemp_1(int departmentid) {
		return sqlSession.selectList("p2.listemp", departmentid);
	}

	public void domeet(domeeting dmt) {
		sqlSession.insert("p2.domeet", dmt);
	}

	public int getmeetingid() {
		
		return sqlSession.selectOne("p2.getlastid");
	}

	public void domeet_1(domeeting dmt) {
		sqlSession.insert("p2.insertemployee",dmt);
	}
}
