package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.Department;
import com.vo.Login;
import com.vo.employee;

@Service
public class LoginDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	//用户审批的状态
		public int logon01(String username) {
			
			return sqlSession.selectOne("p1.login01",username);
		}

		public String logon02(Login login) {
			
			return sqlSession.selectOne("p1.login02",login);
		}

		public int login03(String username) {
			
			return sqlSession.selectOne("p1.login03", username);
		}

		
		public List<Department> lookdept() {
			
			return sqlSession.selectList("p1.lookdept");
		}

		public void deldept(int deptid) {
			sqlSession.delete("p1.deldept", deptid);
		
		}

		public void adddept(String adddepartmentname) {
			sqlSession.insert("p1.adddept", adddepartmentname);
		}

		public List<employee> regsapprove() {
			
			return sqlSession.selectList("p1.regs");
		}

		public void approveworker(String username) {
			sqlSession.update("p1.approveworker", username);
		}

		public void refuseworker(String username) {
			sqlSession.update("p1.refuseworker", username);
		}

		public int getempid(String username) {
			
			return sqlSession.selectOne("p2.getempid", username);
		}

		public int getvisitcount() {
			
			return sqlSession.selectOne("p3.getcount");
		}

		public void updatevisitcount(int newvisitcount) {
			sqlSession.update("p3.updatecount",newvisitcount);
		}
}
