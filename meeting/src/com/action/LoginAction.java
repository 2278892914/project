package com.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.service.LoginService;
import com.vo.Department;
import com.vo.Login;
import com.vo.employee;

@Component("login")
public class LoginAction {

	@Autowired
	private LoginService loginservice;

	private Login login;
	private String remind;
	private String employeename;
	private String s;
	private int role;
	private int visitcount;
	public String login() {
		String username = login.getAccountname();
		// 用户审批状态
		int state = loginservice.login01(username);
		// 用户名密码是否准确
		employeename = loginservice.login02(login);
		
		// 用户角色
		role = loginservice.login03(username);
		//id
		int employeeid = loginservice.login04(username);
		ActionContext actioncontext = ActionContext.getContext();
		Map<String,Object> session = actioncontext.getSession();
		session.put("user", employeename);
		session.put("role", role);
		session.put("username", username);
		session.put("employeeid",employeeid);
		if (state == 0) {
			remind = "用户待审批";
			s = "002";
		}
		if (state == 2) {
			remind = "审批未通过";
			s = "003";
		}
		if (state == 1 && employeename == null) {
			remind = "账户名或者密码错误，请重新登录";
			s = "004";
		}
		// 正常登录
		if (state == 1 && employeename != null) {
			visitcount = loginservice.getvisitcount();
			session.put("visitcount", visitcount);
			int newvisitcount = visitcount+1;
			loginservice.updatevisitcount(newvisitcount);
			s = "001";
		}
		return s;

	}

	List<Department> lookdept = null;

	// 部门管理时候显示所有部门
	public String lookdept() {
		lookdept = loginservice.lookdept();
		return "success";
	}

	// 删除部门
	private int deptid;

	public String deldept() {
		System.out.println(deptid);
		loginservice.deldept(deptid);
		return "success";
	}

	// 增加部门
	private String adddepartmentname;

	public String adddept() {
		loginservice.adddept(adddepartmentname);
		return "success";
	}

	// 注册审批
	List<employee> regslist = null;

	public String regsapprove() {
		regslist = loginservice.regsapprove();

		return "success";
	}

	// 通过员工注册
	private String username;

	public String approveworker() {
		loginservice.approveworker(username);
		return "success";
	}

	// 不通过员工注册
	public String refuseworker() {
		loginservice.refuseworker(username);
		return "success";
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public List<employee> getRegslist() {
		return regslist;
	}

	public void setRegslist(List<employee> regslist) {
		this.regslist = regslist;
	}

	public String getAdddepartmentname() {
		return adddepartmentname;
	}

	public void setAdddepartmentname(String adddepartmentname) {
		this.adddepartmentname = adddepartmentname;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	

	public int getVisitcount() {
		return visitcount;
	}

	public void setVisitcount(int visitcount) {
		this.visitcount = visitcount;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getRemind() {
		return remind;
	}

	
	public void setRemind(String remind) {
		this.remind = remind;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public List<Department> getLookdept() {
		return lookdept;
	}

	public void setLookdept(List<Department> lookdept) {
		this.lookdept = lookdept;
	}

}
