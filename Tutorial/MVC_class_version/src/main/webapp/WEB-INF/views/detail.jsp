<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/menu.jsp"/>
	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">부서 조회</h2>
	<c:if test="${errorMsg != null}">
		<div class="row mt-3">
				<h4 class="bg-warning text-light text-center">${errorMsg}</h4>
		</div>	
	</c:if>			
		</div>						
		<form method="post" action="${root}/dept/modify.do" class="row">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="deptno">부서번호</label></th>
						<td><input type="text" name="deptno" id="deptno" 
									value="${dept.deptno}" readonly="readonly"/></td>
					</tr>
					<tr>
						<th><label for="dname">부서이름</label></th>
						<td><input type="text" name="dname" id="dname" 
							value="${dept.dname}"/></td>
					</tr>
					<tr>
						<th><label for="loc">지역</label></th>
						<td><input type="text" name="loc" id="loc" 
								value="${dept.loc }" /></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="submit" value="수정"/>
							<input type="submit" value="삭제" formaction="${root}/dept/remove.do"  formmethod="get"/>
							<input type="reset" value="취소"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>





