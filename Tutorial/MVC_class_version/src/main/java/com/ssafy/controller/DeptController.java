package com.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.Dept;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;

public class DeptController implements Controller {
	private DeptService deptService = new DeptService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		Object info = null;

		if (url.equals("/dept/list.do")) {
			info = getDeptList(request, response);
		} else if (url.equals("/dept/detail.do")) {
			info = getDeptDetail(request, response);
		} else if (url.equals("/dept/regist_form.do")) {
			info = getDeptRegistForm(request, response);
		} else if (url.equals("/dept/register.do")) {
			info = registDept(request, response);
		} else if (url.equals("/dept/modify.do")) {
			info = modifyDept(request, response);
		} else if (url.equals("/dept/remove.do")) {
			info = removeDept(request, response);
		} else if (url.equals("/dept/rest/list.do")) {
			info = getRestDeptList(request, response);
		} else if (url.startsWith("/dept/rest/detail.do")) {
			info = getRestDeptDetail(request, response);
		}
		return info;
	}
	
	protected PageInfo getDeptList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		try {
			List<Dept> depts = deptService.getDepts();
			request.setAttribute("depts", depts);
		} catch (Exception e) {
			request.setAttribute("message", "목록 조회 중 문제가 발생하였습니다.:"+e.getMessage());
			throw e;
		}

		return new PageInfo("/list.jsp");
	}
	protected DataInfo getRestDeptList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			List<Dept> depts = deptService.getDepts();
			return new DataInfo("application/json", depts);
		} catch (Exception e) {
			request.setAttribute("message", "목록 조회 중 문제가 발생하였습니다.:"+e.getMessage());
			throw e;
		}
		
	}

	protected PageInfo getDeptDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptNo = Integer.parseInt(request.getParameter("deptno"));

		Dept dept = deptService.getDept(deptNo);
		request.setAttribute("dept", dept);

		return new PageInfo("/detail.jsp");
	}
	protected DataInfo getRestDeptDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptNo = Integer.parseInt(request.getParameter("deptno"));
		Dept dept = deptService.getDept(deptNo);
		return new DataInfo("application/json",dept);
	}

	protected PageInfo getDeptRegistForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo("/register.jsp");
	}

	protected PageInfo registDept(HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			String sDeptNo = request.getParameter("deptno");
			String dname = request.getParameter("dname");
			String loc = request.getParameter("loc");
			System.out.println(sDeptNo);
			if (sDeptNo == null || sDeptNo.trim().length() == 0 || dname == null || dname.trim().length() == 0
					|| loc == null || loc.trim().length() == 0) {
				request.setAttribute("errorMsg", "입력데이터 값에 문제가 있습니다. 올바르게 입력해주세요");
				return new PageInfo("/register.jsp");
			} // 유효성 검사

			int deptNo = Integer.parseInt(sDeptNo);

			deptService.registDept(new Dept(deptNo, dname, loc));
		} catch (Exception e) {
			request.setAttribute("message", "부서 등록 중 문제가 발생하였습니다."+e.getMessage());
			throw e;
		} 
		return new PageInfo(false, "/dept/list.do");
	}

	protected PageInfo modifyDept(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String sDeptNo = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");

		if (sDeptNo == null || sDeptNo.trim().length() == 0 || dname == null || dname.trim().length() == 0
				|| loc == null || loc.trim().length() == 0) {
			request.setAttribute("errorMsg", "입력데이터 값에 문제가 있습니다. 올바르게 입력해주세요");

//			return new PageInfo("/dept/detail.do"); 이게 잘못된 코드임!!!!@!
			
			request.setAttribute("dept", new Dept(Integer.parseInt(sDeptNo),dname,loc));
			return new PageInfo("/detail.jsp");
		} // 유효성 검사

		int deptNo = Integer.parseInt(sDeptNo);
		deptService.modifyDept(new Dept(deptNo, dname, loc));
		return new PageInfo(false, "/dept/list.do");
	}

	protected PageInfo removeDept(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int deptNo = Integer.parseInt(request.getParameter("deptno"));
		deptService.removeDept(deptNo);
		return new PageInfo(false, "/dept/list.do");

	}
}
