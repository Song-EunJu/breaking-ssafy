package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.util.DBUtil;

public class UserDAO {

	public String login(String userId, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select name from userinfo where userid=? and password=?";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			stmt.setString(2,password);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}finally {
			DBUtil.close(stmt,conn);
		}
		return null;
	}
}
