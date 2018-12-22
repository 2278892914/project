package yst;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.print.attribute.standard.Media;
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
		
		String mName = req.getParameter("method");
		String cname = req.getParameter("cname");
		
		try {
			
			Class clazz = Class.forName("yst.vo."+cname);
			Object obj = clazz.newInstance();
			Method me = clazz.getDeclaredMethod(mName, null);
			me.invoke(obj, null);
			
		} catch (Exception e){
			
			e.printStackTrace();
		}
		
	}
}
