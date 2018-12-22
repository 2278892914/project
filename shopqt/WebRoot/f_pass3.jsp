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
			<form action="/shopqt/f_pass3.do" id="sb_form" method="post">
			<ul>
				<li >
					<h3>重置密码</h3>
				</li>
				
				<li class="item_w">
					<span></span>
				</li>
				<li class="item_two">
					<label>
					<i><img src="img/pass.png"></i>
					</label>
					<input type="password" placeholder="请输入新密码"/>
				</li>
				<li class="item_two">
					<label>
					<i><img src="img/pass.png"></i>
					</label>
					<input type="hidden" value="${username }" name="username">
					<input type="password" placeholder="请再次新密码" name="password"/>
				</li>
				<li class="item_four">
					<a href="#" id="sb">提交</a>
				</li>
				
			</ul>
			
			</form>
			
		</div>
		
		
		<div class="footer">
			<span></span>
		</div>
	</body>
</html>
