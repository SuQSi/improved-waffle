package cugb.xg.javaee.jdbc.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cugb.xg.javaee.jdbc.utils.JDBCUtils;
import cugb.xg.javaee.jdbc.utils.MyDataSource;

public class MyConnectionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws SQLException {
		MyDataSource ds = new MyDataSource();
		for (int i = 0; i < 10; i++) {
//			Connection conn = JDBCUtils.getConnection();
			Connection conn = ds.getConneciton();
			System.out.println(conn.hashCode());
			conn.close();
		}
	}

}
