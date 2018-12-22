package com.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.MeetingService;
import com.vo.meeting;

@Component("meeting")
public class MeetingAction {

	@Autowired
	private MeetingService meetservice;
	
	private meeting mt;
	
	public String addmeeting(){
		
		meetservice.addmeeting(mt);
		return "success";
	}
	
	private List<meeting> list;
	public String lookmeetingrooms(){
		
		list = meetservice.lookmeetingrooms();
		return "success";
	}
	private int roomnum;
	
	//查看会议室详情
	public String roomdetail(){
		list = meetservice.roomdetail(roomnum);
		return "success";
	}
	//修改会议室
	public String updatemt(){
		System.out.println(mt);
		meetservice.updatemt(mt);
	   return "success";	
	}
	
	
	
	
	
	
	
	
	
	
	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public List<meeting> getList() {
		return list;
	}
	public void setList(List<meeting> list) {
		this.list = list;
	}
	public meeting getMt() {
		return mt;
	}
	public void setMt(meeting mt) {
		this.mt = mt;
	}
	
	
}
