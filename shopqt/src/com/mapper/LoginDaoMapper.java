package com.mapper;

import java.util.Map;

import com.entity.User;

public interface LoginDaoMapper {

	public User selectlogin(User user);

	public String f_pass1(User user);

	public User f_pass2(User user);

	public void f_pass3(User user);

	public User user_info1(String username);

	public String selectpassword(String username);

	public void modifypassword(Map<Object,Object> map);

}
