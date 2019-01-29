package com.ys.entity;

public class User {

	private String openid;
	private String nickName;
	private int look_num;
	private int send_num;
	private int comment_num;
	private int gender;
	private String country;
	private String city;
	private String avatarUrl;
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getLook_num() {
		return look_num;
	}
	public void setLook_num(int look_num) {
		this.look_num = look_num;
	}
	public int getSend_num() {
		return send_num;
	}
	public void setSend_num(int send_num) {
		this.send_num = send_num;
	}
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	@Override
	public String toString() {
		return "User [openid=" + openid + ", nickName=" + nickName + ", look_num=" + look_num + ", send_num=" + send_num
				+ ", comment_num=" + comment_num + ", gender=" + gender + ", country=" + country + ", city=" + city
				+ ", avatarUrl=" + avatarUrl + "]";
	}
	
	
	
	
	
	
}
