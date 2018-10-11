<%@page import="com.found.FoundGoods"%>
<%@page import="com.found.FoundGoodsDao"%>
<%@page import="java.util.List"%>
<%@page import="com.lost.LostGoods"%>
<%@page import="com.lost.LostGoodsDao"%>
<%@page import="action.UploadAction"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<!-- easyui -->
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/color.css">

<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/jquery.slideBox.css" rel="stylesheet" type="text/css" />

<!-- Bootstrap -->
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<script src="js/scrollReveal.js"></script>
<script src="js/jquery-1.7.1.min.js"></script>
<script src="js/jquery.slideBox.js"></script>
<script src="js/myjquery.js"></script>
</head>
<body>
<body class="easyui-layout">

	<!-- 头部 -->
	<div data-options="region:'north'" style="height:100px;"></div>

	<!-- 左侧：寻物启事 -->
	<div data-options="region:'west',title:'寻物启事',iconCls:'icon-reload'"
		style="width:50%;">
		<%
			FoundGoodsDao fdao = new FoundGoodsDao();
			List<FoundGoods> foundGoodss = fdao.query();
		%>
		<c:forEach items="<%=foundGoodss %>" var="foundGoods" begin="0">
			<div style="padding: 5px;">
				<ul style="padding: 5px;background: pink;">
					物品名称：
					<span>${foundGoods.goodsName }</span>
					<br> 类型：
					<span>${foundGoods.goodsCategory }</span>
					<br> 遗失时间：
					<span>${foundGoods.lostTime }</span>
					<br> 遗失地址：
					<span>${foundGoods.lostAddress }</span>
					<br> 联系人：
					<span>${foundGoods.userName }</span>
					<br> 联系方式：
					<span>${foundGoods.userNumber }</span>
					<br> 补充：
					<span>${foundGoods.goodsDetails }</span>
					<img src="${foundGoods.goodsImgUrl }" style="width: 100px">
				</ul>
			</div>
		</c:forEach>
		
		</div>

	<!-- 右侧：失物招领 -->
	<div data-options="region:'east',title:'失物招领',iconCls:'icon-reload'"
		style="width:50%;">
		<%
			LostGoodsDao ldao = new LostGoodsDao();
			List<LostGoods> lostGoodss = ldao.query();
		%>
		<c:forEach items="<%=lostGoodss %>" var="lostGoods" begin="0">
			<div style="padding: 5px;">
				<ul style="padding: 5px;background: pink;">
					物品名称：
					<span>${lostGoods.goodsName }</span>
					<br> 类型：
					<span>${lostGoods.goodsCategory }</span>
					<br> 拾到时间：
					<span>${lostGoods.foundTime }</span>
					<br> 拾到地址：
					<span>${lostGoods.foundAddress }</span>
					<br> 联系人：
					<span>${lostGoods.userName }</span>
					<br> 联系方式：
					<span>${lostGoods.userNumber }</span>
					<br> 补充：
					<span>${lostGoods.goodsDetails }</span>
					<img src="${lostGoods.goodsImageUrl }" style="width: 100px">
				</ul>
			</div>
		</c:forEach>
	</div>
</body>
</body>