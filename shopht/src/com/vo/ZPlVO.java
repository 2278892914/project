package com.vo;

import java.util.List;

public class ZPlVO {

	private List list;
	private String id;
	private String pcname;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPcname() {
		return pcname;
	}
	public void setPcname(String pcname) {
		this.pcname = pcname;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "ZPlVO [list=" + list + ", id=" + id + ", pcname=" + pcname + "]";
	}
	
	
}
