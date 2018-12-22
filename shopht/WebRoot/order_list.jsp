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
<script type="text/javascript">
			window.onload = function(){
				
				var a_login = document.getElementById("a_login");
				a_login.onclick = function(){
					
					var login_form = document.getElementById("login_form");
					login_form.submit();
					
				}
				
				
			}
		</script>

<body>
    <div class="main_right_top">您现在所在位置 > <span>订单列表</span><a href="login.action" style="margin-right;color: red">后台主页</a></div>
    <div class="main_right_body">
    <div class="body_content"> 
        <div class="biao_list">
            <!--set_all-->
            <div class="search_all">
                       <form action="select_order.action" method="post" id="login_form">
						<div class="search_one">
							<label>订单编号：</label>
							<input type="text" name="ordernum"/>
						</div>
						<a class="search_btn" id="a_login">查询</a>
						</form>
					</div><!--search_all-->
            <table border="0" cellspacing="0" cellpadding="0">
                <thead>
                    <tr>
                        <th>订单号</th>
						<th>收件人</th>
						<th>订单状态</th>
						<th>订单总价</th>
						<th>创建时间</th>
						<th>操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${order_list }" var="list">
                
                    <tr>
							<td>${list.ordernum }</td>
							<td>${list.username }</td>
							<c:if test="${list.orderstate==0 }">
							<td><span class="warning_number">已付款</span></td>
							</c:if>
							<c:if test="${list.orderstate==1 }">
							<td><span class="warning_number">未支付</span></td>
							</c:if>
							<td>
								${list.totalprice }
							</td>
							<td>
								${list.createtime }
							</td>
							<td><a href="order_info.action?id=${list.id }"  class="td_detail">查看</a></td>
					</tr>
				</c:forEach>		
                </tbody>
            </table>
            <div class="page_all">
                <div class="page">
                    <ul>
                        <li>
                            <a><span class="arrow_left"></span></a>
                        </li>
                        <li>
                            <a>1</a>
                        </li>
                        <li>
                            <a>2</a>
                        </li>
                        <li class="page_active">
                            <a>3</a>
                        </li>
                        <li>
                            <a>4</a>
                        </li>
                        <li>
                            <a>5</a>
                        </li>
                        <li>
                            <a><span class="arrow_right"></span></a>
                        </li>
                        <div class="clr"></div>
                    </ul>
                </div>
                <div class="clr"></div>
            </div><!--page_all-->
            
        </div><!--biao_list-->
        </div>
    </div> <!--main_right_body-->
</body>
</html>
