package cugb.xg.javaee.jdbc.biz;

import java.util.ArrayList;

import cugb.xg.javaee.jdbc.bean.Dish;
import cugb.xg.javaee.jdbc.utils.PageModel;

public interface IDishService {

//	public ArrayList<Dish> queryDish4PageList(int PageNo,int PageSize);
	public PageModel<Dish> queryDish4PageList(int PageNo,int PageSize);
}
