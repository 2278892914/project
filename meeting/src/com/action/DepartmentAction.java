package com.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.service.DepartmentService;
import com.vo.Department;
import com.vo.register;

@Component("dept")
public class DepartmentAction {

	@Autowired
	private DepartmentService deptservice;

	List<Department> list = null;

	// 显示注册时候的部门
	public String dept() {
		list = deptservice.dept();

		return "success";
	}

	// 注册员工

	private register regs;
	String error = null;

	public String regist() {
		String user = regs.getUsername();
		// 判断用户名是否重复
		String flag = deptservice.userexit(user);

		// 注册失败,用户名重复
		if (flag != null) {

			error = "用户名重复，注册失败";
			return "fail";

		} else { // 注册成功
			deptservice.regist(regs);

			return "success";
		}
	}

	public String getError() {
		return error;
	}

	public List<Department> getList() {
		return list;
	}

	public register getRegs() {
		return regs;
	}

	public void setRegs(register regs) {
		this.regs = regs;
	}

}
