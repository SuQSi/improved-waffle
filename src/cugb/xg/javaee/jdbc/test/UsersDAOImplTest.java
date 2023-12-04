package cugb.xg.javaee.jdbc.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cugb.xg.javaee.jdbc.dao.IUsersDAO;
import cugb.xg.javaee.jdbc.utils.DAOFactory;

public class UsersDAOImplTest {
	
	IUsersDAO userdao = (IUsersDAO) DAOFactory.newInstance("IUsersDAO");

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertUsers() {
		Date utilDate = new Date();// uilt.Date
		Timestamp tsDate = new Timestamp(utilDate.getTime());

	}

	@Test
	public void testDeleteUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryUsers() {
		System.out.println(userdao.queryUsers());
	}
	
	@Test
	public void testQueryUsersBy() {
		String sql = "select userid Userid,username Username ,password Password, createdate Createdate from users where username=? and password=? ";
		Object[] params = {"lisi","1234"};
		System.out.println(userdao.queryUsersBy(sql, params));
	}

	@Test
	public void testUpdateUsers() {
		fail("Not yet implemented");
	}

}
