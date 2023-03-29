package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.test.dto.User;
import com.ssafy.test.util.DBUtil;

public class UserDao {

	public User login(String id, String pw) throws SQLException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "select id, pw from user where id=? and pw=?";
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new User(rs.getString(1), rs.getString(2));
			}
		} 
		finally {
			DBUtil.close(conn, stmt);
		}
		return null;		
	}
	
}
