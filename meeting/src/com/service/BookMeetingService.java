package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookMeetingDao;
import com.vo.Department;
import com.vo.domeeting;
import com.vo.employee;
import com.vo.meeting;

@Service
public class BookMeetingService {

	@Autowired
	private BookMeetingDao bookdao;

	public List<meeting> lookmeetname() {
		
		return bookdao.lookmeetname();
	}

	public List<Department> listdept() {
		
		return  bookdao.listdept();
	}

	public List<employee> listemp_1(int departmentid) {
		
		return bookdao.listemp_1(departmentid);
	}

	public void domeet(domeeting dmt) {
		bookdao.domeet(dmt);
	}

	public int getmeetingid() {
		
		return bookdao.getmeetingid();
	}

	public void domeet_1(domeeting dmt) {
		bookdao.domeet_1(dmt);
	}

	

	

	
}
