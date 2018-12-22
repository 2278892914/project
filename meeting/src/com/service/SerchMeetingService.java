package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SerchMeetingDao;
import com.vo.SerchMeet;
import com.vo.domeeting;

@Service
public class SerchMeetingService {

	@Autowired
	private SerchMeetingDao serchmeetingdao;

	public List<domeeting> serchmeeting(int pagesize) {
		
		return serchmeetingdao.serchmeeting(pagesize);
	}

	public int getmeetingcount() {
		
		return serchmeetingdao.getcount();
	}

	public List<domeeting> meetingdetail(int meetingid) {
	
		return serchmeetingdao.meetingdetail(meetingid);
	}

	public int getcount01(SerchMeet serchmeet) {
		
		return serchmeetingdao.getcount01(serchmeet);
	}

	public List<domeeting> serchmeeting01(SerchMeet serchmeet) {
	    return  serchmeetingdao.serchmeeting01(serchmeet); 
	}

	public int getcount02(SerchMeet serchmeet) {
		
		return serchmeetingdao.getcount02(serchmeet);
	}

	public List<domeeting> serchmeeting02(SerchMeet serchmeet) {
		
		return serchmeetingdao.serchmeeting02(serchmeet); 
	}

	public List<domeeting> employeedetail(int meetingid) {
		
		return serchmeetingdao.employeedetail(meetingid);
	}

	
}
