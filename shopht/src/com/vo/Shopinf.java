package com.vo;

public class Shopinf {

	private int id;
	private String name;
	private String descript;
	private int state;
	private int num;
	private String spinfo;
	private double price;
	private int kind_pl;
	private int kind_zpl;
	private String pname;
	private String pcname;
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
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSpinfo() {
		return spinfo;
	}
	public void setSpinfo(String spinfo) {
		this.spinfo = spinfo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getKind_pl() {
		return kind_pl;
	}
	public void setKind_pl(int kind_pl) {
		this.kind_pl = kind_pl;
	}
	public int getKind_zpl() {
		return kind_zpl;
	}
	public void setKind_zpl(int kind_zpl) {
		this.kind_zpl = kind_zpl;
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
		return "Shopinf [id=" + id + ", name=" + name + ", descript=" + descript + ", state=" + state + ", num=" + num
				+ ", spinfo=" + spinfo + ", price=" + price + ", kind_pl=" + kind_pl + ", kind_zpl=" + kind_zpl
				+ ", pname=" + pname + ", pcname=" + pcname + "]";
	}
	
	
}
