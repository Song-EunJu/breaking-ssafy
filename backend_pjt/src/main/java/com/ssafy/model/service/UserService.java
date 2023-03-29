package com.ssafy.model.service;


import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.ssafy.model.dao.UserDao;
import com.ssafy.model.dto.User;

public class UserService {
	private UserDao userDao = new UserDao();
	public User login(String id, String pw) throws SQLException {
		return userDao.login(id, pw);
	}
	
	public void register(HttpServletRequest request) throws SQLException {
		userDao.register(request);
	}

	public User getMyInfo(String userId) throws SQLException {
		return userDao.getMyInfo(userId);
	}

	public void modifyMyInfo(HttpServletRequest request) throws SQLException {
		userDao.modifyMyInfo(request);
	}

	public void resign(String userId) throws SQLException {
		userDao.resign(userId);
	}

	public String findPassword(String name, String userId) throws SQLException {
		return userDao.findPassword(name, userId);
	}

}
