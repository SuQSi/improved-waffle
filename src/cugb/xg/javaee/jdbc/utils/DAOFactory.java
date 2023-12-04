package cugb.xg.javaee.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DAOFactory {
	private DAOFactory(){
		
	}
	private static Properties prop = new Properties();
	static{
		try {
			InputStream in = JDBCUtils.class.getClassLoader().
					getResourceAsStream("dao.properties");
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Object newInstance(String interfaceName){
		String ifName = prop.getProperty(interfaceName);
		try {
			return Class.forName(ifName).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		return null;
	}
}
