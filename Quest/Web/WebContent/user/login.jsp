<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>
	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
		<c:choose>
		 	<c:when test="${not empty requestScope.error}">
				<span>${error}</span>
			</c:when>
		</c:choose>
	  <h2>로그인</h2>
	  <form method = "post" action = "${root}/user/login.do">
	  	<input type="hidden" name="action" value="">
	    <div class="form-group">
	      <label for="id">id:</label>
	      <input type="text" class="form-control" id="id" placeholder="ID 입력" name = "id" value="${cookie.savedId.value}">
	    </div>
	    <div class="form-group">
	      <label for="pw">Password:</label>
	      <input type="password" class="form-control" id="pw" name = "pw" placeholder="비밀번호 입력" >
	    </div>
	    <div class="form-group form-check">
	      <label class="form-check-label">
	        <input class="form-check-input" type="checkbox" name="remember"> 아이디 기억하기
	      </label>
	    </div>
	    <button type="submit" class="btn btn-primary">로그인</button>
	    <a class="btn btn-secondary" href="${root}/index.do" >메인 페이지로</a>
	  </form>
	
	
	</div>
<%@ include file="/include/footer.jsp" %>