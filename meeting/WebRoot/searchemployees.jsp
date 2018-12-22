<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="pagetop.jsp"></jsp:include>
	<div class="page-body">
		<jsp:include page="pageleft.jsp"></jsp:include>
		<div class="page-content">
			<div class="content-nav">会议预定 > 搜索员工</div>
			<form action="serchemp.action" method="post">
				<fieldset>
					<legend>搜索会议</legend>
					<table class="formtable">
						<tr>



							<td>姓名：</td>
							<td><input type="text" id="employeename"
								name="emp.employeename" maxlength="20" /></td>
							<td>账号名：</td>
							<td><input type="text" id="accountname"
								name="emp.accountname" maxlength="20" /></td>
							<td>状态：</td>
							<td><input type="radio" id="status" name="emp.status"
								value="1" checked="checked" /><label>已批准</label> <input
								type="radio" id="status" name="emp.status" value="0" /><label>待审批</label>
								<input type="radio" id="status" name="emp.status" value="-1" /><label>已关闭</label>
							</td>
						</tr>
						<tr>
							<td colspan="6" class="command"><input type="submit"
								class="clickbutton" value="查询" /> <input type="reset"
								class="clickbutton" value="重置" /></td>
						</tr>
					</table>
				</fieldset>
			</form>
			<div>
				<h3 style="text-align: center; color: black">查询结果</h3>
				<div class="pager-header">
					<div class="header-info">
						共<span class="info-number">${count }</span>条结果， 分成<span
							class="info-number">${totalpage }</span>页显示， 当前第<span
							class="info-number">${page }</span>页
					</div>
					<div class="header-nav">

						<a type="button" class="clickbutton" href="serchemp.action?page=1">首页</a>
						<a type="button" class="clickbutton"
							href="serchemp.action?page=${page-1}">上页</a>
						<a type="button" class="clickbutton"
							href="serchemp.action?page=${page+1}">下页</a>
						<a type="button" class="clickbutton"
							href="serchemp.action?page=${totalpage }">末页</a>

						<form action="searchemployees.action">
							跳到第<input type="text" id="pagenum" name="page" class="nav-number" />页 
							<input type="submit" class="clickbutton"  value="跳转" />
						</form>
					</div>
				</div>
			</div>
			<table class="listtable">
				<tr class="listheader">
					<th>姓名</th>
					<th>账号名</th>
					<th>联系电话</th>
					<th>电子邮件</th>
					<th>操作</th>
				</tr>
				<c:forEach items="#{list01 }" var="list01">
					<tr>
						<td>${list01.employeename }</td>
						<td>${list01.username }</td>
						<td>${list01.phone }</td>
						<td>${list01.email }</td>
						<td><a class="clickbutton"
							href="closeaccount.action?account=${list01.username }">关闭账号</a></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
	<div class="page-footer">
		<hr />
		 更多问题，欢迎联系QQ2278892914 <img
			src="images/footer.png" alt="CoolMeeting" />
	</div>
</body>
</html>