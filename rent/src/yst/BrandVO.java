package yst;
/*
 * 私有属性，对外提供get,set方法，供外界发访问
 */
public class BrandVO {

	private int id ;
	private String name;
	
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
	
}
