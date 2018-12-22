package com.vo;

public class PlVO {

	private int id;
	private String pname;
	private String pcname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcname() {
		return pcname;
	}
	public void setPcname(String pcname) {
		this.pcname = pcname;
	}
	@Override
	public String toString() {
		return "PlVO [id=" + id + ", pname=" + pname + ", pcname=" + pcname + "]";
	}
	
	
}
