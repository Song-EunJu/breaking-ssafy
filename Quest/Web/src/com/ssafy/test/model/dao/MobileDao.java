package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ssafy.test.dto.Mobile;
import com.ssafy.test.util.DBUtil;

public class MobileDao {
	
	public void registerMobile(HttpServletRequest request) throws SQLException {
		String mobileCode = request.getParameter("mobileCode");
		String model = request.getParameter("model");
		int price = Integer.parseInt(request.getParameter("price"));
		String company = request.getParameter("company");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into mobile values (?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, mobileCode);
			stmt.setString(2, model);
			stmt.setInt(3, price);
			stmt.setString(4, company);
			stmt.executeUpdate();
		} 
		finally {
			DBUtil.close(conn, stmt);
		}
	}

	public List<Mobile> getMobileList() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "select mobileCode, model, price, company from mobile";
		ResultSet rs = null;
		List<Mobile> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(new Mobile(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}
		} 
		finally {
			DBUtil.close(conn, stmt);
		}
		return list;
	}

	public Mobile getMobile(String mobileCode) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "select mobileCode, model, price, company from mobile where mobileCode=?";
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, mobileCode);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new Mobile(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			}
		} 
		finally {
			DBUtil.close(conn, stmt);
		}
		return null;		
	}

	public void deleteMobile(String mobileCode) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "delete from mobile where mobileCode=?";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, mobileCode);
			stmt.executeUpdate();
		} 
		finally {
			DBUtil.close(conn, stmt);
		}
	}

}
