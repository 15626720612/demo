<%@page import="com.sun.org.apache.bcel.internal.generic.LASTORE"%>
<%@page import="test.ImageDao"%>
<%@page import="java.util.List"%>
<%@page import="test.Image"%>
<%@page import="action.UploadAction"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	UploadAction upAction = new UploadAction();
	ImageDao dao = new ImageDao();
	List<Image> imgs = dao.query();
	System.out.println(imgs.get(imgs.size()-1).getUrl());
 %>
<body>
	成功页面!
	<!-- <img src="upload/red.jpg"> -->
	<img src="<%=imgs.get(imgs.size()-1).getUrl()%>">
</body>
</html>