package com.ssafy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.UserService;

public class UserController implements Controller {
	private UserService userService = new UserService();

	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// url 이 user 로 시작하는 애들만 받을거임
		String url = request.getServletPath();
		Object info = null;

		if (url.equals("/user/login.do")) {
			info = login(request, response);
		} else if (url.equals("/user/login_form.do")) {
			info = getLoginForm(request, response);
		}else if (url.equals("/user/logout.do")) {
			info = logout(request, response);
		}
		return info;
	}
	
	protected PageInfo login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		String name;
		name = userService.login(userId, password);
		System.out.println(userId + "/" + password + "/" + name);
		if (name != null) {
			// 로그인 성공
//				Cookie c1 = new Cookie("userName", name);
//				c1.setPath(request.getContextPath());
//				Cookie c2 = new Cookie("userId", userId);
//				c2.setPath(request.getContextPath());
//				response.addCookie(c1);
//				response.addCookie(c2);

			HttpSession session = request.getSession();
			session.setAttribute("userName", name);
			session.setAttribute("userId", userId);

			return new PageInfo(false, "/index.do");
		} else {
			// 로그인 실패
			request.setAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return new PageInfo("/login.jsp");
		}

	}


	protected PageInfo logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

//		Cookie[] cookies= request.getCookies();
//		for(Cookie c: cookies){
//			if(c.getName().equals("userName") || c.getName().equals("userId")){
//				c.setPath(request.getContextPath());
//				c.setMaxAge(0);
//				response.addCookie(c);
//			}
//		}
		request.getSession().invalidate();
		return new PageInfo(false,"/index.do");
	}
	
	protected PageInfo getLoginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo("/login.jsp");
	}
}
