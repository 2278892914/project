package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.vo.Userlist;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	public List<Userlist> showuser() {
		
		return dao.showuser();
	}
	public void delete_user(int id) {
		dao.delete_user(id);
	}
	
}
