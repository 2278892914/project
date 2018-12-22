package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MeetingDao;
import com.vo.meeting;

@Service
public class MeetingService {
	
	@Autowired
	private MeetingDao meetdao;

	public void addmeeting(meeting mt) {
		meetdao.addmeeting(mt);
	}

	public List<meeting> lookmeetingrooms() {
		
		return meetdao.lookmeetingrooms();
	}

	public List<meeting> roomdetail(int roomnum) {
		
		return meetdao.roomdetail(roomnum);
	}

	public void updatemt(meeting mt) {
		meetdao.updatemt(mt);
	}
	
}
