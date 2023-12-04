package cugb.xg.javaee.jdbc.dao;

import java.util.ArrayList;

import cugb.xg.javaee.jdbc.bean.Dish;
import cugb.xg.javaee.jdbc.bean.Users;

public class DishDAOImpl extends baseDAO implements IDishDAO {

	@Override
	public ArrayList queryDishes() {
		String sql = "select dishid Dishid,name Dishname,price Price,description Descp,img Img from dish";
		return queryObjs(sql, null, Dish.class);
	}

	@Override
	public ArrayList<Dish> queryDishBy(String sql, Object[] params) {
		//String sql = "select dishid Dishid,name Dishname,price Price,description Descp,img Img from dish limit ?,?";
		return queryObjs(sql,params, Dish.class);
	}

	@Override
	public int queryTotalDish() {
		String sql = "select count(*) from dish";
		return queryTotalRecords(sql);
	}

}
