package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import VO.CarVO;


public class CarListDao {
	
	
	public List<CarVO> findCarList(int page,int pageSize){
		List<CarVO> list = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/rent","root","root");
			PreparedStatement pre = conn.prepareStatement
					("SELECT t1.*,t2.name bname,t3.name sname,t4.name "
					+ "tname FROM tab_car_info t1,tab_brand t2,"
					+ "tab_store t3,tab_type t4 WHERE "
					+ "t1.brand_id = t2.id AND  t1.store_id = t3.id AND "
					+ "t4.id = t1.car_type_id limit ?,?");
			pre.setInt(1, (page-1)*pageSize);
			pre.setInt(2, pageSize);
			ResultSet rs = pre.executeQuery();
			list = new ArrayList<CarVO>();
			while(rs.next()){
				CarVO car = new CarVO();
				car.setBname(rs.getString("bname"));
				car.setSname(rs.getString("sname"));
				car.setTname(rs.getString("tname"));
				car.setId(rs.getInt("id"));
				car.setLand_sign(rs.getString("land_sign"));
				car.setHk_sign(rs.getString("hk_sign"));
				list.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public int findCarCount(){
		int totalSize = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/rent","root","root");
			//统计汽车表里有多少条记录
			PreparedStatement pre1 = conn.prepareStatement
					("SELECT count(*) total FROM tab_car_info");
			ResultSet rs1 = pre1.executeQuery();
			
			while(rs1.next()){
				totalSize = rs1.getInt("total");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalSize;
		
	}
	
	
	
}
