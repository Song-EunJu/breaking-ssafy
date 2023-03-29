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
			<h2 class="bg-primary text-light text-center">로그인</h2>
		</div>
	<c:if test="${errorMsg != null}">
		<div class="row mt-3">
				<h4 class="bg-warning text-light text-center">${errorMsg}</h4>
		</div>	
	</c:if>	
	<form action="${root}/user/login.do" method="post" class="row">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="userId">아이디</label></th>
						<td><input type="text" name="userId" id="userId"/></td>
					</tr>
					<tr>
						<th><label for="password">비밀번호</label></th>
						<td><input type="password" name="password" id="password"/></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" class="text-center">
							<input type="submit" value="로그인"/>
							<input type="reset" value="취소"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>