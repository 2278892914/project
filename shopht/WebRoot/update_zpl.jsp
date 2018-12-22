<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="css/base.css" type="text/css" />
</head>

<body>
	<div class="main_right_top">
		您现在所在位置 > <span>更改子品类信息</span><a href="login.action"
			style="color: red">后台主页</a>
	</div>
	<div class="main_right_body">
		<div class="body_content">
			<div class="add_xm_all">
				<h1 class="add_xm_top">基本信息</h1>
				<!--add_xm_top-->
				<form action="updatezpl.action" method="post">
					<div class="add_xm_form">
						<ul>
							<li><label>子品类名称：</label> <input type="text"
								name="zplvo.pcname" value="${zplvo.pcname }" /> <input
								type="hidden" name="zplvo.id" value="${zplvo.id }" /> <span
								class="error_text"></span></li>
						</ul>
						<div class="regist_btn">
							<input type="submit" value="确认修改" /> <a class="return_btn"
								href="pl_list.action">返回</a>
						</div>
					</div>
					<!--add_xm_form-->
				</form>
			</div>
			<!--add_xm_all-->
		</div>
	</div>
	<!--main_right_body-->

</body>
</html>
