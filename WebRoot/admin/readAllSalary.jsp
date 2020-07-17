<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
	<base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="./js/jquery-2.1.3.js"></script>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="./js/salaryOption.js"></script>
	
    <link rel="stylesheet" href="./layui/css/layui.css" media="all">

</head>


<body style="background-color:#D9FFF8;">

        
          <div class="layui-container">
		  		<div class="layui-input-inline">
		  			<input type="text" id="username" name="username" class="layui-input">
		  		</div>
		  		
		  		<div class="layui-input-inline">
		  			<button class="layui-btn" data-type="search">查询</button>
		  		</div>	  
		  </div>
        
          <div class="layui-container">
          		<table id="table1" lay-filter="test"></table>
          </div>
          
           
         <!-- 工具类的模板 -->
           
        <script type="text/html" id="barDemo">
          	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>


</body>


</html>

