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
	<form action="add.do" class="ss">
		电影名称：<input type="text" name="dname"><br>
		电影简介：<input type="text" name="content"><br>
		导演：<input type="text" name="dao"><br>
		上架时间：<input type="date" name="day"><br>
		类型：<br>
		<c:forEach items="${type }" var="t">
			<input type="checkbox" name="tids" value="${t.tid }">${t.tname }<br>
		</c:forEach>
		<br>
		<button>添加</button>
	</form>
	
</body>
</html>