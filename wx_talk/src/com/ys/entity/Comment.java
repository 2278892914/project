package com.ys.entity;

public class Comment {

	private int id;      //id
	private String head_image;  //头像
	private String image;   //问题图片
	private String date;    //日期
	private String comment;    //评论内容
	private String title;      //标题
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHead_image() {
		return head_image;
	}
	public void setHead_image(String head_image) {
		this.head_image = head_image;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", head_image=" + head_image + ", image=" + image + ", date=" + date + ", comment="
				+ comment + ", title=" + title + "]";
	}
	
	
}
