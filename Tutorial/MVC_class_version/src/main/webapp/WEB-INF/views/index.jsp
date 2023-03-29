<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
	<ul>
		<li><a href="${root}/dept/regist_form.do">부서 등록 </a></li>
		<li><a href="${root}/dept/list.do">부서 목록</a></li>
		<li><a href="${root}/dept/rest/list.do">부서 목록-JSON</a></li>
		<li><a href="${root}/dept/rest/detail.do?deptno=10">부서 상세정보-JSON</a></li>
	</ul>
</body>
</html>