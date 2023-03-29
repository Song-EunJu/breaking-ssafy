package com.ssafy.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.test.dto.Mobile;
import com.ssafy.test.dto.PageInfo;
import com.ssafy.test.dto.User;
import com.ssafy.test.dto.UserInfo;
import com.ssafy.test.model.service.MobileService;
import com.ssafy.test.model.service.UserService;

@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MobileService mobileService = new MobileService();
	private UserService userService = new UserService();

	@Override
	public void init() throws ServletException {
		ServletContext application = getServletContext();
		application.setAttribute("root", application.getContextPath());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		Object info = null;
		
		try {
			System.out.println(url);
			if(url.equals("/mobile/registerForm.do"))
				info = getMobileRegisterForm(request, response);
			else if(url.equals("/mobile/register.do"))
				info = registerMobile(request, response);
			else if(url.equals("/mobile/list.do")) 
				info = getMobileList(request, response);
			else if(url.equals("/mobile/detail.do"))
				info = getMobile(request, response);
			else if(url.equals("/mobile/delete.do"))
				info = deleteMobile(request, response);
			else if(url.equals("/index.do"))
				info = getIndex();
			else if(url.equals("/user/loginForm.do"))
				info = getLoginForm(request, response);
			else if(url.equals("/user/login.do"))
				info = login(request, response);
			else if(url.equals("/user/logout.do"))
				info = logout(request, response);
			
			if(info instanceof PageInfo) {
				PageInfo pageInfo = (PageInfo) info;
				if(pageInfo.isForward())
					request.getRequestDispatcher(pageInfo.getUrl()).forward(request, response);
				else
					response.sendRedirect(request.getContextPath()+pageInfo.getUrl());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private PageInfo logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			return new PageInfo("/index.do");
		} catch(Exception e) {
			return new PageInfo("/error/error.jsp");
		}
	}

	private PageInfo login(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			 // 누르면 on 안누르면 null
			User user = userService.login(id, pw);
			if(user != null) {
				HttpSession session = request.getSession();
				UserInfo userInfo = new UserInfo(id, pw);
				session.setAttribute("userInfo", userInfo);
				
				if(request.getParameter("remember") == null)
					;
				else if(request.getParameter("remember").equals("on")) { // 버튼 누른 경우
					// 쿠키 생성 
					Cookie cookie = new Cookie("savedId", id);
					cookie.setMaxAge(60*60*24*40);
					response.addCookie(cookie);
				}
				
				return new PageInfo("/index.do");
			}
			else { // 로그인한 유저가 없는 경우
				request.setAttribute("error", "로그인 실패");
				return new PageInfo("/user/loginForm.do");
			}
		} catch(Exception e) {
			return new PageInfo("/error/error.jsp");
		}
	}

	private PageInfo getLoginForm(HttpServletRequest request, HttpServletResponse response) {
		return new PageInfo("/user/login.jsp");
	}

	private PageInfo getIndex() {
		return new PageInfo("/index.jsp");
	}

	private PageInfo deleteMobile(HttpServletRequest request, HttpServletResponse response) {
		try {
			String mobileCode = request.getParameter("mobileCode");
			mobileService.deleteMobile(mobileCode);
			return new PageInfo("/mobile/list.do");
		} catch(Exception e) {
			return new PageInfo("/error/error.jsp");
		}
	}

	private PageInfo getMobile(HttpServletRequest request, HttpServletResponse response) {
		try {
			String mobileCode = request.getParameter("mobileCode");
			Mobile mobile = mobileService.getMobile(mobileCode);
			request.setAttribute("mobile", mobile);
			return new PageInfo("/mobile/detailMobile.jsp");
		} catch(Exception e) {
			return new PageInfo("/error/error.jsp");
		}
	}

	private PageInfo registerMobile(HttpServletRequest request, HttpServletResponse response) {
		try{
			mobileService.registerMobile(request);
			return new PageInfo("/mobile/list.do");
		} catch(Exception e) {
			return new PageInfo("/error/error.jsp");
		}
	}

	private PageInfo getMobileRegisterForm(HttpServletRequest request, HttpServletResponse response) {
		return new PageInfo("/mobile/registMobile.jsp");
	}

	private PageInfo getMobileList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Mobile> mobiles = mobileService.getMobileList();
			request.setAttribute("mobiles", mobiles);
			return new PageInfo("/mobile/listMobile.jsp");
		} catch (Exception e) {
			return new PageInfo("/error/error.jsp");
		}
	}
}
