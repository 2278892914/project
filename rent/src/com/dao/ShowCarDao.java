package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.BrandVO;
import VO.StoreVO;


public class ShowCarDao {
	
	//查询品牌信息
	public List<BrandVO> findBrand(){
		List<BrandVO> listBrand = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/rent","root","root");
					Statement sta2 = conn.createStatement();
					ResultSet rs = sta2.executeQuery("SELECT * FROM tab_brand");
					listBrand = new ArrayList<BrandVO>();
					while(rs.next()){
						BrandVO store = new BrandVO();

						store.setId(rs.getInt("id"));
						store.setName(rs.getString("name"));
						listBrand.add(store); 
						
					}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listBrand;
	}
	
	
	//查找门店信息
	public List<StoreVO> findStore(){
		List<StoreVO> listStore = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/rent","root","root");
			Statement sta2 = conn.createStatement();
			ResultSet rs = sta2.executeQuery("SELECT * FROM tab_store");
			listStore = new ArrayList<StoreVO>();
			while(rs.next()){
				StoreVO store = new StoreVO();

				store.setId(rs.getInt("id"));
				store.setName(rs.getString("name"));
				listStore.add(store);
				
			}
		}
		catch(Exception e) {
			
			  e.printStackTrace();
			
	}
		return listStore;
		
	}
}
