<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link type="text/css" rel="stylesheet" href="css/commons.css"/>
		<script type="text/javascript">
		window.onload = function () {
			var sb = document.getElementById("sb");
			sb.onclick = function () {
				var sb_form = document.getElementById("sb_form");
				sb_form.submit();
			}
		}
		
		
		</script>
		
	</head>
	
	<body>
		
		<div class="header">
			<div class="h_left">
				<a href="#">YSMALL</a>
			</div>
			
		</div>
		
		<div class="login">
			<form action="/shopqt/f_pass1.do" method="post" id="sb_form">
			<ul>
			
				<li >
					<h3>找回密码</h3>
				</li>
				<li class="item_one">
					<span>请输入用户名</span>
				</li>
				${error }
				<li class="item_two">
					<label>
					<i><img src="img/user.png"></i>
					</label>
					<input type="text" placeholder="请输入用户名" name="username"/>
				</li>
				
				<li class="item_four">
					<a href="#" id="sb">下一步</a>
				</li>
				
			</ul>
			
			</form>
			
		</div>
		
		
		<div class="footer">
			<span></span>
		</div>
	</body>
</html>
