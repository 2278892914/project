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

	<!--head-->
	<div id="head"> 
		<ul class="head_menu">
			<li>
				<a href="login.jsp" class="menu_out">
					<span>退出</span>
				</a>
			</li>
			<li>
				<a href="#" class="menu_password">
					<span>修改密码</span>
				</a>
			</li>
            <li>
				<a href="home.jsp" class="home_search">
					<span>首页</span>
				</a>
			</li>
		</ul><!--head_menu-->	
		<a class="logo">
				YSMALL----后台管理
		</a>
		<div class="clr"></div>	
	</div><!--head-->
	
	<!--main_left开始-->
	<div id="main_left">
    	 <!--一级目录-->
    	 <ul class="mainmenu">
         	 <li > 
                <a href="#">
                    <img class="reduce_icon" src="images/reduce_icon.png"/>
                    <span class="system_magane">系统管理</span>
                    <div class="clr"></div>	
                </a>
                 <!--二级目录-->
                <ul class="navmenu">
                    <li>
                        <a href="user_list.action">
                            <span class="navmenu_user" >用户管理</span>
                        </a>
                    </li>
                </ul><!--navmenu-->
                <!--二级目录结束-->
         	</li>
           	<li > 
                <a href="#">
                    <img class="reduce_icon"  src="images/add_hover.png"/>
                    <span class="preject_magane">商品管理</span>
                    <div class="clr"></div>	
                </a>
                 <!--二级目录-->
                <ul class="navmenu">
                	<li>
                        <a href="plist.action">
                            <span class="navmenu_user" >品类</span>
                        </a>
                    </li>
                    <li>
                        <a href="commodity_list.action">
                            <span class="navmenu_user" >商品</span>
                        </a>
                    </li>
                </ul><!--navmenu-->
                <!--二级目录结束-->
         	</li>
         	<li > 
                <a href="#">
                    <img class="reduce_icon"  src="images/add_hover.png"/>
                    <span class="xm_magane">订单管理</span>
                    <div class="clr"></div>	
                </a>
                 <!--二级目录-->
                <ul class="navmenu">
                	<li>
                        <a href="order_list.action">
                            <span class="navmenu_user" >订单</span>
                        </a>
                    </li>
                    <li>
                        <a href="tj_list.html">
                            <span class="navmenu_user" >统计分析</span>
                        </a>
                    </li>
                    
                </ul><!--navmenu-->
                <!--二级目录结束-->
         	</li>
         </ul><!--mainmenu-->
	</div>
	<!--main_left结束-->
	
	<!--main_right-->
	
	<div id="main_right"> 
           <iframe src="home_frame.html" frameborder="0" width="100%"  height="100%" scrolling="no" ></iframe>
	</div><!--main_right结束-->
	
	
</body>
</html>
