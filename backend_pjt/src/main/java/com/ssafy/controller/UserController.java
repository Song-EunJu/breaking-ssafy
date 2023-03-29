package com.ssafy.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.dto.User;
import com.ssafy.model.dto.UserInfo;
import com.ssafy.model.service.UserService;

public class UserController implements Controller{
	private UserService userService = new UserService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		System.out.println(url);
		Object info = null;
		if(url.equals("/user/loginForm.do"))
			info = getLoginForm(request, response);
		else if(url.equals("/user/login.do")) 
			info = login(request, response);
		else if(url.equals("/user/registerForm.do"))
			info = getRegisterForm(request, response);
		else if(url.equals("/user/register.do")) 
			info = register(request, response);
		else if(url.equals("/user/logout.do"))
			info = logout(request, response);
		else if(url.equals("/user/mypage.do"))
			info = getMypage(request);
		else if(url.equals("/user/modifyForm.do"))
			info = getModifyForm(request);
		else if(url.equals("/user/modify.do"))
			info = modifyMyInfo(request);
		else if(url.equals("/user/resign.do"))
			info = resign(request);
		else if(url.equals("/user/passwordForm.do"))
			info = getPasswordForm();
		else if(url.equals("/user/password.do"))
			info = findPassword(request);
		return info;
	}
	
	private PageInfo getPasswordForm() {
		return new PageInfo("/password.jsp");
	}

	private PageInfo findPassword(HttpServletRequest request) throws SQLException {
		String name = request.getParameter("name");
		String userId = request.getParameter("userId");
		String result = userService.findPassword(name, userId);
		request.setAttribute("password", result);
		return new PageInfo("/passwordAlert.jsp");
	}

	private PageInfo resign(HttpServletRequest request) throws SQLException {
		String userId = request.getParameter("userId");
		userService.resign(userId);
		return new PageInfo("/user/logout.do");
		
	}

	private PageInfo modifyMyInfo(HttpServletRequest request) throws SQLException {
		System.out.println(request.getParameter("name"));
		userService.modifyMyInfo(request);
		return new PageInfo("/user/mypage.do");
	}

	private PageInfo getModifyForm(HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		String userId = userInfo.getUserId();
		User user = userService.getMyInfo(userId);
		request.setAttribute("user", user);
		return new PageInfo("/modify.jsp");
	}

	private PageInfo getMypage(HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		String userId = userInfo.getUserId();
		User user = userService.getMyInfo(userId);
		request.setAttribute("user", user);
		return new PageInfo("/mypage.jsp");
	}

	private PageInfo logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			return new PageInfo(false, "/index.do");
		} catch(Exception e) {
			return new PageInfo("/error/error.jsp");
		}
	}

	private PageInfo register(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		userService.register(request);
		return new PageInfo(false, "/index.do");
	}

	private PageInfo getRegisterForm(HttpServletRequest request, HttpServletResponse response) {
		return new PageInfo("/register.jsp");
	}

	private PageInfo login(HttpServletRequest request, HttpServletResponse response) {
		try {
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			User user = userService.login(userId, password);
			if(user != null) {
				HttpSession session = request.getSession();
				UserInfo userInfo = new UserInfo(userId, password, user.getName());
				session.setAttribute("userInfo", userInfo);
//				if(request.getParameter("remember") == null)
//					;
//				else if(request.getParameter("remember").equals("on")) { // 踰꾪듉 �늻瑜� 寃쎌슦
//					// 荑좏궎 �깮�꽦 
//					Cookie cookie = new Cookie("savedId", userId);
//					cookie.setMaxAge(60*60*24*40);
//					response.addCookie(cookie);
//				}
				return new PageInfo(false, "/index.do");
			}
			else { // 濡쒓렇�씤�븳 �쑀��媛� �뾾�뒗 寃쎌슦
				request.setAttribute("error", "濡쒓렇�씤 �떎�뙣");
				return new PageInfo("/user/loginForm.do");
			}
		} catch(Exception e) {
			return new PageInfo("/error/error.jsp");
		}
	}

	private PageInfo getLoginForm(HttpServletRequest request, HttpServletResponse response) {
		return new PageInfo("/login.jsp");
	}
}
