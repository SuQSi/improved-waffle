package cugb.xg.javaee.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import cugb.xg.javaee.jdbc.utils.JDBCUtils;


public class JDBCUtils {
//	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	private static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=labjdbc";
//	private static String user = "sa";
//	private static String pwd = "sa";
	private static DataSource ds = null;
	private static Properties prop = null;
	private JDBCUtils(){
		
	}
	static{
		prop = new Properties();
		try {
			InputStream in = JDBCUtils.class.getClassLoader().
					getResourceAsStream("dbcpconfig.properties");
			Properties prop = new Properties();
			prop.load(in);
			ds = BasicDataSourceFactory.createDataSource(prop);
//
//			prop.load(JDBCUtils.class.getClassLoader().
//					getResourceAsStream("dbconfig.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
//			Class.forName(prop.getProperty("driver"));
//			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),prop.getProperty("pwd"));
			conn = ds.getConnection();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void free(PreparedStatement ps, ResultSet rs, Connection conn){
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(rs != null){
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						if(conn != null){
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
	
	
	
}
