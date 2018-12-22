package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.CancelMeeting;
import com.vo.domeeting;

@Service
public class NotificationsDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<domeeting> nextmeeting(int employeeid) {
		return sqlSession.selectList("p3.nextmeeting", employeeid);
	}

	public List<domeeting> canselmeeting(int employeeid) {
		return sqlSession.selectList("p3.canselmeeting", employeeid);
	}

	public List<CancelMeeting> cancel(int meetingid) {
		return sqlSession.selectList("p3.cancelmeeting", meetingid);
	}

	public void updatereason(CancelMeeting cancel) {
		sqlSession.update("p3.updatereason", cancel);
	}
	
}
