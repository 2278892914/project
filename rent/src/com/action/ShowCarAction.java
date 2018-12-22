package com.action;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ShowCarService;

import VO.BrandVO;
import VO.StoreVO;


public class ShowCarAction extends HttpServlet{
	
	protected void ShowCar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			ShowCarService ss = new ShowCarService();
			
			List<BrandVO> listBrand = ss.findBrand();
			List<StoreVO> listStore = ss.findStore();
			
			req.setAttribute("listBrand",listBrand);
			req.setAttribute("listStore",listStore);
			
			req.getRequestDispatcher("add_car.jsp").forward(req, resp);
		
	}
	
}
