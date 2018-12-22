package com.vo;

import java.sql.Timestamp;

public class OrderInfo {

	
	private int id;   //订单id
	private String ordernum;  
	private double totalprice;
	private Timestamp  createtime;
	private int goodstate;
	private int paytype;
	private String username;
	private String address;
	private String name;
	private String descript;
	private int sp_num;
	private double price;
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
	
	
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public int getGoodstate() {
		return goodstate;
	}
	public void setGoodstate(int goodstate) {
		this.goodstate = goodstate;
	}
	public int getPaytype() {
		return paytype;
	}
	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public int getSp_num() {
		return sp_num;
	}
	public void setSp_num(int sp_num) {
		this.sp_num = sp_num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderInfo [id=" + id + ", ordernum=" + ordernum + ", totalprice=" + totalprice + ", createtime="
				+ createtime + ", goodstate=" + goodstate + ", paytype=" + paytype + ", username=" + username
				+ ", address=" + address + ", name=" + name + ", descript=" + descript + ", sp_num=" + sp_num
				+ ", price=" + price + "]";
	}
	
	
	
}
