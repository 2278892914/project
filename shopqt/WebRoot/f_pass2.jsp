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
			<form action="/shopqt/f_pass2.do" method="post" id="sb_form">
			<ul>
				<li >
					<h3>找回密码</h3>
				</li>
				<li class="item_one">
					<span>请输入答案</span>
					
				</li>
				<li class="item_w">
				<span>${error }</span><br/>
					<span>密码提示问题为: ${question }</span>
					
				</li>
				<li class="item_two">
				    <input type="hidden" value="${username }" name="username">
					<input type="text" placeholder="请输入问题答案" name="answer"/>
				</li>
				
				<li class="item_four">
					<a href="#" id="sb">下一步</a>
				</li>
				
			</ul>
			
			</form>
			
		</div>
		
		
		<div class="footer">
			<span>@西安云思信息技术有限公司</span>
		</div>
	</body>
</html>
