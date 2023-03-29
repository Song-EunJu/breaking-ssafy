<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- ======= Header ======= -->
  <header id="header" class="header d-flex align-items-center">
    <div class="container-fluid container-xl d-flex align-items-center justify-content-between">

      <a href="${root }/index.do" class="logo d-flex align-items-center">
        <h1>EnjoyTrip<span>.</span></h1>
      </a>

      <i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
      <i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>
      <nav id="navbar" class="navbar">
        <ul>
          <li><a href="${root}/index.do" class="active">Home</a></li>
          <li><a href="${root}/about.jsp">지역별 여행지</a></li>
          <li><a href="">여행계획 세우기</a></li>
          
          <c:choose>
          	<c:when test="${empty userInfo}">
	          <li><a href="${root }/user/loginForm.do">로그인</a></li>
	          <li><a href="${root }/user/registerForm.do">회원가입</a></li>
          	</c:when>
          	<c:otherwise>
				<li><a href="${root }/user/mypage.do">마이페이지</a></li>
				<li><a href="${root}/user/logout.do">로그아웃</a></li>
			</c:otherwise>
          </c:choose>
        </ul>
      </nav>

    </div>
  </header>