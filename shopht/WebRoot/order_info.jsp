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
		<div class="main_right_top">您现在所在位置 > <span>订单详情</span><a href="login.action" style="margin-right;color: red">后台主页</a></div>
		<div class="main_right_body"> 
        <div class="body_content">
        	<div class="detail_page">
				<div class="detail_set_all">
					<h1 class="biao_title">订单详情</h1>
					<a class="return_link">返回</a>
				</div><!--set_all-->
				<ul class="detail_page_list">
				<c:forEach items="${orderlist1 }" var="list">
					<li>
						<label>订单编号：</label>
						<span class="detail_name">${list.ordernum }</span>	
					</li>
					<li>
						<label>创建时间：</label>
						<span class="detail_name">${list.createtime }</span>	
					</li>
					<li>
						<label>收件人地址：</label>
						<span class="detail_name">${list.address }</span>	
					</li>
					<li>
						<label>收件人：</label>
						<span class="detail_name">${list.username }</span>	
					</li>
					<li>
						<label>订单状态：</label>
						<c:if test="${list.goodstate==0 }">
						<span class="detail_name without_tension">
							未发货
						</span>
						<a class="search_btn" style="margin-left: 20px;" href="delete_order.action?id=${list.id }">删除订单</a>
						<a class="search_btn" style="margin-left: 20px;" href="sendgoods.action?id=${list.id }">立即发货</a>
						</c:if>
						<c:if test="${list.goodstate==1 }">
						<span class="detail_name without_tension">
							已发货
						</span>
						<a class="search_btn" style="margin-left: 20px;" href="delete_order.action?id=${list.id }">删除订单</a>
						</c:if>
						
					</li>
					<li>
						<label>支付方式：</label>
						<c:if test="${list.paytype==0 }">
						<span class="detail_name">在线付款</span>	
						</c:if>
						<c:if test="${list.paytype==1 }">
						<span class="detail_name">货到付款</span>	
						</c:if>
					</li>
					<li>
						<label>订单金额：</label>
						<span class="detail_name">${list.totalprice }</span>	
					</li>
					</c:forEach>
				</ul>
			</div><!--detail_page-->
			 <table border="1" cellspacing="0" cellpadding="0">
                <thead>
                    <tr>
                        <th>商品图片</th>
						<th>商品信息</th>
						<th>单价</th>
						<th>数量</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${orderlist2 }" var="list">
                    <tr>
							<td><img src="images/mm1.jpeg" width="100" height="100"></td>
							<td>${list.name }  ${list.descript }</td>
							<td><span class="warning_number">${list.price }</span></td>
							<td>
								${list.sp_num }
							</td>
						</tr>
				</c:forEach>		
                </tbody>
            </table>
       </div>	
	</div> <!--main_right_body-->
	
</body>
</html>
