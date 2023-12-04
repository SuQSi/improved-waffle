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
				// ��1����װ��ʲô���͵Ķ���
				// ��2����η�װ��
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
		// ʵ��������
		Object obj;
		try {
			obj = clazz.newInstance();
			// ��ȡӳ�����ķ�������
			Method[] methods = clazz.getMethods();
			// ��ȡ�������Ԫ������Ϣ
			ResultSetMetaData meta = rs.getMetaData();
			// ���ֶ���Ŀѭ��������м�¼�����ж���ӳ��
			int j = meta.getColumnCount();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				// ���쵱ǰ�е�set��������
				String colname = meta.getColumnLabel(i);
				String methodname = "set" + colname;
				// ѭ������ͬ����������ͨ��������ø÷�������������ֵ
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
	 * ��ɾ�ĵĲ������õķ���
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
			// ���ò�����Ԫ����ȥ��ʼ��sql�еĲ���
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
