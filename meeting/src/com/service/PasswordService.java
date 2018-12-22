package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PasswordDao;
import com.vo.Password;

@Service
public class PasswordService {
	
	@Autowired
	private PasswordDao passdao;

	public String getuserpassword(String username) {
		
		return passdao.getuserpassword(username);
	}

	public void updatepassword(Password pass) {
		passdao.updatepassword(pass);
	}
	
}
