<!-- JSP声明 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 文档类型 -->
<html>
	<head>
	    <meta charset="utf-8">
		<style>
			body{
				background-color:pink;
			}
			 span{
			    color:red;
			} 
		
		</style>
		<script type="text/javascript">
		    //js代码
		    function clearLoginMsg(){
		    	var spanEle = document.getElementById("login_span");
		    	//将id = login_span里面的值重新赋值为空
		    	spanEle.innerHTML="";
		    }
		</script>

	
	</head>
	    <meta charset = "utf-8">
	<!--<body bgcolor="pink"> -->
	<body bgcolor="pink">
		<h1>欢迎登陆</h1>
		<!-- 
		action:请求的地址
		method:请求的方式
		    get请求：将请求的数据拼接到请求的地址中，直接暴露出来。http://localhost:8080/web01/login.html
		    post请求:将请求的数据保存到请求的地址中，不会直接暴露出来。
		 -->
		<form action="login" method="post">
			用户名称:<input type="text" name="username" onfocus="clearLoginMsg()"/>
			       <span id="login_span">${requestScope.login_msg}</span>
			<%--
				<%
				    //获取request对象啊：request对象直接获取。
				    String loginMsg = (String)request.getAttribute("login_msg");
				%>
				<span><%= loginMsg ==null?"":loginMsg %></span>
			--%>
			<br/>
			用户密码:<input type="password" name="password"/>
			<br/>
			<input type="submit" value="Login"/>
		
		</form>
	</body>

</html>