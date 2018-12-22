package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.LoginService;

import VO.AdminVO;

public class LoginAction extends HttpServlet{
	
	
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取到用户提交过来的登录信息
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		//检验用户的登录信息是否准确
		
			LoginService ls = new LoginService();
			
			AdminVO admin = ls.login(user, pass);
			
			String path = "login.jsp";
			if(admin != null){
				path = "home.jsp";
				//设置session
				HttpSession session = req.getSession();
				session.setAttribute
				("userName",admin.getUser_name());
			}else{
				String msg = "用户名或密码错误！";
				req.setAttribute("error", msg);
			}
			req.getRequestDispatcher(path)
			.forward(req, resp);
			
	}
	
}
