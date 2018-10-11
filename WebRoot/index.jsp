<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>失物招领</title>
  </head>
  
  <body>
    <form action="uploads.action" method="post" enctype="multipart/form-data" >
    文件：<input type="file" name="uploadImage">
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
