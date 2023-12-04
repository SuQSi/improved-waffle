package cugb.xg.javaee.jdbc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cugb.xg.javaee.jdbc.biz.IUsersService;
import cugb.xg.javaee.jdbc.utils.DAOFactory;

public class UserServiceImplTest {

	IUsersService userserv = (IUsersService) DAOFactory.newInstance("IUsersService");
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidUser() {
		assertTrue(userserv.validateUser("lisi", "1234"));
	}

}
