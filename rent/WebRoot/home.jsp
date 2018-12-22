<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>租车管理系统</title>
<link href="css/global.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="all">
<div class="view_all">
    <div class="head_home" >
    	<div class="logo">
        	<a href="">
        	<img src="images/home_logo.png" />
            </a>
        </div>
    
        <div class="user_infor">
        	<span class="uesr_name">欢迎您！${userName } > </span>
            <span>租车管理系统</span>        
        </div>
    	 <div class="clr"> </div>
    </div>
    <div class="home_content">
    	<div class="function">
        	<ul>
            	<li>
                	<a href="order.html" class="order"></a>
                    <a href="list.html" class="driver" ></a>
                    <a href="pickup_car.html" class="pickup_car"></a>
                    <a href="car_pay.html" class="car_pay"></a>
                </li>
                <li>
                	<a href="client.html" class="client"></a>
                	<a href="#" class="search"></a>
                    <a href="#" class="statistics"></a>
                   	<a href="CarListAction_findCarList.do?page=1&pageSize=5" class="manage"></a>
                    <a href="新手入门-添加门店.html" class="new_user"></a>
                </li>               
            </ul>
        </div>
    </div>
</div>
<div class="foot">
    <p>版权所有(C)2009-2014 朗思科技</p>
</div>
</div>
</body>
</html>
