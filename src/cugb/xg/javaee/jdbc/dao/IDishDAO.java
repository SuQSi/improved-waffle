package cugb.xg.javaee.jdbc.dao;

import java.util.ArrayList;

import cugb.xg.javaee.jdbc.bean.Dish;

public interface IDishDAO {

	public ArrayList<Dish> queryDishes();//·ºÐÍ
	
	public ArrayList<Dish> queryDishBy(String sql,Object[] params);
	
	public int queryTotalDish();
}
