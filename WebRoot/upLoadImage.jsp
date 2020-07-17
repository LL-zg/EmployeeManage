<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改信息界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
	<link rel="stylesheet" type="text/css" href="style/baseStyle.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align:center;">
  
  	<h1>上传头像</h1>
  	
  	<div class="container">
  		<div>
	        <form class="layui-form" action="uploadImage" method="post" enctype="multipart/form-data">
		 	    <input type="hidden" name="id" value="${employee.id}">
	            <input type="file" class="layui-input" name="file"/>
	            <button type="submit" class="layui-btn" id="test1">
	            	<i class="layui-icon">&#xe67c;</i>上传头像
	            </button>
	            <button type="reset" class="layui-btn">
	            	<i class="layui-icon">&#x1006;</i>取消
	            </button>
		    </form>
    	</div> 
  	</div>
    
  </body>
</html>


