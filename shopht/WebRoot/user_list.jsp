<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="css/base.css" type="text/css" />
</head>

<body>
	<div class="main_right_top">
		您现在所在位置 > <span>用户管理</span><a href="login.action" style="margin-right;color: red">后台主页</a>
	</div>
	<div class="main_right_body">
		<div class="body_content">
			<div class="biao_list">
				<div class="set_all">
					<h1 class="biao_title">用户信息</h1>
					<a href="#" class="set_btn_link">导出用户信息数据</a>
				</div>
				<!--set_all-->
				<table border="0" cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<th><input type="checkbox" /></th>
							<th>用户名称</th>
							<th>邮箱地址</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="list">
							<tr>
								<td><input type="checkbox" /></td>
								<td>${list.username }</td>
								<td>${list.email }</td>
								<td><a href="#" class="td_detail">详情</a> <a
									href="delete_user.action?id=${list.id }" class="td_detele">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="page_all">
					<div class="page">
						<ul>
							<li><a><span class="arrow_left"></span></a></li>
							<li><a>1</a></li>
							<li><a>2</a></li>
							<li class="page_active"><a>3</a></li>
							<li><a>4</a></li>
							<li><a>5</a></li>
							<li><a><span class="arrow_right"></span></a></li>
							<div class="clr"></div>
						</ul>
					</div>
					<div class="clr"></div>
				</div>
				<!--page_all-->

			</div>
			<!--biao_list-->
		</div>
	</div>
	<!--main_right_body-->
</body>
</html>
