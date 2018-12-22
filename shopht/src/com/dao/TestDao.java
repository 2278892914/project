package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.Area;

@Service
public class TestDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Area> getlist() {
		
		return sqlSession.selectList("p1.test");
	}

	public void testdelete(int areaId) {
		sqlSession.delete("p1.testdelete",areaId);
	}

	public Area findById(int areaId) {
		
		return sqlSession.selectOne("p1.findById", areaId);
	}

	public void modifyarea(Area area) {
		sqlSession.update("p1.modifyarea",area);
	}

	public void addarea(Area area) {
		sqlSession.insert("p1.addarea", area);
	}
	
}
