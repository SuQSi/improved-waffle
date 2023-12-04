package cugb.xg.javaee.jdbc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cugb.xg.javaee.jdbc.dao.IDishDAO;
import cugb.xg.javaee.jdbc.utils.DAOFactory;

public class DishDAOImplTest {

	IDishDAO dishdao = null;
	
	@Before
	public void setUp() throws Exception {
		dishdao = (IDishDAO) DAOFactory.newInstance("IDishDAO");
		if(dishdao == null){
			fail("dishdao is null!");
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	
	public void testQueryDishes() {
		System.out.println(dishdao.queryDishes());
	}
	
	@Test
	public void testQueryDishBy() {
		Object[] params = {1,6};
		String sql = "select dishid Dishid,name Dishname,price Price,description Descp,img Img from dish limit ?,?";
		System.out.println(dishdao.queryDishBy(sql, params));
	}
	
	
	public void testQueryTotalDish() {
		//String sql = "select dishid Dishid,name Dishname,price Price,description Descp,img Img from dish limit ?,?";
		System.out.println(dishdao.queryTotalDish());
	}
	
	

}
