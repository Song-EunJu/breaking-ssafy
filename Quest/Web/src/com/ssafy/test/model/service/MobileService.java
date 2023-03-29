package com.ssafy.test.model.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ssafy.test.dto.Mobile;
import com.ssafy.test.model.dao.MobileDao;

public class MobileService {
	private MobileDao mobileDao = new MobileDao();
	public void registerMobile(HttpServletRequest request) throws SQLException {
		mobileDao.registerMobile(request);
	}
	public List<Mobile> getMobileList() throws SQLException {
		return mobileDao.getMobileList();
	}
	public Mobile getMobile(String mobileCode) throws SQLException {
		return mobileDao.getMobile(mobileCode);
	}
	public void deleteMobile(String mobileCode) throws SQLException {
		mobileDao.deleteMobile(mobileCode);
		
	}

}
