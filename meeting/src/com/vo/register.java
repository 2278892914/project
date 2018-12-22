package com.vo;

public class register {

	
	private int employeeid;
	private String employeename;
	private String username;
	private String phone;
	private String email;
	private int status;
	private int departmentid;
	private String password;
	private int role;
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return  employeename +"   " + username+"   " +  phone+"   "
	+ email+"  " +  departmentid+"   "+ password;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
