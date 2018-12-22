<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="css/base.css" type="text/css" />
<script type="text/javascript">
	window.onload = function(){
	var upage = document.getElementById("upage");
	var totalPage = '${totalpage}';
	//当前页码
	var page = '${page}';
	var html = "<li>"+
	"<a href='plist.action?page=1&pageSize=3'><span class='arrow_left'></span></a>";
	for(var i =1;i<=totalPage;i++){
	//如果是等于就是将所在的页码颜色加深
 	   if(i == page){
 		   html += "<li class='page_active'><a  href='plist.action?page="+i+"&pageSize=4'>"+i+"</a></li>";
 	   }else{
 		   html += "<li><a href='plist.action?page="+i+"&pageSize=4'>"+i+"</a></li>";
 	   }
 	  
    } 			
     html +=" <li><a href='plist.action?page="+(totalPage)+"&pageSize=4'><span class='arrow_right'></span></a></li>";
		upage.innerHTML = html;

}

</script>
    
</head>

<body>
    <div class="main_right_top">您现在所在位置 > <span>品类管理</span><a href="login.action" style="margin-right;color: red">后台主页</a></div>
    <div class="main_right_body">
    <div class="body_content"> 
        <div class="biao_list">
            <div class="set_all">
                <h1 class="biao_title">品类管理</h1>
                <a href="add_pl.jsp" class="set_btn_link">添加品类</a>
            </div><!--set_all-->
            <table border="0" cellspacing="0" cellpadding="0">
                <thead>
                    <tr>
                        <th>品类ID</th>
						<th>品类名称</th>
						<th>操作</th>
                    </tr>
                </thead>
                <tbody>
                      <c:forEach items="${list }" var="list">
                    	<tr>
							<td>${list.id }</td>
							<td>${list.pname }</td>
							<td>
								<a href="look_zpl.action?id=${list.id }"  class="td_detail">查看</a>
								<a href="update_pl.action?id=${list.id }" class="td_edit">修改</a>
                                <a href="delete_pl.action?id=${list.id }" class="td_detele">删除</a>
							</td>
						</tr>
						</c:forEach>
                </tbody>
            </table>
            <div class="page_all">
                <div class="page">
                    <ul id="upage">
                        <!-- <li>
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
                        <div class="clr"></div> -->
                    </ul>
                </div>
                <div class="clr"></div>
            </div><!--page_all-->
            
        </div><!--biao_list-->
        </div>
    </div> <!--main_right_body-->
</body>
</html>
