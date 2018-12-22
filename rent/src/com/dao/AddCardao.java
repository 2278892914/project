package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import PO.CarPO;

public class AddCardao {

	public void addCar(CarPO car){
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/rent","root","root");
			
			PreparedStatement pre = conn.prepareStatement("INSERT INTO tab_car_info(brand_id,car_type_id,land_sign,hk_sign,color,store_id) VALUES(?,?,?,?,?,?)");
			
			pre.setString(1, car.getBrand());
			pre.setString(2, car.getType());
			pre.setString(3, car.getLand_sign());
			pre.setString(4, car.getHk_sign());
			pre.setString(5, car.getColor());
			pre.setString(6, car.getStore());
			
			pre.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
	}
}
