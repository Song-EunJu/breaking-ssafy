package com.ssafy.test.model.service;

import java.sql.SQLException;

import com.ssafy.test.dto.User;
import com.ssafy.test.model.dao.UserDao;

public class UserService {
	private UserDao userDao = new UserDao();

	public User login(String id, String pw) throws SQLException {
		return userDao.login(id, pw);
	}
	
	
}
