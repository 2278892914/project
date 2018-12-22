package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.meeting;

@Service
public class MeetingDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public void addmeeting(meeting mt) {
		sqlSession.insert("p1.addmeeting",mt);
	}

	public List<meeting> lookmeetingrooms() {
		
		return sqlSession.selectList("p1.lookmeeting");
		
	}

	public List<meeting> roomdetail(int roomnum) {
		return sqlSession.selectList("p1.lookmeetingdetail", roomnum);
	}

	public void updatemt(meeting mt) {
		sqlSession.update("p1.updatemeeting", mt);
	}
	
}
