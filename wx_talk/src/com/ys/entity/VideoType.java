package com.ys.entity;

public class VideoType {

	private int id;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Vedio_type [id=" + id + ", type=" + type + "]";
	}
	
	
}
