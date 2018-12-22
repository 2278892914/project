package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.NotificationsDao;
import com.vo.CancelMeeting;
import com.vo.domeeting;

@Service
public class NotificationsService {
 
	@Autowired
	private NotificationsDao notifidao;

	public List<domeeting> nextmeeting(int employeeid) {
		
		return notifidao.nextmeeting(employeeid);
	}

	public List<domeeting> canselmeeting(int employeeid) {
		return notifidao.canselmeeting(employeeid);
	}

	public List<CancelMeeting> cancel(int meetingid) {
		return notifidao.cancel(meetingid);
	}

	public  void updatereason(CancelMeeting cancel) {
		notifidao.updatereason(cancel);
	} 
}
