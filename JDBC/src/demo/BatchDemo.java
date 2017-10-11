package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import Bean.User;

public class BatchDemo {
/**
 * 遍历存放userbean的list，从中取出user，从每个user中取出信息更新到对应信息中。
 * 遍历集合时不能使用加强for循环，因为需要得到遍历数，根据遍历数大小得出批处理上限。
 * @param userList
 * @throws Exception 
 */
	private void save(List <User>userList) throws Exception{
		String userid =null;
		String username = null;
		String belongorg = null;
		String sql = "update student set username=?,belongorg=? where userid=?";
		Connection conn = GConnection.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i = 0; i<userList.size();i++){
			User user = userList.get(i);
			userid = user.getUserid();
			username = user.getUsername();
			belongorg = user.getBelongorg();
			pstmt.setString(1, username);
			pstmt.setString(2,belongorg);
			pstmt.setString(3,userid);
			pstmt.addBatch();
			if(i%10==0){
				pstmt.executeBatch();
				pstmt.clearBatch();
			}
			pstmt.executeBatch();
			pstmt.clearBatch();
		}
		
	}
}
