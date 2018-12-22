<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title></title>
	<link type="text/css" rel="stylesheet" href="css/commons.css"/>
	<script type="text/javascript">
			window.onload = function(){
				
				var a_login = document.getElementById("a_login");
				a_login.onclick = function(){
					
					var login_form = document.getElementById("login_form");
					login_form.submit();
					
				}
				
				
			}
		</script>
</head>
	<body >
		
		<div class="header" style="background-image:url(img/xust.jpg);width:100%;height:100%;" >
			<div class="h_left">
				<a href="#">YSMALL</a>
			</div>
			
		</div>
		<form action="/shopqt/login.do" id="login_form" method="post">
		<div class="login" >
			
			<ul>
				<li >
					<h3>用户登录</h3>
				</li>
				<li class="item_one">
					${error }
				</li>
				<li class="item_two">
					<label>
					<i><img src="img/user.png"></i>
					</label>
					<input type="text" placeholder="请输入用户名" name="username"/>
				</li>
				<li class="item_three">
					<label>
					<i><img src="img/pass.png"></i>
					</label>
					<input type="password" placeholder="请输入密码" name="password"/>
				</li>
				<li class="item_four">
					<a href="#" id="a_login">登录</a>
				</li>
				<li class="item_five">
					<a href="f_pass1.jsp">忘记密码</a>
					<a href="">免费注册</a>
				</li>
			</ul>
		</div>
		</form>
		
		<div class="footer">
		</div>
	</body>
</html>
