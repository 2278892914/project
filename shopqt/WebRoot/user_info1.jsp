<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link typjstl-1.2.jare="text/css" rel="stylesheet" href="css/commons.css"/>
		<link type="text/css" rel="stylesheet" href="css/shop.css"/>
	</head>
	<body>
		
		<div class="nav">
			<div class="n_warp">
				<div class="n_w_left">
					<a href="#">登录</a>
					<a href="#">注册</a>
					<span>欢迎，小胖墩</span>
					<a href="#">退出</a>
				</div>
				<div class="n_w_right">
					<a href="#" class="shopping">购物车(0)</a>
					<a href="#" class="order">我的订单</a>
					<a href="#" class="my">我的MALL</a>
					<a href="#" class="about">关于MALL</a>
				</div>
			</div>
		</div>
		<div class="header">
			<div class="h_left">
				<a href="#">YSMALL</a>
			</div>
			<div class="h_right">
				<input type="text" /><button>搜索</button>
			</div>
		</div>
		
		<div class="s1">
				<div>
					<a href="#">MMall</a><span>&gt;</span> <a href="#" >商品列表</a>
				</div>
		</div>
		
		
		<div class="user_warp">
			<div class="user_info_left">
				<ul>
					<li><a href="#">个人中心</a></li>
					<li><a href="#">我的订单</a></li>
					<li><a href="user_info3.jsp">修改密码</a></li>
				</ul>
			</div>
			<div class="user_info_right">
				<h1>我的个人信息</h1>
				<ul>
				<c:forEach items="${userlist }" var="user">
					<li><span class="u_sp1">用户名：</span><span class="u_sp2">${user.username }</span></li>
					<li><span class="u_sp1">电 话：</span><span class="u_sp2">${user.phone }</span></li>
					<li><span class="u_sp1">邮 箱：</span><span class="u_sp2">${user.email }</span></li>
					<li><span class="u_sp1">问 题：</span><span class="u_sp2">${user.question }</span></li>
					<li><span class="u_sp1">答 案：</span><span class="u_sp2">${user.answer }</span></li>
				</c:forEach>
				</ul>
				<div>
					<a href="#">编辑</a>
				</div>
			</div>
			
			
		</div>
		
		
		<div class="footer">
			<span>@西安云思信息技术有限公司</span>
		</div>
	</body>
</html>
