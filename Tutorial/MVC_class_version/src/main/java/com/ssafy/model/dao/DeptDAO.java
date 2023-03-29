package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.Dept;
import com.ssafy.util.DBUtil;

public class DeptDAO {
	
	public boolean insertDept0(Dept dept) throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		String sql = "insert into dept values( "+dept.getDeptno()
								+",'"+dept.getDname()+"', '"+dept.getLoc()+"')";
		int rowCnt = 0 ;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rowCnt = stmt.executeUpdate(sql);
		}finally {
			DBUtil.close(stmt,conn);
		}
		return rowCnt>0;
	}
	public boolean insertDept(Dept dept) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into dept values(?,?,?)";
		int rowCnt = 0 ;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, dept.getDeptno());
			stmt.setString(2, dept.getDname());
			stmt.setString(3, dept.getLoc());
			rowCnt = stmt.executeUpdate();
		}finally {
			DBUtil.close(stmt,conn);
		}
		return rowCnt>0;
	}
	public boolean deleteDept(int deptNo) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "delete from dept where deptno = ?";
		int rowCnt = 0 ;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, deptNo);
			rowCnt = stmt.executeUpdate();
		}finally {
			DBUtil.close(stmt,conn);
		}
		return rowCnt>0;
	}
	public void updateDept(Dept dept) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "update dept set dname=?,loc=? where deptno=?";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dept.getDname());
			stmt.setString(2, dept.getLoc());
			stmt.setInt(3, dept.getDeptno());
			stmt.executeUpdate();
		}finally {
			DBUtil.close(stmt,conn);
		}
	}
	
	public Dept	getDept(int deptNo) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select deptno,dname,loc from dept where deptno=?";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, deptNo);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new Dept(rs.getInt(1), rs.getString("dname"), rs.getString(3));
			}
		}finally {
			DBUtil.close(stmt,conn);
		}
		return null;
	}
	public List<Dept>	getDepts() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select deptno,dname,loc from dept";
		ArrayList<Dept> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString("dname"), rs.getString(3)));
			}
		}finally {
			DBUtil.close(stmt,conn);
		}
		return list;
	}
	
	// 부서이름을 받아 포함검색하여 부서정보들을 리턴하시오.
	
	public List<Dept> getDeptsByName(String deptName) throws SQLException {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
//		String sql = "select deptno,dname,loc from dept where dname like concat('%',?,'%')";
		String sql = "select deptno,dname,loc from dept where dname like ?";
		ArrayList<Dept> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

//			stmt.setString(1, deptName);
			stmt.setString(1, "%"+deptName+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString("dname"), rs.getString(3)));
			}
		}finally {
			DBUtil.close(stmt,conn);
		}
		return list;
		
		
	}
	
	
}




















