package com.action;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.NotificationsService;
import com.service.SerchMeetingService;
import com.vo.CancelMeeting;
import com.vo.domeeting;
import com.vo.notification;

@Component("notif")
public class NotificationsAction {

	@Autowired
	private NotificationsService nitiservice;
	@Autowired
	private SerchMeetingService serchmeetservice;
	//获得登录用户的id
	private int employeeid;
	private notification noti;
	List<domeeting> list01;
	List<domeeting> list02;
	public String notifications(){
//		noti.setEmployeeid(employeeid);
//		noti.setNexttime(new Timestamp(System.currentTimeMillis()+30*24*60*60*1000));
		//未来30天会议
		HttpServletRequest request = ServletActionContext.getRequest(); 
		 HttpSession session = request.getSession();
		 int employeeid = (int) session.getAttribute("employeeid");
		list01  =  nitiservice.nextmeeting(employeeid);
		list02  =  nitiservice.canselmeeting(employeeid);
		return "success";
		
	}

	//我的预定
	public String mybook(){
		HttpServletRequest request = ServletActionContext.getRequest(); 
		 HttpSession session = request.getSession();
		 int employeeid = (int) session.getAttribute("employeeid");
		 
		list01 = nitiservice.nextmeeting(employeeid); 
		return "success";
	}
	
	//取消会议
	List<CancelMeeting> list03;
	private int meetingid;
	
	public String cancel(){
		
		list03 = nitiservice.cancel(meetingid);
		
		return "success";
	}
	
	List<domeeting> meetingdetail ;
	List<domeeting> employeedetail ;
	public String mymeetingdetails(){
		
		meetingdetail = serchmeetservice.meetingdetail(meetingid);
		employeedetail = serchmeetservice.employeedetail(meetingid);
		return "success";
	}
	//确认取消会议
	
	private CancelMeeting cancel;
     public String updatereason(){
    	 cancel.setMeetingid(meetingid);
		cancel.setCanceledtime(new Timestamp(System.currentTimeMillis()));
    	 nitiservice.updatereason(cancel);
    	 return "success";
		
	}
	
	public String mymeeing(){
		HttpServletRequest request = ServletActionContext.getRequest(); 
		 HttpSession session = request.getSession();
		 int employeeid = (int) session.getAttribute("employeeid");
		 
		list01 = nitiservice.nextmeeting(employeeid); 
		
		return "success";
	}
	
	
	
	
	
	
	
	public List<domeeting> getEmployeedetail() {
		return employeedetail;
	}

	public void setEmployeedetail(List<domeeting> employeedetail) {
		this.employeedetail = employeedetail;
	}

	public CancelMeeting getCancel() {
		return cancel;
	}

	public void setCancel(CancelMeeting cancel) {
		this.cancel = cancel;
	}

	public List<domeeting> getMeetingdetail() {
		return meetingdetail;
	}

	public void setMeetingdetail(List<domeeting> meetingdetail) {
		this.meetingdetail = meetingdetail;
	}

	public List<CancelMeeting> getList03() {
		return list03;
	}

	public void setList03(List<CancelMeeting> list03) {
		this.list03 = list03;
	}

	public int getMeetingid() {
		return meetingid;
	}

	public void setMeetingid(int meetingid) {
		this.meetingid = meetingid;
	}

	public List<domeeting> getList01() {
		return list01;
	}


	public void setList01(List<domeeting> list01) {
		this.list01 = list01;
	}

	public List<domeeting> getList02() {
		return list02;
	}

	public void setList02(List<domeeting> list02) {
		this.list02 = list02;
	}

	public notification getNoti() {
		return noti;
	}

	public void setNoti(notification noti) {
		this.noti = noti;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

}
