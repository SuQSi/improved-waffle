package cugb.xg.javaee.jdbc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cugb.xg.javaee.jdbc.utils.JDBCUtils;

public class JDBCUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetConnection() {
//		fail("Not yet implemented");
		assertNotNull(JDBCUtils.getConnection());
	}

}
