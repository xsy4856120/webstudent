<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();

	String basePath = request.getScheme()
			+ "://" + request.getServerName()
			+ ":"
			+ request.getServerPort()
			+ path
			+ "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>列表</title>
		<link  rel="stylesheet"  href="styles.css" />
		<link rel="stylesheet"  href="static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
		<script  src="jquery.min.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function(){
				$('.remove').click(function(){
					if(confirm("确定要删除吗？")){
						window.location.href="<%=basePath%>student?method=delete&id="+$(this).attr("keyword");
					}
				})
			})
		</script>
	</head>
	<body>
	${list}
		<form action="<%=basePath%>student?method=list" method="post">
			<div class="condition">
				ID：<input type="text" name="stuId" value="${student.stuid}">
				姓名：<input type="text" name="stuName" value="${student.username}">
				学号：<input type="text" name="stuNo" value="${student.stuNo}">
				<button>
					查询
				</button>
				<button type="button" onclick="window.location.href='add.jsp'">
					新增
				</button>
			</div>
		</form>
		<form action="<%=basePath%>teacher?method=list" id="tableList" method="post">
		<input type="hidden" name="pageNo" value="${pageInfo.pageNo}">
		<input type="hidden" name="stuId" value="${student.stuId}">
		<input type="hidden" name="stuName" value="${student.stuName}">
		<table class="tablelist">
			<thead>
				<tr>
					<th>姓名</th>
					<th>科目</th>
					<th>分数</th>

				</tr>
			</thead>
			<c:forEach items="${list}" var="teacher">
			<tr>

				<td>${teacher.username}</td>
				<td>${teacher.password}</td>
<%--				<td>${student.id}</td>--%>
					<%--				<td>--%>
<%--					<button class="edit" type="button" onclick="window.location.href='<%=basePath%>student?method=edit&id=${student.id}'">--%>
<%--						修改--%>
<%--					</button>--%>
<%--					<button class="remove" type="button" keyword="${student.id}">--%>
<%--						删除--%>
<%--					</button>--%>
<%--				</td>--%>
			</tr>
			</c:forEach>
		</table>
		<%@include file="../inc/page.jsp"%>
		</form>
	</body>
</html>
