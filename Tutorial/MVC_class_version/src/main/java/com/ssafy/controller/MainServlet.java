package com.ssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.Dept;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;
import com.ssafy.model.service.UserService;

@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptController deptController = new DeptController();
	private UserController userController = new UserController();
	private HomeController homeController = new HomeController();

	@Override
	public void init() throws ServletException {
		ServletContext application = getServletContext();
		application.setAttribute("root", application.getContextPath());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getServletPath();
		System.out.println("url : " + url);
		// 공통 요청 전처리는 여기에..
		Object info = null;

		if (url.startsWith("/dept")) {
			HttpSession session = request.getSession();
			if (session.getAttribute("userId") == null) {
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
				return;
			}
		}

		try {
			Controller controller = getController(url);
			if(controller != null) {
				info = controller.handleRequest(request, response);
			} else {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			
			if (info instanceof PageInfo) {
				PageInfo pageInfo = (PageInfo) info;
				if (pageInfo.isForward()) {
					request.getRequestDispatcher("/WEB-INF/views"+pageInfo.getPath()).forward(request, response);
					return;
				} else {
					response.sendRedirect(request.getContextPath() + pageInfo.getPath());
				}
			}else {
				DataInfo dataInfo = (DataInfo) info;
				response.setContentType(dataInfo.getContentType()+";charset=UTF-8");
				if(dataInfo.getContentType().equals("application/json")) {
					ObjectMapper mapper = new ObjectMapper();
					String value = mapper.writeValueAsString(dataInfo.getData());
					response.getWriter().println(value);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return;
		}
		// 공통 후처리는 여기에..
	}
	
	private Controller getController(String url) {
		if(url.startsWith("/user")) {
			return userController;
		}
		else if(url.startsWith("/dept")) {
			return deptController;
		}
		else if(url.equals("/index.do")){
			return homeController;
		}
		return null;
	}
}
