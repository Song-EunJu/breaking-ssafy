<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	  <h2>핸드폰 상세 정보</h2>
  	  <a class="btn btn-danger" href="${root }/mobile/delete.do?mobileCode=${mobile.mobileCode }">삭제</a>
	  <table class="table table-striped">
	      <tr>
	        <td>모델번호</td><td>${mobile.mobileCode }</td>
	      </tr>
	      <tr>
	        <td>모델명</td><td>${mobile.model }</td>
	      </tr>
	      <tr>
	        <td>가격</td><td>${mobile.price }</td>
	      </tr>
	      <tr>
	        <td>제조사</td><td>${mobile.company }</td>
	      </tr>
	  </table>
	
	</div>
<%@ include file="/include/footer.jsp" %>