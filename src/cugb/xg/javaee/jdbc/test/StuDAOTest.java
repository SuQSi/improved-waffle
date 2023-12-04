package cugb.xg.javaee.jdbc.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cugb.xg.javaee.jdbc.bean.Student;
import cugb.xg.javaee.jdbc.dao.IStuDAO;
import cugb.xg.javaee.jdbc.dao.StuDAO;

public class StuDAOTest {

	IStuDAO studao = new StuDAO();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindStudents() {
		System.out.println(studao.findStudents());
	}
	
	@Test
	public void testInsertStu(){
		Student stu = new Student();
		stu.setStuid(1004206209);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		try {
			stu.setSbirth(new Timestamp(sdf.parse("2000-01-01").getTime()));
			studao.insertStu(stu);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
