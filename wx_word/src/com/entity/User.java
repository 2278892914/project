package com.entity;

public class User {

	private int id;
	private String username;
	private String email;
	private String phone;
	private Integer plane;
	private int p_word;
	private int m_word;
	private int h_word;
	private int u_word;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getPlane() {
		return plane;
	}
	public void setPlane(Integer plane) {
		this.plane = plane;
	}
	public int getP_word() {
		return p_word;
	}
	public void setP_word(int p_word) {
		this.p_word = p_word;
	}
	public int getM_word() {
		return m_word;
	}
	public void setM_word(int m_word) {
		this.m_word = m_word;
	}
	public int getH_word() {
		return h_word;
	}
	public void setH_word(int h_word) {
		this.h_word = h_word;
	}
	public int getU_word() {
		return u_word;
	}
	public void setU_word(int u_word) {
		this.u_word = u_word;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone + ", plane="
				+ plane + ", p_word=" + p_word + ", m_word=" + m_word + ", h_word=" + h_word + ", u_word=" + u_word
				+ "]";
	}
	
	
	
}
