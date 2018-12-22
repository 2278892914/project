package com.vo;

import java.sql.Timestamp;

public class notification {

	
	private Timestamp nexttime;
	private int employeeid;
	
	public Timestamp getNexttime() {
		return nexttime;
	}
	public void setNexttime(Timestamp nexttime) {
		this.nexttime = nexttime;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	
}
