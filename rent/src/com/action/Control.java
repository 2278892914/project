package com.action;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Control extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			System.out.println("Control..............");
			
			//获取用户请求的url地址
			String path = req.getRequestURI();
			System.out.println(path);
			String s = path.substring(path.lastIndexOf("/")+1,
					path.lastIndexOf("."));
			
			String [] ss = s.split("_");
			
			Class clazz = Class.forName("com.action."+ss[0]);
			//直接调用类对象的默认构造创建对象
			Object obj = clazz.newInstance();
			
			Method me = clazz.getDeclaredMethod(ss[1],
								HttpServletRequest.class,
								HttpServletResponse.class);
			
			//执行该方法，传参
			me.invoke(obj,req,resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
