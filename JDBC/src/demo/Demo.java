package demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Demo {
	private static String url;
	private static String username;
	private static String password;
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		Demo.url = url;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		Demo.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Demo.password = password;
	}
	
	/**
	 * 
	 * @param url
	 * @param userName
	 * @param password
	 * @throws Exception
	 */
	public static void getConnectrion(String url,String userName,String password) throws Exception{
		Class.forName("");
		Connection conn = DriverManager.getConnection(url, userName, password);
		
	}
	
}
