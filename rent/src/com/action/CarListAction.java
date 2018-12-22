package com.action;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CarListService;

import VO.CarVO;


public class CarListAction extends HttpServlet{
	
	
	protected void findCarList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
			//页码
			int page = Integer.parseInt(req.getParameter("page"));
			//当前页显示最多的记录数据
			int pageSize = Integer.parseInt(req.getParameter("pageSize"));
			
			CarListService cs = new CarListService();
			
			List<CarVO> list = cs.findCarList(page, pageSize);
			req.setAttribute("listCar", list);
			
			
			int totalPage = cs.findTotalPage(pageSize);
			req.setAttribute("totalPage", totalPage);
			
			req.getRequestDispatcher("car_list.jsp").forward(req, resp);
		
		
	}
	
	
}
