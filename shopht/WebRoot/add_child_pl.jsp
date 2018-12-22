<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="css/base.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">

	$(function() {
		$('#a_add').click(function() {
			var clist = $('#d_add').children();
			if(clist>=5){
				alert("一次最多添加五个品类");
				return false;
			}
			var html = "<ul class="dele_ul" >"
				+"<li><label>子品类名称：</label>"
				+"<input type="text" name="zplvo.list"/></li>"
				+"<div class="clr"></div>"
				+"<a class="detele_upload"></a></ul>"; 
			$('#d_add').append(html);
			var u = $('#d_add ul').last();
			var a = u.find('a[class=delete_upload]');
			a.click(function(){
				$(this).parent.remove();
			});
		})
	})

</script>













<!-- <script type="text/javascript">
	window.onload = function(){
		
		var s = window.location.search;//字符串类型
		
		s = s.substring(s.indexOf("=")+1);
		
		var a1 = document.getElementById("addC");
		var d_addC = document.getElementById("d_addC");
		var k = 0;
		a1.onclick = function(){
			d_addC.innerHTML += '<ul class="dele_ul" >'
								+'<li><label>子品类名称：</label>'
								+'<input type="text" name="zplvo.list"/></li>'
    							+'<div class="clr"></div>'
								+'<a class="detele_upload"></a></ul>'; 
			
								k++;
			var aList = document.querySelectorAll('.detele_upload');
			for(var i=0;i<aList.length;i++){
				aList[i].onclick = function(){
					d_addC.removeChild(this.parentNode);
				}
			}
								
		}
	}
</script> -->
</head>

<body>
	<div class="main_right_top">
		您现在所在位置 > <a>添加子品类信息</a> > <a href="login.action" style="margin-right;color: red">后台主页</a>
	</div>
	<div class="main_right_body">
		<div class="body_content">
			<div class="bridge_fome_all">
				<form action="add_zpl_sure.action" method="post">
				
				<div class="bridge_fome">
					<div class="bridge_fome_one">
						<div class="base_infor">
							<div class="set_all">
								<h1 class="biao_title">子品类信息</h1>
								<a href="#" class="set_btn_link" id="addC">添加子品类名称</a>
							
							</div>
							<!--set_all-->
						</div>
						<!--base_infor-->
							<div class="bridge_add_index"
								style="width: 800px; margin: 0px auto;" id="d_addC">
								<input type="hidden" name="id" value="${id }"/>
							</div>
							<!--bridge_add_index-->
					</div>
					<!--bridge_fome_one-->
					<div class="regist_btn">
						<input type="submit" value="保存" /> <a class="return_btn">取消</a>
					</div>
				</div>
				</form>
				<!--bridge_fome-->

			</div>
			<!--bridge_fome_all-->
		</div>
		<!--body_content-->
	</div>
	<!--main_right_body-->
</body>
</html>
