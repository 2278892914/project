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
	  var alist = document.querySelectorAll("td a[state]");
	  for(var i=0;i<alist.length;i++){
		  alist[i].onclick = function(){
			  var state = this.getAttribute("state");
			  var sname = "";
			  var pname = "";
			  if(state == 0){
					pname = "在售";
					sname = "下架";
					state = 1;//上架状态
				}else if(state == 1){
					pname="未上架";
					sname="重新上架"
					state = 0;
				}else if(state == 2){
					pname="在售";
					sname="下架"
					state = 1;
				}
			  var sid = this.id;
			  var thiz = this;
			  var httpRequest = new XMLHttpRequest();
			  httpRequest.onreadystatechange = function() {
				if(httpRequest.status==200&&httpRequest.readyState==4){
					var msg = httpRequest.responseText;
					if(msg == "SUCCESS"){
						thiz.innerText = sname;
						thiz.setAttribute("state",state);
						thiz.previousElementSibling.innerText = pname;
						
					}
				}
			}
			  
			  httpRequest.open("POST","sa_updateShopState.action",true);
			  httpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			  httpRequest.send("sp.state="+state+"&sp.id="+sid);
			  
			  
		  }
	  }
	  
	  
  }


</script>
<body>
    <div class="main_right_top">您现在所在位置 > <span>商品列表</span><a href="login.action" style="margin-right;color: red">后台主页</a></div>
    <div class="main_right_body">
    <div class="body_content"> 
        <div class="biao_list">
            <div class="set_all">
            	<div class="search_one">
					<label>商品编号：</label>
					<input type="text" />
				</div>
				<div class="search_one">
					<label>商品名称：</label>
					<input type="text" />
				</div>
				<div class="search_one">
					<label>状态：</label>
					<select >
						<option>全部</option>
						<option>未上架</option>
						<option>上架</option>
						<option>未开售</option>
					</select>
				</div>
				<!-- <div class="search_one">
					<label>时间：</label>
					<input type="text" />
				</div> -->
				
				<a class="search_btn">查询</a>
                <a href="add_commodity.action" class="set_btn_link">添加商品</a>
            </div><!--set_all-->
            <table border="0" cellspacing="0" cellpadding="0">
                <thead>
                    <tr>
                        <th>ID</th>
						<th>商品名称</th>
						<th>价格</th>
						<th>状态</th>
						<th>操作</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${listsp }" var="list">
                    <tr>
							<td>${list.id }</td>
							<td>${list.name }</td>
							<td>
								${list.price }
							</td>
							    <c:if test="${list.state==0 }">
							    <td>
							    <span>未上架</span>
								<a href="#" class="td_edit" state=${list.state } id=${list.id }>重新上架</a>
								</td>
								</c:if>
								<c:if test="${list.state==1 }" >
								<td>
								<span>在售</span>
								<a href="#" class="td_edit" state=${list.state } id=${list.id }>下架</a>
								</td>
								</c:if>
								<c:if test="${list.state==2 }">
								<td>
								<span>未开售</span>
								<a href="#" class="td_edit" state=${list.state } id=${list.id }>上架</a>
								</td>
								</c:if>
							
							<td>
								<a href="commodity_info.action?id=${list.id }"  class="td_detail">详情</a>
                                <a href="update_commodity_info.action?id=${list.id }" class="td_edit">修改</a>
                                <a href="delete_commodity_info.action?id=${list.id }" class="td_detele">删除</a>
                            </td>
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
