<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	
    <link rel="stylesheet" href="./layui/css/layui.css" media="all">

  
    <title>员工界面</title>
</head>

<c:if test="${empty session.Employee.username}">
	<c:redirect url="adminLogin.jsp"></c:redirect>
	
</c:if>

<body class="layui-layout-body" style="background-color:#D9FFF8;">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header" style="text-align: right;">    
                    
           
            <ul class="layui-nav">
                <li class="layui-nav-item">
                    <a href="">控制台<span class="layui-badge">9</span></a>
                </li>
                
                <li class="layui-nav-item">
                    <a><img src="${Employee.imgUrl}" class="layui-nav-img">欢迎,${Employee.username}</a>
                    <dl class="layui-nav-child">
                      <dd><a href="modifyInfo.jsp">修改信息</a></dd>
                      <dd><a href="javascript:;">安全管理</a></dd>
                      <dd><a href="admin/adminLogin.jsp">我要退啦</a></dd>
                    </dl>
                  </li>
             </ul>

        </div>

        <div class="layui-side">
            <ul class="layui-nav layui-nav-tree layui-nav-side" lay-filter="tree" style="margin-top:60px;">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">员工管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="admin/readAllEmployee.jsp" target="iFrame1">员工信息表</a></dd>
                        <dd><a href="admin/readAllSalary.jsp" target="iFrame1">工资清单</a></dd>
                        <dd><a href="javascript:;">员工离职申请表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">部门管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="admin/readAllDepartment.jsp" target="iFrame1">部门基本信息</a></dd>
                        <dd><a href="javascript:;">部门工资汇总表</a></dd>
                        <dd><a href="javascript:;">部门维护信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">信息变更记录</a>
                </li>
            </ul>
        </div>

        <div class="layui-body" style="overflow:hidden;">
        	<div style="background:url('images/logo2.jpg');background-size:100% 100%"> 
        		<iframe name="iFrame1" width="100%" height="100%" frameborder="0"></iframe>
        	
        	</div>
        		
        </div>

        

        <div class="layui-footer">
                <!-- 底部固定区域 -->
                © LL.M.com  管理员专属空间
 
        </div>
        
    </div>
    
    <script>
        layui.use('element', function(){
          var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
          
          //监听导航点击
          element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
          });
          
        });

    </script>

</body>

</html>
<script type="text/javascript" src="layui/layui.all.js"></script>