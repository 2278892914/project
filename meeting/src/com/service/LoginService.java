package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoginDao;
import com.vo.Department;
import com.vo.Login;
import com.vo.employee;

@Service
public class LoginService {

	@Autowired
	private LoginDao logindao;
	
public int login01(String username) {
		
		return logindao.logon01(username);
	}

	public String login02(Login login) {
		
		return logindao.logon02(login);
	}

	public int login03(String username) {
		
		return logindao.login03(username);
	}

	public List<Department> lookdept() {
		
		return logindao.lookdept();
	}
	
	public void deldept(int deptid){
		logindao.deldept(deptid);
	}

	public void adddept(String adddepartmentname) {
		logindao.adddept(adddepartmentname);
	}

	public List<employee> regsapprove() {
		
		return logindao.regsapprove();
	}

	public void approveworker(String username) {
		logindao.approveworker(username);
	}

	public void refuseworker(String username) {
		logindao.refuseworker(username);
	}

	public int login04(String username) {
		
		return logindao.getempid(username);
	}

	public int getvisitcount() {
		
		return logindao.getvisitcount();
	}

	public void updatevisitcount(int newvisitcount) {
		logindao.updatevisitcount(newvisitcount);
	}
	
	
}
