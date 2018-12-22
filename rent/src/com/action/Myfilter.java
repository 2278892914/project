package com.action;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Myfilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		//获取用户请求的url
		String path = request.getRequestURI();
		String fp = path.substring(path.indexOf("/"+1));
		//如果用户请求的url不是登录的url则进行拦截
		if(!fp.equals("LoginAction_login.do")){
			//获取session的对象
			HttpSession session = request.getSession();
			//判断seesion是否存放用户登录信息
			Object obj = session.getAttribute("userName");
			//如果没有登录则显示登录页面
			if(obj==null){
				
				HttpServletResponse response = (HttpServletResponse) resp;
				response.sendRedirect("login.jsp");
				return;
			}
		}
		//将请求继续向下提交
		chain.doFilter(req, resp);
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
