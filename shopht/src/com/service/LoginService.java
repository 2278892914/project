package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoginDao;
import com.vo.User;

@Service
public class LoginService {

	@Autowired
	private LoginDao dao;
	public LoginDao getDao() {
		return dao;
	}
	public void setDao(LoginDao dao) {
		this.dao = dao;
	}
	
	public User login(User user) {
		
		return dao.login(user);
	}
	
}
