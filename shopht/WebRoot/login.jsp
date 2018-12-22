<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="css/guide.css" type="text/css" />
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
	
	<div class="login_all" >
    	<div class="build_index" style="background-image:url(images/xust.jpg);width:100%;height:100%;"   >
            <div class="login_all_content">
            
                <div class="login_index">
                <form action="login.action" method="post" id="login_form">
					<div class="login_index_right">
                        <p class="login_title">系统登陆</p>
                        <div class="index_input">
                            <div class="login_error">${error }</div>
                            <div class="login_name">
                                <label>用户名：</label>
                                <div class="login_text">
                                    
                                    <input type="text" name="user.username" value="admin"/>
                                </div>
                            </div>
                            <div class="login_name">
                                <label>密码：</label>
                                <div class="login_text">
                                   
                                    <input type="password" name="user.password" value="123456"/>
                                </div>
                            </div>
                            <a href="#" id="a_login" class="login_button">登录</a>
                        </div><!--index_input-->
                        <div class="foot_login">
                            <p></p>
                        </div>
                    </div>
                    </form>
                    <div class="clr"></div>
                </div><!--login_index-->
            </div><!--login_all_content-->
           </div><!--login_all-->
	</div><!--login_all-->
    
</body>
</html>
