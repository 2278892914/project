package com.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.UserService;
import com.vo.Userlist;

@Component("user")
public class UserAction {

	@Autowired
	private UserService service;

	//展示用户基本信息
	List<Userlist> list;
	public String showuser(){
		list = service.showuser();
		return "success";
	}
	
	//删除用户
	private int id;
	public String delete_user(){
		service.delete_user(id);
		return "success";
	}
	
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Userlist> getList() {
		return list;
	}

	public void setList(List<Userlist> list) {
		this.list = list;
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
}
