<%@page import="yst.TypeVO"%>
<%@page import="yst.StoreVO"%>
<%@page import="java.util.List"%>
<%@page import="yst.BrandVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>租车管理系统</title>
<link href="css/global.css" rel="stylesheet" type="text/css">
<script type = "text/javascript">
window.onload = function(){

	var brand = document.getElementById("brand");
	var type = document.getElementById("type");
	brand.onchange = function(){
	 //window.location.href = "findType.do?id="+this.value;
	 //点击车辆品牌，更新部分信息
	 /*
	 使用Javascript向服务器提出请求并处理响应而不阻塞用户,
	 核心对象XMLHTTPRequest。通过这个对象, JavaScript 
	 可在不重载页面的情况与Web服务器交换数据，即在不需要刷新页面的情况下，就可以产生局部刷新的效果
	 */
	 var httpRequest = new XMLHttpRequest();
	 
	 
	 //准备  初始化  设置请求头 发送
	 //对象准备就绪时候
	 //此时启动一个新的线程
	 httpRequest.onreadystatechange = function(){    //此时启动一个新的线程
		 //         响应已完成                                      并且                           请求成功
		 if(httpRequest.readyState == 4 && httpRequest.status==200){
			 
		 //向ajax后台的程序发送xml http请求的时候, 后台程序接到请求会进行处理,处理结束后,返回一串数据 
			 var  data = httpRequest.responseText;
			 type.innerHTML = "";
			 var obj = JSON.parse(data);//；eval("("+data+")");
			 for(var i=0;i<obj.length;i++){
				 var op = document.createElement("option");
				 op.innerText = obj[i].name;
				 op.value=obj[i].id;  //数据库所需要保存的值
				 type.appendChild(op);//追加的是innerText,既就是jsp页面显示的值，并不是数据库当中保存的值
			 }
		 }
	 }
	 //初始化请求信息              1:请求方法                2:请求的URL       3:true请求异步 false请求同步
	 httpRequest.open("POST","TypeAction_findType.do",false);
	 //当以get方式请求的时候，其将值直接追加至URL后面
	 //httpRequest.open("get","findType.do?id="+this.value,false);   
	 
	 //设置请求头信息，只针对post请求
	 httpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	 //     对象的值
	 //发送请求 this.value的含义是车辆所对应的数字
	 httpRequest.send("id="+this.value);
	 //httpRequest.send("id="+this.value);     
	}
}

</script>
</head>

<body>
<div class="view_all">
    <div class="head" >
    	<div class="logo">
        	<a href=""><img src="images/home_logo.png" /></a>
        </div>
        <div class="menu"> 
              <ul>
                  <li class="active"><a href="order.html" class="order_one"></a></li>
                  <li><a href="collocation_car_driver.html" class="driver_one"></a></li>
                  <li><a href="pickup_car.html" class="pickup_car_one"></a></li>
                  <li><a href="car_pay.html" class="car_pay"></a></li>
                  <li><a href="client.html" class="client_one"></a></li>
                  <li><a href="#" class="search_one"></a></li>
                  <li><a href="#" class="statistics_one"></a></li>
                  <li><a href="car_base_infor.html" class="manage_one"></a></li>
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
    	<div class="car_pay_content" style=" border: none;">
        	<div class="car_dynamic_option">
            	<div class="user_infor_right">
                	<div class="user_dest_top">
                    	<div class="dest_top_one"></div>
                        <div class="dest_top_two">
                       		<h1>添加车辆信息</h1>
                        </div>
                        <div class="dest_top_three"></div>
                        <div class="clr"></div> 
                    </div>
                    <form action = "AddCarAction_addCar.do" method = "post">
                    <div class="user_dest_content">
						<ul>
						  	<li>
								<label><abbr title="required">*</abbr>  车辆品牌：</label>
							<!-- 当触发车辆品牌信息的时候，点击后，执行onload中的方法，自动显示车辆对应的型号 -->
								<select id = "brand" name="brand">
									<c:forEach items="${listBrand }" var="brand">
										<option value="${brand.id }">${brand.name }</option>
									</c:forEach>
								</select>
							</li>
							<li>
								<label><abbr title="required">*</abbr> 车辆型号：</label>
								<select id = "type" name = "type">
									
								</select>
							</li>
							<li>
								<label>大陆牌照：</label>
								<input type="text" name="land_sign"/>
							</li>
							<li>
								<label>香港牌照：</label>
								<input type="text" name="hk_sign"/>
							</li>
							<li>
								<label>颜色：</label>
								<input type="text" name="color"/>
							</li>
							<li>
								<label>所属门店：</label>
								<select name = "store">
									  <c:forEach items="${listStore }" var = "store">
									  
									  <option value= "${store.id }">${store.name }</option>    
									  </c:forEach>
									  
								</select>
							</li>
							
							<div class="clr"></div>
						</ul>
					                                
					  <div class="laye_form_botton">
								<div class="save_button">
									  <span class="input_left"></span>
									  <a><input type="submit" value=" 新增车辆信息 " /></a>
									  <span class="input_right"></span>
								</div>
								<div class="cancel_button">
									<span class="input_left"></span>
									<a><input type="button" value="取消"/ ></a>
									<span class="input_right"></span>
								</div>
						 </div><!--laye_form_botton-->
                  </div><!--user_dest_content-->
                        </form>
                   
                	<div class="user_dest_bottom">
                    	<div class="dest_bottom_le"></div>
                    	<div class="dest_bottom_ce"></div>
                        <div class="dest_bottom_ri"></div>
                         <div class="clr"></div> 
                    </div>
                </div> 	
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
    