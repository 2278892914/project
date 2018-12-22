<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>租车管理系统</title>
<link href="css/global.css" rel="stylesheet" type="text/css">
</head>

<body style="background-color:#e7f3ff; ">
    <div class="login_all">
          <div class="login_all_content">
          	    <div class="login_mask">
                    <div class="login_all_left">
                          <div class="login_header">
                              <a href=""><img src="images/home_logo.png"/ ></a>
                               <span class="system_name">租车管理系统</span>
                               <div class="clr"></div>        
                          </div>
                          <div class="car_mate"></div>
                    </div><!--login_all_left-->
                    <div class="login_all_right">
						<div class="login_text_top"> </div>
						<!-- 当提交表单数据的时候，表单数据会提交到名为login.do的文件之中 -->
						<form action="LoginAction_login.do" method="post">
						<div class="login_text_certont">
							<div class="login_title">用户登录</div>
							<div class="index_input">
								<div class="login_error">
								${error}
								</div>
								<!-- 给用户名和密码添加name属性用于获取表单元素的值 -->
								<div class="login_name">
									<label>用户名：</label>
									<div class="login_text">
										<input type="text" name = "user"/>
									</div>
									<div class="clr"></div>
								</div>
								<div class="login_name">
									<label>密码：</label>
									<div class="login_text">
										<input type="text" name = "pass"/>
									</div>
									<div class="clr"></div>
								</div>
								
								<div class="login_form_botton">
									<input type="submit" class="login_button" value="" ></input>
									<a class="forget_btn">忘记密码</a>
								</div>
							</div><!--index_input-->									
						</div><!--login_text_certont-->
						</form>
						<div class="login_text_bottom"></div>
                    </div><!--login_all_right-->
               </div><!--login_mask-->
          </div>  <!--login_all_content-->
    </div><!--login_all-->
</body>
</html>
