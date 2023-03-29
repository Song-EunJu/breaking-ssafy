<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">부서 목록</h2>
		</div>
		<div class="row">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>부서번호</th>
						<th>부서이름</th>
					</tr>			
				</thead>
				<tbody>
<c:choose>
	<%-- 부서 있을때 --%>
	<c:when test="${not empty requestScope.depts}">
		<c:forEach items="${requestScope.depts}" var="dept" varStatus="st">
				<tr>
					<td>${st.count}</td>
					<td>${dept.deptno}</td>
					<td><a href="${pageContext.request.contextPath}/dept/detail.do?deptno=${dept.deptno}">${dept.dname}</a></td>
				</tr>
<%-- 				<c:if  test= "${st.count mod 3==0}">
				<tr>
					<td colspan="3" style="height:3px;background-color:black"></td>
				</tr>
				</c:if> --%>
		</c:forEach>		
	</c:when>
	<c:otherwise>
			<tr><td colspan="3">등록된 부서가 없습니다.</td></tr>		
	</c:otherwise>	
</c:choose>				
		</tbody>
	</table>
	</div>
	</div>
</body>
</html>












