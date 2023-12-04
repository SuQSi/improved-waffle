package cugb.xg.javaee.jdbc.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import cugb.xg.javaee.jdbc.utils.JDBCUtils;

public class baseDAO {

	public int queryTotalRecords(String sql){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList objlist = new ArrayList();
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);			
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.free(ps, rs,conn);
		}
		return 0;
	}
	
	public ArrayList queryObjs(String sql, Object[] params,Class clazz) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList objlist = new ArrayList();
		try {
			conn = JDBCUtils.getConnection();
			// String sql = "select * from users where username=? and
			// password=?";
			ps = conn.prepareStatement(sql);
			if(params != null){
				ParameterMetaData pmd = ps.getParameterMetaData();
				for (int i = 0; i < pmd.getParameterCount(); i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				// 问1，封装成什么类型的对象？
				// 问2，如何封装？
				// Object obj = clazz.newInstance();
				objlist.add(MappingObj(rs, clazz));
				// System.out.println(rs.getString(1) + "," +
				// rs.getString("username") + "," + rs.getString("password"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.free(ps, rs,conn);
		}
		return objlist;
	}

	/**
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Object MappingObj(ResultSet rs, Class clazz) throws SQLException {
		// Users users = new Users();
		// users.setUserid(rs.getInt(1));
		// users.setUsername(rs.getString(2));
		// users.setPassword(rs.getString("password"));
		// 实例化对象
		Object obj;
		try {
			obj = clazz.newInstance();
			// 获取映射对象的方法集合
			Method[] methods = clazz.getMethods();
			// 获取结果集中元数据信息
			ResultSetMetaData meta = rs.getMetaData();
			// 按字段数目循环结果集中记录，进行对象映射
			int j = meta.getColumnCount();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				// 构造当前列的set方法名称
				String colname = meta.getColumnLabel(i);
				String methodname = "set" + colname;
				// 循环查找同名方法，并通过反射调用该方法，设置属性值
				for (Method method : methods) {
					if (method.getName().equals(methodname)) {
						Object rsobj = rs.getObject(i);
						method.invoke(obj, rsobj);
						break;
					}
				}
			}
			return obj;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/***
	 * 增删改的操作共用的方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int modifyObj(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rtn = 0;
		try {
			conn = JDBCUtils.getConnection();
			// String sql = "insert into users(username,password,createdate)
			// values(?,?,?)";
			ps = conn.prepareStatement(sql);
			// 采用参数的元数据去初始化sql中的参数
			ParameterMetaData pmd = ps.getParameterMetaData();
			for (int i = 0; i < pmd.getParameterCount(); i++) {
				ps.setObject(i + 1, params[i]);
			}
			rtn = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.free(ps, null,conn);
		}
		return rtn;
	}
}
