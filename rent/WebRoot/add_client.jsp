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
                  <li class="active"><a href="" class="client_one"></a></li>
                  <li><a href="#" class="search_one"></a></li>
                  <li><a href="#" class="statistics_one"></a></li>
                  <li><a href="car_base_infor.html" class="manage_one"></a></li>
                  <li><a href="新手入门-添加门店.html" class="new_user_one"></a></li>                 
             </ul>
        </div>
        <div class="user_infor">
        	<span class="uesr_name">欢迎您！小王 </span>
           <span>租车管理系统</span>          
        </div>
    	 <div class="clr"></div>
    </div>
    <div class="base_content">
    	<div class="car_pay_content" style=" border: none;">
        	<div class="car_dynamic_option">
            	<div class="user_infor_right">
                	<div class="user_dest_top">
                    	<div class="dest_top_one"></div>
                        <div class="dest_top_two">
                       		<h1>新增企业客户</h1>
                        </div>
                        <div class="dest_top_three"></div>
                        <div class="clr"></div> 
                    </div><!--user_dest_top-->
                    
                    <div class="user_dest_content">
                          <ul>
						  	<li>
								<label>助记符：</label>
								<input type="text" />
							</li>
							<li>
								<label>来源渠道：</label>
								<input type="text" />
							</li>
						  	<li>
								<label>企业名称：</label>
								<input type="text" />
							</li>
							<li>
								<label>英文名称：</label>
								<input type="text" />
							</li>
							<li>
								<label>联系电话：</label>
								<input type="text" />
							</li>
							<li>
								<label>企业传真：</label>
								<input type="text" />
							</li>
							<li>
								<label>企业网址：</label>
								<input type="text" />
							</li>
							<li>
								<label>电子邮件：</label>
								<input type="text" />
							</li>
							<li>
								<label>企业地址：</label>
								<input type="text" />
							</li>
							<li>
								<label>建立日期：</label>
								<input type="text" />
							</li>
							<li>
								<label>状态：</label>
								<input type="text" />
							</li>
							<div class="clr"></div>
						  </ul>                                
                                
						 <div class="laye_form_botton">
							<div class="save_button">
								  <span class="input_left"></span>
								  <a><input type="submit" value=" 保存 " /></a>
								  <span class="input_right"></span>
							  </div>
							  <div class="cancel_button">
								  <span class="input_left"></span>
								  <a><input type="button" value="取消"/ ></a>
								  <span class="input_right"></span>
							  </div>
					 	</div><!--laye_form_botton-->
                  </div><!--user_dest_content-->
                         
                         
                	<div class="user_dest_bottom">
                    	<div class="dest_bottom_le"></div>
                    	<div class="dest_bottom_ce"></div>
                        <div class="dest_bottom_ri"></div>
                         <div class="clr"></div> 
                    </div>
                </div> 	<!--user_infor_right-->
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
</div>
<div class="foot">
   <p>版权所有(C)2009-2014 朗思科技</p>
</div>
</body>
</html>
