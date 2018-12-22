package com.vo;
/**
 
 *
 */
public class Order {

	private int id;
	private String ordernum;
	private double totalprice;
	private String createtime;
	private int orderstate;
	private int paytype;
	private int userid;
	private String username;
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
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(int orderstate) {
		this.orderstate = orderstate;
	}
	public int getPaytype() {
		return paytype;
	}
	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", ordernum=" + ordernum + ", totalprice=" + totalprice + ", createtime="
				+ createtime + ", orderstate=" + orderstate + ", paytype=" + paytype + ", userid=" + userid
				+ ", username=" + username + "]";
	}
	
	
}
