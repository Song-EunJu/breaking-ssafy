package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.ssafy.model.dto.User;
import com.ssafy.util.DBUtil;


public class UserDao {

	public User login(String userId, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "select name, userId, password, email, city, region from user where userId=? and password=?";
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new User(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} 
		finally {
			DBUtil.close(conn, stmt);
		}
		return null;		
	}
	
	public void register(HttpServletRequest request) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into user values(?,?,?,?,?,?)";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, request.getParameter("name"));
			stmt.setString(2, request.getParameter("userId"));
			stmt.setString(3, request.getParameter("password"));
			stmt.setString(4, request.getParameter("email"));
			stmt.setString(5, request.getParameter("city"));
			stmt.setString(6, request.getParameter("region"));
			stmt.executeUpdate();
		} 
		finally {
			DBUtil.close(conn, stmt);
		}
	}

	public User getMyInfo(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "select name, userId, password, email, city, region from user where userId=?";
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new User(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} 
		finally {
			DBUtil.close(conn, stmt);
		}
		return null;		
	}

	public void modifyMyInfo(HttpServletRequest request) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "update user set name=?, city=?, region=?, email=? where userId=?";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, request.getParameter("name"));
			stmt.setString(2, request.getParameter("city"));
			stmt.setString(3, request.getParameter("region"));
			stmt.setString(4, request.getParameter("email"));
			stmt.setString(5, request.getParameter("userId"));
			stmt.executeUpdate();
		}finally {
			DBUtil.close(stmt,conn);
		}		
	}

	public void resign(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "delete from user where userId=?";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			stmt.executeUpdate();
		} 
		finally {
			DBUtil.close(conn, stmt);
		}
	}

	public String findPassword(String name, String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "select password from user where name=? and userId=?";
		ResultSet rs = null;
		String result = "";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, userId);
			rs = stmt.executeQuery();
			if(rs.next())
				result = rs.getString(1);
		} 
		finally {
			DBUtil.close(conn, stmt);
		}
		return result;
	}
}

