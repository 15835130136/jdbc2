package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class PreparedDemo {
	/**
	 * 这里有一个疑问，当select检索的字段使用set赋值时，rs.get不到，提示列名无效。
	 * @throws Exception
	 */
	@Test 
	public void test1() throws Exception{
		String sql = "select   ?,?  belongorg from user_info where userid=? ";
		Connection conn = GConnection.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "username");
		pstmt.setString(2,"belongorg");
		pstmt.setString(3, "903001");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			String username = rs.getString("username");
			String belongorg = rs.getString("belongorg");
			if(username==null|username=="")username="";
			if(belongorg==null|belongorg=="")belongorg="";
			System.out.println("用户名："+username+"，+所属机构："+belongorg);
		}
	rs.close();
	pstmt.close();
	conn.close();
	}

}
