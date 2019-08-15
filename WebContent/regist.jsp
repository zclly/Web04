<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		span{
			color:red;
		}
	</style>
	<!-- 引入jQuery -->
	<script type="text/javascript" src="scripts/jquery-1.7.2.min.js"> </script>
	<script type="text/javascript">
		//获取xhr对象
		function getXhr(){
			var xhr = new XMLHttpRequest();
			
			return xhr;
		}
		
		function checkUsername(){
			//获取用户输入的用户名。
			var username = document.getElementById("username").value;
			//发送异步请求校验。
			var xhr = getXhr();
			
			//设置请求信息
			xhr.open("get","checkUsername?username="+username,true);
			//发送请求
			xhr.send();
			//监听readystate的状态
			xhr.onreadystatechange = function(){ //匿名函数
				if(xhr.readyState == 4){ //响应处理完成
					if(xhr.status == 200){ //处理正确
						//获取服务端响应回来的数据
						var msg = xhr.responseText;
						//将信息显示到输入框的后面。
						document.getElementById("regist_span").innerHTML = msg;
						
					}
				}
			}
		}
		
		$(function(){
			var usernameFlag = false ;
			var passwordFlag = false ;
			$("#username").blur(function(){
				var username = $("#username").val();
				//发送异步请求
				$.ajax({
					url:"checkUsername",
					type:"post",
					data:"username=" +username,
					success:function(data){
						if(data == 0){
							$("#regist_span").html("用户名可以使用");
							usernameFlag = true ;
						}else{
							$("#regist_span").html("用户名已存在，请更换");
						}
				    }					
				});	
			});
			
			$("#repassword").blur(function(){
				var password = $("#password").val();
				var repassword = $("#repassword").val();		
				if(password != null && password !="" && repassword == password){
					$("#pass_span").html("密码一致,可以使用");
					passwordFlag = true ;
				}else{
					$("#pass_span").html("密码不一致，请更换！");
				}
					
			})
			
			$("form").submit(function(){
				/* if(usernameFlag && passwordFlag){
					return true ;
				}else{
					return false ;
				} */
				return usernameFlag && passwordFlag ;
			})
		})
		
	</script>
</head>
<body>
    <h1>欢迎注册</h1>
        <form action="regist" method="post">
        	<!-- 用户名称：<input type="text" id="username" name = "username" onblur="checkUsername();"/><span id="regist_span">${regist_msg}</span> -->
        	
        	用户名称：<input type="text" id="username" name = "username" /><span id="regist_span">${regist_msg}</span>
        	<br>
        	用户密码：<input type="password" id="password" name = "password">
        	<br>
        	确认密码：<input type="password" id="repassword" name = "repassword"><span id="pass_span"></span>
        	<br>
        	<input type="submit" value="注册"/>
        </form>

</body>
</html>