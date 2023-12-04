package cugb.xg.javaee.jdbc.biz;

import java.util.ArrayList;

import cugb.xg.javaee.jdbc.bean.Dish;
import cugb.xg.javaee.jdbc.dao.IDishDAO;
import cugb.xg.javaee.jdbc.utils.DAOFactory;
import cugb.xg.javaee.jdbc.utils.PageModel;

public class DishServiceImpl implements IDishService {

	@Override
	public PageModel<Dish> queryDish4PageList(int PageNo, int PageSize) {
		Object[] params = {(PageNo-1)*PageSize,PageSize};
		String sql = "select dishid Dishid,name Dishname,price Price,description Descp,img Img from dish limit ?,?";
		IDishDAO dishdao = (IDishDAO) DAOFactory.newInstance("IDishDAO");
		ArrayList<Dish> currlist = dishdao.queryDishBy(sql, params);
		int totalrecords = dishdao.queryTotalDish();
		//public PageModel(int pageSize,int pageNo,int totalrecords,ArrayList list)
		return new PageModel(PageSize,PageNo,totalrecords,currlist);
	}

//	@Override
//	public ArrayList<Dish> queryDish4PageList(int PageNo, int PageSize) {
//		Object[] params = {(PageNo-1)*PageSize,PageSize};
//		String sql = "select dishid Dishid,name Dishname,price Price,description Descp,img Img from dish limit ?,?";
//		IDishDAO dishdao = (IDishDAO) DAOFactory.newInstance("IDishDAO");
//		return dishdao.queryDishBy(sql, params);
//	}

}
