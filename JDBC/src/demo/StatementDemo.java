package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class StatementDemo {

	@Test
	public void selTest() throws Exception {
		Connection conn = GConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select  username,belongorg from user_info where userid='901003'";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String username = rs.getString("username");
			String belongOrg = rs.getString("belongorg");
			String orgname = null;
			if (belongOrg == null | belongOrg == "")
				belongOrg = null;
			String sql1 = "select  orgname from org_info where orgid="
					+ belongOrg;
			ResultSet rs2 = stmt.executeQuery(sql1);
			while (rs2.next()) {
				orgname = rs2.getString("orgname");
			}
			System.out.println("用户名：" + username + "，隶属机构：" + orgname);
			rs2.close();
		}
		rs.close();
		stmt.close();
		conn.close();
	}
	
	 @Test
	  public  void DMLtest() throws Exception{
		 Connection conn = GConnection.getConnection();
		 Statement stmt = conn.createStatement();
		 String sql = "create table student(id number(20),name varchar2(20),gender varchar2(20))";
		 String sql2 = "drop table student";
		 stmt.execute(sql2);
		 stmt.execute(sql);
		 stmt.close();
		 conn.close();
	 }
}
