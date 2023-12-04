package cugb.xg.javaee.jdbc.dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cugb.xg.javaee.jdbc.bean.Users;
import cugb.xg.javaee.jdbc.utils.JDBCUtils;

public class UsersDAOImpl extends baseDAO implements IUsersDAO {
	/*
	 * (non-Javadoc)
	 * 
	 * @see javaee.utils.IUsersDAO#insertUsers(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	// public int insertUsers(String username, String password) {
	public int insertUsers(Users users) {
		String sql = "insert into users(username,password,createdate) values(?,?,?)";
		Object[] params = { users.getUsername(), users.getPassword(), users.getCreatedate() };
		return modifyObj(sql, params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javaee.utils.IUsersDAO#deleteUsers(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	// public int deleteUsers(String username, String password) {
	public int deleteUsers(Users users) {
		String sql = "delete from users where username=? and password=?";
		Object[] params = { users.getUsername(), users.getPassword() };
		return modifyObj(sql, params);
	}

	//ORMapping 对象关系映射
	/*
	 * (non-Javadoc)
	 * 
	 * @see javaee.utils.IUsersDAO#queryUsers(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	// public void queryUsers(String username, String password) {
	public ArrayList queryUsers() {
		String sql = "select userid Userid,username Username ,password Password, createdate Createdate from users ";
		return queryObjs(sql,null, Users.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javaee.utils.IUsersDAO#updateUsers(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	// public int updateUsers(String username, String password) {
	public int updateUsers(Users users) {
		String sql = "update users set password=? where username=?";
		Object[] params = { users.getPassword(), users.getUsername() };
		return modifyObj(sql, params);

	}

	@Override
	public ArrayList queryUsersBy(String sql, Object[] params) {
		return queryObjs(sql,params,Users.class);
	}



	
}
