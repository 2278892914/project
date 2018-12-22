<%@page import="yst.CarVO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div class="view_all">
    <div class="head" >
    	<div class="logo">
        	<a href=""><img src="images/home_logo.png" /></a>
        </div>
        <div class="menu"> 
              <ul>
                  <li><a href="order.html" class="order_one"></a></li>
                  <li><a href="collocation_car_driver.html" class="driver_one"></a></li>
                  <li><a href="pickup_car.html" class="pickup_car_one"></a></li>
                  <li><a href="car_pay.html" class="car_pay"></a></li>
                  <li><a href="client.html" class="client_one"></a></li>
                  <li><a href="#" class="search_one"></a></li>
                  <li><a href="#" class="statistics_one"></a></li>
                  <li class="active"><a href="car_base_infor.html" class="manage_one"></a></li>
                  <li><a href="新手入门-添加门店.html" class="new_user_one"></a></li>
                 
             </ul>
        </div>
        <div class="user_infor">
        	<span class="uesr_name">欢迎您！${userName } </span>
          	 <span>租车管理系统</span>            
        </div>
    	 <div class="clr"></div>
    </div>
    <div class="base_content">
    	<div class="car_pay_content">
        <div class="car_pay_bottom">
        	<div class="tab_top">
                <div class="tab_top_left"></div>
                <div class="tab_top_center"></div>
                <div class="tab_top_right"></div>
                <div class="clr"></div>
            </div>
            <div class="tab_cen_all">
                <h1 style=" float:left;">车辆信息</h1>
                <div class="client_new_botton">
                    <div class="edit_button">
                        <span class="input_left"></span>
                        <a href="ShowCarAction_ShowCar.do">添加</a>
                        <span class="input_right"></span>
                    </div>
                </div>
                <div class="clr"></div>
            </div> 
           <table class="table table-striped">
                  <thead>
                    <tr>
                      <th>编号</th>
                      <th>车辆型号</th>
                      <th>大陆牌照</th>
                      <th>香港牌照</th>
                      <th>所属门店</th>
                      <th>操作</th>
                    </tr>
                  </thead>
                  <tbody>
                 <c:forEach items="${listCar }" var = "car">
                 <!-- status.index表示的是输出的行号 -->
                 <c:if test="${status.index%2==0 }">
                      <tr>
                        <td><a href="/cars/20">${car.id }</a></td>
                        <td>${car.bname }/${car.tname }</td>
                        <td>${car.land_sign }</td>
                        <td>${car.hk_sign }</td>
                        <td>${car.sname }</td>
                        <td class="graphics_layer">
                        	<ul class="laye_text_botton">
                                <li>
                                    <div class="edit_button">
                                        <span class="input_left"></span>
                                        <a href="">编辑</a>
                                        <span class="input_right"></span>
                                    </div>
                                </li>
                                <li>
                                     <div class="delete_button">
                                          <span class="input_left"></span>
                                          <a href="">删除</a>
                                          <span class="input_right"></span>
                                      </div>
                                </li>
                            </ul>
                        </td>
                      </tr>
                     </c:if>
                    <c:if test="${status.index%2!=0 }">
                      <tr>
                        <td class="first_one"><a href="/cars/21">${car.id }</a></td>
                        <td class="first_one">${car.bname }/${car.tname }</td>
                        <td class="first_one">${car.land_sign }</td>
                        <td class="first_one">${car.hk_sign }</td>
                        <td class="first_one">${car.sname }</td>
                        <td class=" first_one graphics_layer">
                        	<ul class="laye_text_botton">
                                <li>
                                    <div class="edit_button">
                                        <span class="input_left"></span>
                                        <a href="">编辑</a>
                                        <span class="input_right"></span>
                                    </div>
                                </li>
                                <li>
                                     <div class="delete_button">
                                          <span class="input_left"></span>
                                          <a href="">删除</a>
                                          <span class="input_right"></span>
                                      </div>
                                </li>
                            </ul>
                        </td>
                      </tr>
                      </c:if>
                      </c:forEach>
                  </tbody>
                </table>
				<%
				String p = request.getParameter("page");
				Integer totalPage = (Integer)request.getAttribute("totalPage");
				%>
				
				<div class="page_all">
					<div class="pages">
						<a href="CarListAction_findCarList.do?page=1&pageSize=5">首 页</a>
						<a href="CarListAction_findCarList.do?page=<%=Integer.parseInt(p)-1 < 1 ? 1 : Integer.parseInt(p)-1 %>&pageSize=5">上一页</a>
						<a href="CarListAction_findCarList.do?page=<%=Integer.parseInt(p)+1 > totalPage ? totalPage:Integer.parseInt(p)+1 %>&pageSize=5">下一页</a>
						<a href="CarListAction_findCarList.do?page=<%=totalPage %>&pageSize=5">末 页</a>
						<input type="text" />
						<a href="#">GO</a>			
					</div>
					<div class="clr"></div>
				</div><!--page_all-->
								
            </div>
			
			<div class="user_dest_bottom">
				<div class="dest_bottom_le"></div>
				<div class="dest_bottom_ce"></div>
				<div class="dest_bottom_ri"></div>
				<div class="clr"></div>
			  </div>
        </div>
        <div class="import_information">
        	<ul class="infor_one">
            	<li class="infor_one_text">重要提醒</li>
                <li><a>今日订单数量<span class="red">( 10 )</span></a></li>
                <li><a>今日用车数量<span class="red">( 4 )</span></a></li>
                <li><a>今日还车数量<span class="red">( 20 )</span></a></li>
                <li><a>本月车辆年检提醒<span class="red">( 30 )</span></a></li>
                <li class="infor_month"><a>本月保险到期提醒<span class="red">( 10 )</span></a></li>
                <li class="infor_one_text">常用工具</li>
                <li class="infor_two_text">
                	<a>
                    	<span class="icon_violate" ></span>
                        <span class="icon_text">违章信息查询</span>
                    </a>
                </li>
                 <li class="infor_two_text">
                	<a>
                    	<span class="icon_plain" ></span>
                        <span class="icon_text">航班信息查询</span>
                    </a>
                </li>
                
                 <li class="infor_two_text">
                	<a>
                    	<span class="icon_trail" ></span>
                        <span class="icon_text">列车信息查询</span>
                    </a>
                </li>
                <li class="infor_two_text">
                	<a>
                    	<span class="icon_user" ></span>
                        <span class="icon_text">身份证查询</span>
                    </a>
                </li>
                
                 <li class="infor_two_text">
                	<a>
                    	<span class="icon_gps" ></span>
                        <span class="icon_text">GPS导航</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
     <div class="clr"></div>
</div>
<div class="foot">
  <p>版权所有(C)2009-2014 朗思科技</p>
</div>
</body>
</html>
