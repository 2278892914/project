package com.action;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 运用反射机制，替代web.xml的servlet的配置
 */
public class Control01 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getRequestURI();
		
		String s = path.substring(path.lastIndexOf("/")+1,path.indexOf("."));
		String[] ss = s.split("_");
		
		//运用反射
		try {
			//映射出类
			Class clazz = Class.forName("com.action"+ss[0]);
			//调用类对象的默认构造创建对象
			Object obj = clazz.newInstance();
			Method method  = clazz.getDeclaredMethod(ss[1], HttpServletRequest.class,HttpServletResponse.class);
			
			//执行方法，传参
			
			//            类名，传递的参数
			method.invoke(obj, req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
