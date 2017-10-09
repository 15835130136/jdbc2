package demo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class GConnection {
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	public static String getDriverClass() {
		return driverClass;
	}
	public static void setDriverClass(String driverClass) {
		GConnection.driverClass = driverClass;
	}
	
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		GConnection.url = url;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		GConnection.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		GConnection.password = password;
	}
	
	/**
	 * 
	 * @param url
	 * @param userName
	 * @param password
	 * @throws Exception
	 */
	public static Connection getConnectrion() throws Exception{
		//读取配置文件中配置的数据库数据
		Properties pro = new Properties();
		FileInputStream  oFile = new FileInputStream("bin/jdbc.properties");
		pro.load(oFile);
		oFile.close();
		String classDriver = null ;
		String url = null;
		String userName= null;
		String password = null;
/*		classDriver = pro.getProperty("classDriver");
		url = pro.getProperty("url");
		userName = pro.getProperty("userName");
		password = pro.getProperty("password");*/
		
		
		//注册驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    //Connection conn = DriverManager.getConnection(url, userName, password);
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.234.1:1521:orcl", "cjcbhb", "cjcbhb");
	    return conn;
		
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		GConnection.getConnectrion();
	}
}
