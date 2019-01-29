package com.ys.entity;

public class VideoComment {

	private String image;  //头像
	private String name;    //昵称
	private String date;    //日期
	private String comment;    //评论内容
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "VideoComment [image=" + image + ", name=" + name + ", date=" + date + ", comment=" + comment + "]";
	}
	
	
	
}
