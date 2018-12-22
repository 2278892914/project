package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import VO.TypeVO;


public class TypeDao {

	public List<TypeVO> type(String id){
		
		List<TypeVO> listType = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection comn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/rent","root","root");
			PreparedStatement pre = (PreparedStatement) comn.prepareStatement("SELECT * FROM tab_type WHERE b_id=?");
			
			pre.setString(1,id);
			
			ResultSet rs = pre.executeQuery();
			listType = new ArrayList<TypeVO>();
			while(rs.next()){
				TypeVO tp = new TypeVO();
				tp.setId(rs.getInt("id"));
				tp.setName(rs.getString("name"));
				listType.add(tp);
			
			}
		}
		catch (Exception e) {
			
			e.printStackTrace();
		} 
		return listType;
	}
}
