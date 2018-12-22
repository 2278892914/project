package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrderDao;
import com.vo.Order;
import com.vo.OrderInfo;

@Service
public class OrderService {

	@Autowired
	private OrderDao dao;
	
	
	public OrderDao getDao() {
		return dao;
	}
	public void setDao(OrderDao dao) {
		this.dao = dao;
	}
	
	
	public List<Order> order_list() {
		
		return dao.order_list();
	}
	public List<Order> select_order(String ordernum) {
		
		return dao.select_order(ordernum);
	}
	public List<OrderInfo> order_info1(int id) {
		
		return dao.order_info1(id);
	}
	public List<OrderInfo> order_info2(int id) {
		
		return dao.order_info2(id);
	}
	public void delete_order(int id) {
		dao.delete_order(id);
	}
	public void sendgoods(int id) {
		dao.sendgoods(id);
	}
	public List<Order> select_order_1(String ordernum) {
		
		return dao.select_order_1(ordernum);
	}
	
}
