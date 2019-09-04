<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index2.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<form action="update.do" class="ss">
		<input type="text" name="did" value="${param.did }">
		电影名称：${dy.dname }<br>
		电影简介：${dy.content }<br>
		导演：${dy.dao }<br>
		上架时间：${dy.day }<br>
		${dt }
		类型：<br>
		<c:forEach items="${type }" var="t">
		<input type="checkbox" name="tids" 
			<c:forEach items="${dt }" var="d">
				<c:if test="${d==t.tid }">
				checked
			</c:if>
				
			</c:forEach>
			value="${t.tid }">${t.tname }<br>
			
		</c:forEach>
		
		<br>
		<button>修改</button>
	</form>
	
</body>
</html>