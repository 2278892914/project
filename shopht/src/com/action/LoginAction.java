package com.action;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.service.LoginService;
import com.vo.User;

@Component("login")
public class LoginAction {

	@Autowired
	private LoginService service;
	

	private User user;
	//登录
	
	public String login(){
		
		String  m = "";
	  User uu = service.login(user);
	  ActionContext actioncontext = ActionContext.getContext();
		Map<String,Object> session = actioncontext.getSession();
		
	  if(uu!=null){
		  m="success";
	  }else{
		  m="failed";
		  session.put("error", "用户名或者密码错误，请重新登录");
	  }
		return m;
	}
	
	
	
	public LoginService getService() {
		return service;
	}
	public void setService(LoginService service) {
		this.service = service;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
