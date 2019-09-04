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
	function page(cpage) {
		$("[name='cpage']").val(cpage)
		$(".ss").submit()
		
	}
	
	function ps() {
		var did = "";
		$(":checkbox:checked").each(function(){
			did+=","+$(this).val()
		})
		
		$.post("deleteAll.do",{did:did},function(i){
			if(i>0){
				alert("删除成功")
				location="list.do"
			}else{
				alert("删除失败")
				
			}
		},"json")
		
	}
</script>
</head>
<body>
	<form action="list.do" class="ss">
		<input type="hidden" name="cpage" value="${page.pageNum }">
		电影名称:<input type="text" name="mh" value="${map.mh }">
		<button>查询</button>
	</form>
	<table>
		<tr>
			<td>电影序号</td>
			<td>电影名称</td>
			<td>电影简介</td>
			<td>导演</td>
			<td>上架时间</td>
			<td>类型</td>
			<td><input type="button" value="添加" onclick="location='toadd.do' "></td>
		</tr>
		<c:forEach items="${findList }" var="d">
		<tr>
			<td><input type="checkbox" value="${d.did }"></td>
			<td>${d.dname }</td>
			<td>${d.content }</td>
			<td>${d.dao }</td>
			<td>${d.day }</td>
			<td>${d.ns }</td>
			<td>
			<input type="button" value="修改" onclick="location='toupdate.do?did=${d.did}' ">
			<input type="button" value="批量删除" onclick="ps()">
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="10">
				<input type="button" value="首页" onclick="page('1')">
				<input type="button" value="上一页" onclick="page('${page.pageNum-1}')">
				<input type="button" value="下一页" onclick="page('${page.pageNum+1}')">
				<input type="button" value="尾页" onclick="page('${page.pages}')">
				当前${page.pageNum }/${page.pages }页
			</td>
		</tr>
	</table>
</body>
</html>