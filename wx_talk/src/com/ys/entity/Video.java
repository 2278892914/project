package com.ys.entity;

public class Video {

	private int id;    //视频id
	private String video_url;     //视频链接
	private String video_name;      //视频名称
	private String video_introduce;     //视频介绍
	private String image;     //视频图片
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}
	public String getVideo_introduce() {
		return video_introduce;
	}
	public void setVideo_introduce(String video_introduce) {
		this.video_introduce = video_introduce;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Video [id=" + id + ", video_url=" + video_url + ", video_name=" + video_name + ", video_introduce="
				+ video_introduce + ", image=" + image + "]";
	}
	
	
	
	
} 
