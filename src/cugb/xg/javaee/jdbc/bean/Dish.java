package cugb.xg.javaee.jdbc.bean;

import java.math.BigDecimal;

import jdk.nashorn.internal.runtime.arrays.NumericElements;

public class Dish {
	private int dishid;
	private String dishname;
	private  BigDecimal price;
	private String descp;
	private String img;
	public int getDishid() {
		return dishid;
	}
	public void setDishid(int dishid) {
		this.dishid = dishid;
	}
	public String getDishname() {
		return dishname;
	}
	public void setDishname(String dishname) {
		this.dishname = dishname;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Dish [dishid=" + dishid + ", dishname=" + dishname + ", price=" + price + ", descp=" + descp + ", img="
				+ img + "]";
	}
	
	

}
