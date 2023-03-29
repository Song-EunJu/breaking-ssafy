package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.PageInfo;

@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserController userController = new UserController();
	private HomeController homeController = new HomeController();
	private MapController mapController = new MapController();
	
	@Override
	public void init() throws ServletException {
		ServletContext application = getServletContext();
		application.setAttribute("root", application.getContextPath());
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = request.getServletPath();
		Object info = null;
		
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
					request.getRequestDispatcher(pageInfo.getPath()).forward(request, response);
					return;
				} else {
					response.sendRedirect(request.getContextPath() + pageInfo.getPath());
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
		if(url.startsWith("/user")) 
			return userController;
		else if(url.equals("/index.do"))
			return homeController;
		else if(url.equals("/map/about.do"))
			return mapController;
		return null;
	}
}
