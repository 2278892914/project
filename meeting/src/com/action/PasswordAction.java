package com.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.PasswordService;
import com.vo.Password;

@Component("password")
public class PasswordAction {

	@Autowired
	private PasswordService passservice;
	private Password pass;
	//更改密码
	private String error;
	public String updatepassword(){
		String username = pass.getUsername();
		if("".equals(pass.getNowpassword())||"".equals(pass.getYuanpassword())||"".equals(pass.getSurepassword())){
			error="密码有输入为空的,请重新输入";
			return "fail01";
		}
		
		//获取用户名对应的密码
		String userpassword = passservice.getuserpassword(username);
		if(!(userpassword.equals(pass.getYuanpassword()))){
			error = "原密码输入错误，请重新输入";
			return "fail02";
		}
		if(!(pass.getNowpassword().equals(pass.getSurepassword()))){
			error = "修改密码输入不一致，请重输入密码";
			return "fail03";
		}
		passservice.updatepassword(pass);
		return "success";
	}
	
	
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Password getPass() {
		return pass;
	}
	public void setPass(Password pass) {
		this.pass = pass;
	}
	
	
}
