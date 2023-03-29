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
	  <h2>핸드폰 목록</h2>
	  <table class="table table-hover">
	    <thead>
	      <tr>
	        <th>고유번호</th>
	        <th>모델명</th>
	        <th>가격</th>
	        <th>제조사</th>
	      </tr>
	    </thead>
	    <tbody>
			<c:choose>
				<c:when test = "${not empty requestScope.mobiles}">
					<c:forEach items="${mobiles}" var="mobile">
						<tr >
							<td>${mobile.mobileCode }</td>
							<td><a href="${root }/mobile/detail.do?mobileCode=${mobile.mobileCode}">${mobile.model }</a></td>
							<td>${mobile.price }</td>
							<td>${mobile.company }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					데이터 없음 !!
				</c:otherwise>
			</c:choose>
	    </tbody>
	  </table>
	</div>

<%@ include file="/include/footer.jsp" %>