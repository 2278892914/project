package com.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.OrderService;
import com.vo.Order;
import com.vo.OrderInfo;

@Component("od")
public class OrderAction {

	@Autowired
	private OrderService service;

	//查询订单列表
	private List<Order> order_list;
	public String order_list(){
		order_list = service.order_list();
		return "success";
	}
	//查询具体某个订单
	private String ordernum;
	public String select_order(){
		if(!ordernum.equals("")){
		order_list = service.select_order(ordernum);
		}else{
		order_list = service.select_order_1(ordernum);	
		}
			
		return "success";
	}
	//订单具体的详情
	private int id;  //订单的id
	private List<OrderInfo> orderlist1;
	private List<OrderInfo> orderlist2;
	public String order_info(){
		orderlist1 = service.order_info1(id);
		orderlist2 = service.order_info2(id);
		return "success";
	}
	
	//删除订单
	public String delete_order(){
		service.delete_order(id);
		return "success";
	}
	
	//发货
	public String sendgoods(){
		service.sendgoods(id);
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	

	public List<OrderInfo> getOrderlist1() {
		return orderlist1;
	}

	public void setOrderlist1(List<OrderInfo> orderlist1) {
		this.orderlist1 = orderlist1;
	}

	public List<OrderInfo> getOrderlist2() {
		return orderlist2;
	}

	public void setOrderlist2(List<OrderInfo> orderlist2) {
		this.orderlist2 = orderlist2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public List<Order> getOrder_list() {
		return order_list;
	}

	public void setOrder_list(List<Order> order_list) {
		this.order_list = order_list;
	}

	public OrderService getService() {
		return service;
	}
	public void setService(OrderService service) {
		this.service = service;
	}
	
}
