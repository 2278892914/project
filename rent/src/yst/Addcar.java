package yst;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Addcar extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//设置中文乱码问题
		
		//设置以post请求的乱码问题
		//获取req所封装的属性的值
		req.setCharacterEncoding("utf-8");
		
		//获取值
		String brand = req.getParameter("brand");
		String type = req.getParameter("type");
		String land_sign = req.getParameter("land_sign");
		String hk_sign = req.getParameter("hk_sign");
		String color = req.getParameter("color");
		String store = req.getParameter("store");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/rent","root","root");
			
			PreparedStatement pre = conn.prepareStatement("INSERT INTO tab_car_info(brand_id,car_type_id,land_sign,hk_sign,color,store_id) VALUES(?,?,?,?,?,?)");
			
			pre.setString(1, brand);
			pre.setString(2, type);
			pre.setString(3, land_sign);
			pre.setString(4, hk_sign);
			pre.setString(5, color);
			pre.setString(6, store);
			
			pre.executeUpdate();
			/*
			采用重定向将页面跳转至显示车辆信息页面
			如果采用的是转发，跳转时候处理的将会是同一个url，将会重复添加两次
			因此使用重定向，处理不同的请求，达到不重复添加的效果
			 */
			resp.sendRedirect("Carlist.do?page=1&pageSize=5");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
