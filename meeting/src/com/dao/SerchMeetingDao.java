package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.SerchMeet;
import com.vo.domeeting;

@Service
public class SerchMeetingDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<domeeting> serchmeeting(int pagesize) {
		
		return sqlSession.selectList("p2.serchmeeting",pagesize);
	}

	public int getcount() {
		
		return sqlSession.selectOne("p2.getmeetingcount");
	}

	public List<domeeting> meetingdetail(int meetingid) {
		
		return sqlSession.selectList("p2.meetingdetail", meetingid);
	}

	public int getcount01(SerchMeet serchmeet) {
		return sqlSession.selectOne("p2.getcount01",serchmeet );
	}

	public List<domeeting> serchmeeting01(SerchMeet serchmeet) {
		
		return sqlSession.selectList("p2.serchmeeting01", serchmeet);
	}

	public int getcount02(SerchMeet serchmeet) {
		return sqlSession.selectOne("p2.getcount02",serchmeet );
	}

	public List<domeeting> serchmeeting02(SerchMeet serchmeet) {
		
		return sqlSession.selectList("p2.serchmeeting02", serchmeet);
	}

	public List<domeeting> employeedetail(int meetingid) {
		
		return sqlSession.selectList("p2.employeedetail", meetingid);
	}
}
