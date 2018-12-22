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
		<div class="main_right_top">您现在所在位置 > <span>商品信息</span><a href="login.action" style="margin-right;color: red">后台主页</a></div>
		<div class="main_right_body"> 
        <div class="body_content">
        	<div class="detail_page">
				<div class="detail_set_all">
					<h1 class="biao_title">商品信息</h1>
					<a class="return_link" href="commodity_list.action">返回</a>
				</div><!--set_all-->
				<ul class="detail_page_list">
				<c:forEach items="${listsp }" var="list">
					<li>
						<label>商品名称：</label>
						<span class="detail_name">${list.name}</span>	
						
					</li>
					<li>
						<label>商品描述：</label>
						<span class="detail_name">${list.descript }</span>	
					</li>
					<li>
						<label>当前状态：</label>
						<c:if test="${list.state==2 }">
						<span class="detail_name">未开售</span>	
						</c:if>
						<c:if test="${list.state==1 }">
						<span class="detail_name">在售</span>	
						</c:if>
						<c:if test="${list.state==0 }">
						<span class="detail_name">未上架</span>	
						</c:if>
						
					</li>
					<li>
						<label>所属分类：</label>
						<span class="detail_name">
							<select>
								<option>${list.pname }</option>		
							</select>
						</span>
						<span class="detail_name">
							<select>
								<option>${list.pcname }</option>		
							</select>
						</span>
					</li>
					<li>
						<label>商品价格：</label>
						<span class="detail_name">${list.price }</span>
					</li>
					<li>
						<label>商品库存：</label>
						<span class="detail_name">${list.num }</span>	
					</li>
					<li>
						<label>商品图片：</label>
						<span class="detail_name">
							<img src="images/sss.jpg"  width="100" height="100"/>
						</span>
						<span class="detail_name">
							<img src="images/sss.jpg" width="100" height="100"/>
						</span>	
						<span class="detail_name">
							<img src="images/sss.jpg" width="100" height="100"/>
						</span>	
					</li>
					<li>
						<label>商品详情：</label>
						
						<div style="float: right;text-align: center;width: 70%;">
							<!-- <img src="images/mm1.jpeg" />
							<img src="images/mm1.jpeg" />
							<img src="images/mm1.jpeg" /> 
							<img src="images/123.jpg" /> -->
							${list.spinfo }
						</div>
						
							
					</li>
				</c:forEach>
				</ul>
				
			</div><!--detail_page-->
       </div>	
	</div> <!--main_right_body-->
	
</body>
</html>
