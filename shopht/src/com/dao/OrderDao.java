package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.Order;
import com.vo.OrderInfo;

@Service
public class OrderDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	public List<Order> order_list() {
		return sqlSession.selectList("p2.order_list");
	}
	public List<Order> select_order(String ordernum) {
		return sqlSession.selectList("p2.select_order", ordernum);
	}
	public List<OrderInfo> order_info1(int id) {
		
		return sqlSession.selectList("p2.order_info1",id);
	}
	public List<OrderInfo> order_info2(int id) {
		
		return sqlSession.selectList("p2.order_info2", id);
	}
	public void delete_order(int id) {
		sqlSession.delete("p2.delete_order",id);
	}
	public void sendgoods(int id) {
		sqlSession.update("p2.sendgoods", id);
	}
	public List<Order> select_order_1(String ordernum) {
	
		return sqlSession.selectList("p2.order_list");
	}
	
}
