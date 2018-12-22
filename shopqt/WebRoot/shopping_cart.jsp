<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link type="text/css" rel="stylesheet" href="css/commons.css"/>
		<link type="text/css" rel="stylesheet" href="css/shop.css" />
	</head>
	<body>
		<div class="nav">
			<div class="n_warp">
				<div class="n_w_left">
					<a href="#">登录</a>
					<a href="#">注册</a>
					<span>欢迎，小胖墩</span>
					<a href="#">退出</a>
				</div>
				<div class="n_w_right">
					<a href="#" class="shopping">购物车(0)</a>
					<a href="#" class="order">我的订单</a>
					<a href="#" class="my">我的MALL</a>
					<a href="#" class="about">关于MALL</a>
				</div>
			</div>
		</div>
		<div class="header">
			<div class="h_left">
				<a href="#">YSMALL</a>
			</div>
			<div class="h_right">
				<input type="text" /><button>搜索</button>
			</div>
		</div>
		
		<div class="s1">
				<div>
					<a href="#">MMall</a><span>&gt;</span> <a href="#" >商品列表</a>
				</div>
		</div>
		<div class="cart_one">
			<table border="0" cellpadding="0" cellspacing="0">
				<thead>
					<tr class="h_one">
						<th><input type="checkbox"/>全选</th>
						<th colspan="2">商品信息</th>
						<th>单价</th>
						<th>数量</th>
						<th>合计</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr class="h_two">
						<td><input type="checkbox"/></td>
						<td >
							<img src="img/m1.jpeg" style="height: 82px;width: 82px;"/>
						</td>
						<td>
							<a href="#">Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用</a>
						</td>
						<td>￥3299</td>
						<td>
							<span>-</span>
							<input type="text" />
							<span>+</span>
						</td>
						<td class="h_f">￥3299</td>
						<td><a href="#">删除</a></td>
					</tr>
					<tr class="h_two">
						<td><input type="checkbox"/></td>
						<td >
							<img src="img/m1.jpeg" style="height: 82px;width: 82px;"/>
						</td>
						<td>
							<a href="#">Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用</a>
						</td>
						<td>￥3299</td>
						<td>
							<span>-</span>
							<input type="text" />
							<span>+</span>
						</td>
						<td class="h_f">￥3299</td>
						<td><a href="#">删除</a></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td><input type="checkbox">全选</td>
						<td colspan="4"><a href="#">删除选中</a></td>
						<td>总价:<span>￥3299</span></td>
						<td class="h_d"><a href="#">去结算</a></td>
					</tr>
				</tfoot>
			</table>
		</div>
		
		
		<div class="footer">
			<span>@西安云思信息技术有限公司</span>
		</div>
	</body>
</html>
