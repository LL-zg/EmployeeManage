<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="stylesheet" href="layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="layui/css/modules/code.css" >
    <link rel="stylesheet" href="layui/css/modules/layer/default/layer.css">
    
    <title>工资单</title>
</head>


<body class="layui-layout-body" style="background-color:#8CD790;text-align:center;">
		<div style="height:100%;width:500px;background-color:#AAFCB8;margin:auto;"">
			<div style="width: 400px;height: 100%; font-size: 13px;background-color:#D7FFF1;font-style:italic;margin:auto;margin-top:30px;">
                <span>这是你的工资单:</span>
                <div class="layui-form layui-form-pane" style="margin-top: 20px;">
                    <div class="layui-container" style="width: 300px;">

                        <div class="layui-form-item">
                
                            <label for="" class="layui-form-label">基本工资：</label>
                            <div class="layui-input-block">
                              
                                <input class="layui-input " type="text" value="${salary.basePay}">
                            </div>
                        </div>
                
                        <div class="layui-form-item">
                
                            <label for="" class="layui-form-label">津贴：</label>
                            <div class="layui-input-block">
                              
                                <input class="layui-input" type="text" value="${salary.subsidy}">
                            </div>
                        </div>
                
                        <div class="layui-form-item">
                
                            <label for="" class="layui-form-label">公积金：</label>
                            <div class="layui-input-block">
                              
                                <input class="layui-input " type="text" value="${salary.acFuncd}">
                            </div>
                        </div>
                
                        <div class="layui-form-item">
                
                            <label for="" class="layui-form-label">保险费：</label>
                            <div class="layui-input-block">
                              
                                <input class="layui-input" type="text" value="${salary.socialSec}">
                            </div>
                        </div>

                        
                        <div class="layui-form-item">
                
                            <label for="" class="layui-form-label">水电杂费：</label>
                            <div class="layui-input-block">
                              
                                <input class="layui-input " type="text" value="${salary.misc}">
                            </div>
                        </div>
                        
                </div>
                
                <div>
                	<a href="index.jsp">
                		<button class="layui-btn">返回</button>
                	</a>
                </div>
		
		</div>

            

    
</body>
</html>
<script type="text/javascript" src="js/layui.all.js"></script>