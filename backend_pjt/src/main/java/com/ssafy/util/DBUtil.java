package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/enjoytrip?serverTimezone=UTC";
	private static final String USER = "ssafy";
	private static final String PASSWORD = "ssafy";
	
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public static void close(AutoCloseable... res) {
		
		for (AutoCloseable r : res) {
			if (r != null)
				try {
					r.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
}
