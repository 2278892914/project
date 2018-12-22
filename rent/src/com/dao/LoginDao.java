package com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import VO.AdminVO;


public class LoginDao {
	
	
	public AdminVO login(String user,String pass){
		AdminVO admin = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/rent","root","root");
			
			PreparedStatement pre = 
conn.prepareStatement("SELECT * FROM tab_user WHERE login_name=? AND password=?");
			pre.setString(1, user);
			pre.setString(2, pass);
			ResultSet rs = pre.executeQuery();
			if(rs.next()){
				//只有创建一个对象之后才可以调用其方法
				admin = new AdminVO();
				admin.setUser_name(rs.getString("user_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	
}
