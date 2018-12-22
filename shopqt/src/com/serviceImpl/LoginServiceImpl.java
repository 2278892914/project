package com.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.mapper.LoginDaoMapper;
import com.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDaoMapper dao;

	public LoginDaoMapper getDao() {
		return dao;
	}

	public void setDao(LoginDaoMapper dao) {
		this.dao = dao;
	}

	@Override
	public User login(User user) {
		return dao.selectlogin(user);
	}

	@Override
	public String f_pass1(User user) {
		
		return dao.f_pass1(user);
	}

	@Override
	public User f_pass2(User user) {
		
		return dao.f_pass2(user);
	}

	@Override
	public void f_pass3(User user) {
		dao.f_pass3(user);
	}

	@Override
	public User user_info1(String username) {
		
		return dao.user_info1(username);
	}

	@Override
	public String selectpassword(String username) {
		return dao.selectpassword(username);
	}

	@Override
	public void modifypassword(Map<Object,Object> map) {
		dao.modifypassword(map);
	}
	
	
	
	
	
	
	
}
