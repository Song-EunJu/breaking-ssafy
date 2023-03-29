package com.ssafy.controller;


import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.MapInfo;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.MapService;



public class MapController implements Controller {
	
	private MapService mapService = new MapService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		System.out.println("url : " + url);
		// 공통 요청 전처리는 여기에..
		Object info = null;

		if (url.contains("/map/about.do")) {
			info = getDeptList(request, response);
		}else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}	
		return info;
	}
	
	protected PageInfo getDeptList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int sido_code = Integer.parseInt(request.getParameter("sido_code"));
		int gugun_code = Integer.parseInt(request.getParameter("gugun_code"));
		int content_type_id = Integer.parseInt(request.getParameter("content_type_id"));
		try {
			List<MapInfo> mapInfos = mapService.getMapInfos(sido_code, gugun_code, content_type_id);
			request.setAttribute("mapInfos", mapInfos);
		} catch (Exception e) {
			request.setAttribute("message", "목록 조회 중 문제가 발생하였습니다.:" + e.getMessage());
			throw e;
		}

		return new PageInfo("/about.jsp");
	}
}
