package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TestDao;
import com.vo.Area;

@Service
public class TestService {

	@Autowired
	private TestDao dao;

	public List<Area> getlist() {
		
		return dao.getlist();
	}

	public void testdelte(int areaId) {
		dao.testdelete(areaId);
	}

	public Area findbyId(int areaId) {
		
		return dao.findById(areaId);
	}

	public void modifyarea(Area area) {
		dao.modifyarea(area);
	}

	public void addarea(Area area) {
		dao.addarea(area);
	}
}
