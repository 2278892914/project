package com.vo;

import java.sql.Timestamp;

public class CancelMeeting {

	private int meetingid;
	
	private String meetingname;
	private Timestamp starttime;
	private  Timestamp canceledtime;
	private String reason;
	
	public int getMeetingid() {
		return meetingid;
	}
	public void setMeetingid(int meetingid) {
		this.meetingid = meetingid;
	}
	public Timestamp getCanceledtime() {
		return canceledtime;
	}
	public void setCanceledtime(Timestamp canceledtime) {
		this.canceledtime = canceledtime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getMeetingname() {
		return meetingname;
	}
	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	@Override
	public String toString() {
		return "CancelMeeting [meetingname=" + meetingname + ", starttime=" + starttime + "]";
	}
	
	
}
