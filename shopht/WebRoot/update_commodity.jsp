<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="css/base.css" type="text/css" />
<!-- 配置文件 -->
<script type="text/javascript" src="ue/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="ue/ueditor.all.min.js"></script>
<!-- 实例化编辑器 -->
<script type="text/javascript">
function findPlList(){
	var httpRequest = new XMLHttpRequest();
	var s_pl = document.getElementById("s_pl");
	httpRequest.onreadystatechange = function(){
			if(httpRequest.status == 200 && httpRequest.readyState == 4){
					var obj = eval("("+httpRequest.responseText+")");
					for(var i=0;i<obj.length;i++){
						 var op = document.createElement("option");
						 op.innerText = obj[i].pname;
						 op.value = obj[i].id;
						 s_pl.appendChild(op);
					}
					
			}
	}
	httpRequest.open("POST","sa_findPlList.action",true);
	httpRequest.setRequestHeader("Content-type","application")
	httpRequest.send(null);
	
}
    window.onload = function(){
    	findPlList();
    	var s_pl = document.getElementById("s_pl");
    	s_pl.onchange=function(){
    		var httpRequest = new XMLHttpRequest();
    		var s_zpl = document.getElementById("s_zpl");
    		httpRequest.onreadystatechange = function(){
    			if(httpRequest.status==200&&httpRequest.readyState==4){
    				var obj = eval("("+httpRequest.responseText+")");
    				
    				var data = httpRequest.responseText;
    				s_zpl.innerHTML = "";
    				var obj = JSON.parse(data);
    				for(var i = 0;i<obj.length;i++){
    					var op = document.createElement("option");
    					op.innerText = obj[i].pcname;
    					op.value = obj[i].id;
    					s_zpl.appendChild(op);
    				}
    			}
    		}
    		httpRequest.open("POST","add_sp_zpl.action",true);
    		httpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    		httpRequest.send("id="+this.value);
    	}
    
    	var ue = UE.getEditor('container');
    } 
</script>
</head>

<body>
	<div class="main_right_top">
		您现在所在位置 > <span>添加商品信息</span><a href="login.action" style="margin-right;color: red">后台主页</a>
	</div>
	<div class="main_right_body">
		<div class="body_content">
			<div class="add_xm_all">
				<h1 class="add_xm_top">基本信息</h1>
				<!--add_xm_top-->
				<form action="add_sp_detail.action" method="post">
					<div class="add_xm_form">
						<ul>
							<c:forEach items="${listsp }" var="list">
								<li><label>商品名称：</label> <input type="text" name="sp.name"
									value="${list.name }" /> <span class="error_text"></span></li>
								<li><label>商品描述：</label> <input type="text"
									name="sp.descript" value="${list.descript }" /></li>
								<li><label>当前状态：</label> <select name="sp.state">
										<c:if test="${list.state==2 }">
											<option value="2">未开售</option>
											<option value="1">在售</option>
											<option value="0">未上架</option>
										</c:if>
										<c:if test="${list.state==1 }">
											<option value="1">在售</option>
											<option value="0">未上架</option>
											<option value="2">未开售</option>
										</c:if>
										<c:if test="${list.state==0 }">
											<option value="0">未上架</option>
											<option value="1">在售</option>
											<option value="2">未开售</option>
										</c:if>
								</select></li>
								<li><label>商品价格：</label> <input type="text" name="sp.price"
									value="${list.price }" /></li>
								<li><label>商品库存：</label> <input type="text" name="sp.num"
									value="${list.num }" /></li>
								<li><label>所属分类：</label> <span class="detail_name">
										<select id="s_pl">
											<option value="${list.kind_pl }">${list.pname }</option>
									</select>
								</span> <span class="detail_name"> <select id="s_zpl">
											<option value="${list.kind_zpl }">${list.pcname }</option>
									</select>
								</span></li>
								<li><label>上传图片：</label>
									<div class="upload_music_all">
										<div class="upload_music">
											<a class="upload_music_btn">上传图片</a> <input type="file"
												class="upload_music_file" />
										</div>
										<div class="upload_img">
											<img src="images/user_img.png" /> <a class="detele_upload"
												style="float: left;"></a>
										</div>
										<div class="upload_img">
											<img src="images/user_img.png" /> <a class="detele_upload"
												style="float: left;"></a>
										</div>
										<div class="upload_img">
											<img src="images/user_img.png" /> <a class="detele_upload"
												style="float: left;"></a>
										</div>
										<div class="upload_img">
											<img src="images/user_img.png" /> <a class="detele_upload"
												style="float: left;"></a>
										</div>

									</div>
									<!--upload_music_all--></li>
								<li><label>商品详情：</label> <script id="container"
										name="sp.spinfo" style="float: left;">
                        	${list.spinfo}
												    </script></li>
								<li></li>
							</c:forEach>
						</ul>
						<div class="regist_btn">
							<input type="submit" value="提交" /> <a class="return_btn">返回</a>
						</div>
					</div>
					<!--add_xm_form-->
				</form>
			</div>
			<!--add_xm_all-->
		</div>
	</div>
	<!--main_right_body-->

</body>
</html>
