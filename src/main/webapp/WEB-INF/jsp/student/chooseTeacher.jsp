<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'chooseTeacher.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
.stu_tab {
	width: 800px;
	line-height: 25px;
	margin-left: auto;
	margin-right: auto;
	border: 1px black solid;
}

.stu_tab tr th {
	border-right: 1px black solid;
	border-left: 1px black solid;
	border-top: 1px black solid;
}

tr td {
	width: 200px;
	height: 20px;
	font-size: 10px;
	text-align: center;
	line-height: 20px;
	border: 1px black solid;
	overflow: hidden;
}
</style>

</head>

<body>
	<div class="stu_tab">
		<table>
			<tr>
				<th>姓名</th>
				<th>班级</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${teacherList }" var="a">
				<tr>
					<td><c:out value="${a.name }"></c:out></td> 
					<td><c:out value="${a.classid }"></c:out></td>
					<td>未评教</td>
					<td><a href="">进入评教</a></td>
        		</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>
