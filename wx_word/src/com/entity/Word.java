package com.entity;

public class Word {

	private int id;
	private String name;
	private String types;
	private String meanning;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String getMeanning() {
		return meanning;
	}
	public void setMeanning(String meanning) {
		this.meanning = meanning;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Word [id=" + id + ", name=" + name + ", types=" + types + ", meanning=" + meanning + ", state=" + state
				+ "]";
	}
	
}
