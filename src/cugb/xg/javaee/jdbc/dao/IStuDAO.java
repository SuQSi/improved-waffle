package cugb.xg.javaee.jdbc.dao;

import java.util.ArrayList;

import cugb.xg.javaee.jdbc.bean.Student;

public interface IStuDAO {

	/***
	 * 
	 * @return
	 */
	ArrayList findStudents();

	/***
	 * 
	 * @param stu
	 * @return 0-Error 1-All Right
	 */
	int insertStu(Student stu);

}