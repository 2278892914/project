package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.service.LoginService;

@Controller
@Scope("prototype")
public class LoginController {

	@Autowired
	private LoginService service;

	public LoginService getService() {
		return service;
	}

	public void setService(LoginService service) {
		this.service = service;
	}
	//登录
	@RequestMapping("/login")
	public ModelAndView login(User user,HttpServletRequest request){
		HttpSession session = request.getSession();
		User u = service.login(user);
		ModelAndView m = new ModelAndView();
		if(u==null){
			m.addObject("error", "账户名或者密码错误");
			m.setViewName("login");
		}else{
			session.setAttribute("username",user.getUsername());
			m.setViewName("index");
		}
		return m;
		
	}
	//找回密码   第一
	@RequestMapping("/f_pass1")
	public ModelAndView f_pass1(User user){
		String question = service.f_pass1(user);
		ModelAndView m = new ModelAndView();
		if(question==null){
			m.addObject("error", "用户名不存在,请重新输入");
			m.addObject("username", user.getUsername());
			m.setViewName("f_pass1");
		}else{
			m.addObject("username", user.getUsername());
			m.addObject("question", question);
			m.setViewName("f_pass2");
		}
		return m;
	}
	//找回密码第二步 ，验证问题是否正确
	@RequestMapping("/f_pass2")
	public ModelAndView f_pass2(User user){
		User u = service.f_pass2(user);
		String question = service.f_pass1(user);
		ModelAndView m = new ModelAndView();
		if(u!=null){
			m.addObject("username", user.getUsername());
			m.setViewName("f_pass3");
		}else{
			m.addObject("error", "答案错误，请重新输入");
			m.addObject("username", user.getUsername());
			m.addObject("question", question);
			m.setViewName("f_pass2");
		}
		return m;
		
	}
	//找回密码第三步，重置密码
	@RequestMapping("/f_pass3")
	public ModelAndView f_pass3(User user){
		service.f_pass3(user);
		ModelAndView m = new ModelAndView();
		m.setViewName("pass_succ");
		return m;
	}
	//我的个人信息
	@RequestMapping("/user_info1")
	public ModelAndView user_info1(HttpServletRequest request){
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		User u = service.user_info1(username);
		ModelAndView m = new ModelAndView();
		List<User> userlist = new ArrayList<User>();
		userlist.add(u);
		m.addObject("userlist", userlist);
		m.setViewName("user_info1");
		return m;
		
	}
	//修改密码
	@RequestMapping("modifypassword")
	public ModelAndView modifypassword(String o_pass,String n_pass,HttpServletRequest request){
		ModelAndView m = new ModelAndView();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String pass = service.selectpassword(username);
		if(pass.equals(o_pass)){
			System.out.println(n_pass+username);
			Map<Object,Object> map = new HashMap<Object,Object>();
			map.put("n_pass", n_pass);
			map.put("username", "username");
			service.modifypassword(map);
			m.setViewName("redirect:user_info1.do");
		}else{
			m.addObject("error", "原密码输入错误");
			m.setViewName("forward:user_info3.jsp");
		}
		return m;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
