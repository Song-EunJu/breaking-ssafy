<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<h2 class="bg-primary text-light text-center">부서 등록</h2>
		</div>
	<c:if test="${errorMsg != null}">
		<div class="row mt-3">
				<h4 class="bg-warning text-light text-center">${errorMsg}</h4>
		</div>	
	</c:if>	
	<form method="post" action="./register.do">
        <table class="table">
            <tbody>
                <tr>
                    <th><label for="deptno">부서번호</label></th>
                    <td><input type="text" name="deptno" id="deptno"/></td>
                </tr>
                <tr>
                    <th><label for="dname">부서이름</label></th>
                    <td><input type="text" name="dname" id="dname" value="${param.dname}"/></td>
                </tr>
                <tr>
                    <th><label for="loc">지역</label></th>
                    <td><input type="text" name="loc" id="loc"/></td>
                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="등록"/>
                        <input type="reset" value="취소"/>
                    </td>
                </tr>
            </tfoot>
        </table>
    </form>
</div>    
</body>
</html>