package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DepartmentDao;
import com.vo.Department;
import com.vo.register;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao deptdao;
	
	public List<Department> dept() {
		
		return deptdao.dept();
	}

	public void regist(register regs) {
		
		deptdao.regit(regs);
	}

	public String userexit(String user) {
		
		return deptdao.userexit(user);
	}

	
}
