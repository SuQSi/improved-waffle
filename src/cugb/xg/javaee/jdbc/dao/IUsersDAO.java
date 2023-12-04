package cugb.xg.javaee.jdbc.dao;

import java.util.ArrayList;

import cugb.xg.javaee.jdbc.bean.Users;



public interface IUsersDAO {

	/*
	 * insertUsers
	 * username
	 * password
	 */
//	int insertUsers(String username, String password);
	int insertUsers(Users users);

	/*
	 * deleteUsers
	 */
//	int deleteUsers(String username, String password);
	int deleteUsers(Users users);

	/***
	 * 
	 * @param users
	 * @return
	 */
	ArrayList queryUsersBy(String sql,Object[] params);
	/*
	 * queryUsers
	 */
//	void queryUsers(String username, String password);
	ArrayList queryUsers();

	/*
	 * updateUsers
	 */
//	int updateUsers(String username, String password);
	int updateUsers(Users users);

}