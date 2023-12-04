package cugb.xg.javaee.jdbc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cugb.xg.javaee.jdbc.biz.IDishService;
import cugb.xg.javaee.jdbc.utils.DAOFactory;

public class DishServiceImplTest {
	
	IDishService dishserv = (IDishService) DAOFactory.newInstance("IDishService");

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQueryDish4PageList() {
		System.out.println(dishserv.queryDish4PageList(1, 10));
	}

}
