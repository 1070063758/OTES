<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%@ page import="com.ssm.pojo.function" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	List<function> li = (List<function>)request.getAttribute("func");
	

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'te.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="css/login2.css">
<link rel="stylesheet" href="easyui/themes/default/easyui.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#tree_1>ul").hide();
		
		
		$("#tree_1").click(function() {
			$("#tree_1>ul").toggle();
		});
	})
</script>

</head>

<body>
	<div class="top">
    <nav>
        <ul>
            <li><a href="#">重庆工程学院</a></li>
        </ul>

    </nav>
</div>
<div style="margin:0;"></div>
<div class="left">
    <ul class="easyui-tree">
                <li data-options="state:'closed'">
                    <span id="0"><c:out value="${type }"></c:out></span>
                    <ul>
                        <c:forEach items="${func }" var="func">
                        	<li><a target="iframes" href="student/getTeacher.do"><c:out value="${func.getFunc() }"></a></c:out></li>
                        </c:forEach>
                    </ul>
                </li>
    </ul>
</div>
<iframe name="iframes" src="index.jsp" frameborder="1"></iframe>
</body>
</html>
