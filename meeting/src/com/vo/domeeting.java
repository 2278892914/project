package com.vo;

import java.sql.Timestamp;
import java.util.Arrays;

public class domeeting {

	private String canceledreason;
	private String employeename;
	private String phone;
	private String email;
	private String roomname;
	private int meetingid;
	private int employeeid;
	private String meetingname;
	private int numberofparticipants;
	private Timestamp starttime;
	private Timestamp endtime;
	private int roomid;
	private String description;
	private String[] selSelectedEmployees;
	private Timestamp reservationtime;
	private String ee;
	
	public String getCanceledreason() {
		return canceledreason;
	}
	public void setCanceledreason(String canceledreason) {
		this.canceledreason = canceledreason;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
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
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public String getEe() {
		return ee;
	}
	public void setEe(String ee) {
		this.ee = ee;
	}
	public int getMeetingid() {
		return meetingid;
	}
	public void setMeetingid(int meetingid) {
		this.meetingid = meetingid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getMeetingname() {
		return meetingname;
	}
	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}
	public int getNumberofparticipants() {
		return numberofparticipants;
	}
	public void setNumberofparticipants(int numberofparticipants) {
		this.numberofparticipants = numberofparticipants;
	}
	
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public Timestamp getEndtime() {
		return endtime;
	}
	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String[] getSelSelectedEmployees() {
		return selSelectedEmployees;
	}
	public void setSelSelectedEmployees(String[] selSelectedEmployees) {
		this.selSelectedEmployees = selSelectedEmployees;
	}
	public Timestamp getReservationtime() {
		return reservationtime;
	}
	public void setReservationtime(Timestamp reservationtime) {
		this.reservationtime = reservationtime;
	}
	@Override
	public String toString() {
		return "domeeting [canceledreason=" + canceledreason + ", employeename=" + employeename + ", phone=" + phone
				+ ", email=" + email + ", roomname=" + roomname + ", meetingid=" + meetingid + ", employeeid="
				+ employeeid + ", meetingname=" + meetingname + ", numberofparticipants=" + numberofparticipants
				+ ", starttime=" + starttime + ", endtime=" + endtime + ", roomid=" + roomid + ", description="
				+ description + ", selSelectedEmployees=" + Arrays.toString(selSelectedEmployees) + ", reservationtime="
				+ reservationtime + ", ee=" + ee + ", getCanceledreason()=" + getCanceledreason()
				+ ", getEmployeename()=" + getEmployeename() + ", getPhone()=" + getPhone() + ", getEmail()="
				+ getEmail() + ", getRoomname()=" + getRoomname() + ", getEe()=" + getEe() + ", getMeetingid()="
				+ getMeetingid() + ", getEmployeeid()=" + getEmployeeid() + ", getMeetingname()=" + getMeetingname()
				+ ", getNumberofparticipants()=" + getNumberofparticipants() + ", getStarttime()=" + getStarttime()
				+ ", getEndtime()=" + getEndtime() + ", getRoomid()=" + getRoomid() + ", getDescription()="
				+ getDescription() + ", getSelSelectedEmployees()=" + Arrays.toString(getSelSelectedEmployees())
				+ ", getReservationtime()=" + getReservationtime() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
