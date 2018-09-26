<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
* {
	margin: 0;
	padding: 0;
}

ul, ol, li {
	list-style: none;
}

a {
	text-decoration: none;
}

img {
	boder: none;
}

body {
	font_family: Arial, Verdana, "SimSun", "Microsoft YaHei";
	font_size: 14px;
}

.fl {
	float: left;
}

.fr {
	float: right;
}

.clear {
	clear: both;
	line-height: 0;
	height: 0;
	font-size: 0;
	overflow: hidden;
}

.login_regist {
	width: 100%;
	height: 670px;
	background: url("./img/bg_1.jpg") no-repeat;
	background-size: cover;
}

.titles {
	width: 300px;
	height: 80px;
	line-height: 80px;
	font-size: 40px;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

.login {
	width: 290px;
	height: 280px;
	background: rgba(240, 240, 240, 0.8);
	position: relative;
	margin-top: 100px;
	padding-left: 30px;
	padding-top: 20px;
	margin-left: 1000px;
	border: 1px white solid;
	border-radius: 5px;
}

.login .title {
	width: 100px;
	height: 50px;
	font-size: 20px;
}

.login .list select {
	margin-top: 16px;
	width: 254px;
	height: 30px;
}

.login .lg {
	width: 250px;
	line-height: 30px;
	margin-top: 11px;
	margin-left: 4px;
}

.login section p input {
	width: 260px;
	height: 40px;
	background: rgba(0, 100, 255, 0.7);
	margin-top: 15px;
}

.login section p a {
	width: 55px;
	height: 30px;
	font-size: 5px;
	margin-top: 5px;
	margin-left: 200px;
}
</style>

</head>

<body>
	<form action="user/loginController" method="post">
		<div class="login_regist">
			<div class="titles">
				<b>TCES教务系统</b>
			</div>
			<div class="login" id="login">
				<div class="title">
					<b>登录</b>
				</div>
				<section> <input placeholder="学号/工号/教师号" class="lg"
					type="text" id="logins" name="username" autofocus> <input
					placeholder="密码" class="lg" type="password" name="password"
					id="passwords">
				<p>
					<a href="#" onclick="regist()">忘记密码</a>
				</p>
				<p>
					<input type="submit" value="登录">
				</p>
				</section>
			</div>
		</div>
	</form>
</body>
</html>
