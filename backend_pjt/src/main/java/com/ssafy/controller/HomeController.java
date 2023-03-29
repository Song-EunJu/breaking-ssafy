package com.ssafy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.PageInfo;

public class HomeController implements Controller{
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return index(request, response);
	}
	
	protected PageInfo index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo("/index.jsp");
	}

}
