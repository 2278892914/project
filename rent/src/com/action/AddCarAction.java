package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.AddCarservice;

import PO.CarPO;

public class AddCarAction extends HttpServlet{

	
	protected void addCar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
		
		CarPO car = new CarPO();
		car.setBrand(brand);
		car.setColor(color);
		car.setHk_sign(hk_sign);
		car.setLand_sign(land_sign);
		car.setType(type);
		car.setStore(store);
		AddCarservice add = new AddCarservice();
		add.addCar(car);
		
		resp.sendRedirect("CarListAction_findCarList.do?page=1&pageSize=5");
		
	}
	
}
