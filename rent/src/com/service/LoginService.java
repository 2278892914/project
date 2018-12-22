package com.service;

import com.dao.LoginDao;

import VO.AdminVO;

public class LoginService {
	
	public AdminVO login(String user,String pass){
		
		LoginDao loginDao = new LoginDao();
		return loginDao.login(user, pass);
			
	}
	
	
	
}
