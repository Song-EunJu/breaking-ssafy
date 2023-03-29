package com.ssafy.model.service;

import com.ssafy.model.dao.UserDAO;

public class UserService {

	private UserDAO userDao = new UserDAO();
	
	public String login(String userId,String password) throws Exception {
		return userDao.login(userId, password);
	}
}
