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
    
    <title>员工界面</title>
</head>

<c:if test="${empty employee.username}">
	<c:redirect url="login.jsp"></c:redirect>
	
</c:if>

<body class="layui-layout-body" style="background-color:#D9FFF8;;">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header" style="text-align: right;">    
            <ul class="layui-nav">
        
                <li class="layui-nav-item">
                    <a href="">个人中心<span class="layui-badge-dot"></span></a>
                </li>
              
        
                <li class="layui-nav-item">
                	<c:set var="e" value="${sessionScope.employee}"></c:set>
                    <a href="upLoadImage.jsp"><img src="${e.imgUrl}" class="layui-nav-img">欢迎,${e.username}</a>
                    <dl class="layui-nav-child">
                      <dd><a href="modifyInfo.jsp">修改信息</a></dd>
                      <dd><a href="javascript:;">安全管理</a></dd>
                      <dd><a href="login.jsp">我要退啦</a></dd>
                    </dl>
                  </li>
        
            </ul>
        </div>

        <div class="layui-side">
            <ul class="layui-nav layui-nav-tree layui-nav-side" layui-filter="test" style="margin-top:60px;">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">默认展开</a>
                    <dl class="layui-nav-child">
                        <dd><a href="toSalary">查看工资单</a></dd>
                        <dd><a href="javascript:;">查看通知</a></dd>
                        <dd><a href="javascript:;">查看任务</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">部门消息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">团建活动</a></dd>
                        <dd><a href="javascript:;">任务更改</a></dd>
                        <dd><a href="javascript:;">职位调动</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:;">能力评估</a></li>
            </ul>
        </div>

        <div class="layui-body">
            <div style="text-align:center;">

            <div style="width: 500px;height: 100%; font-size: 16px;font-style:italic;">
                <span style="margin-left: 30px;">以下是你的个人基本信息:</span>
                <div class="layui-form layui-form-pane" style="margin-top: 20px;">
                    <div class="layui-container" style="width: 500px;">

                        <div class="layui-form-item">
                
                            <label for="" class="layui-form-label">姓名：</label>
                            <div class="layui-input-block">
                              
                                <input class="layui-input " type="text" value="${employee.username}">
                            </div>
                        </div>
                
                        <div class="layui-form-item">
                
                            <label for="" class="layui-form-label">密码：</label>
                            <div class="layui-input-block">
                              
                                <input class="layui-input" type="text" value="${employee.password}">
                            </div>
                        </div>
                
                        <div class="layui-form-item">
                
                            <label for="" class="layui-form-label">年龄：</label>
                            <div class="layui-input-block">
                              
                                <input class="layui-input " type="text" value="${employee.age}">
                            </div>
                        </div>
                
                        <div class="layui-form-item">
                
                            <label for="" class="layui-form-label">性别：</label>
                            <div class="layui-input-block">
                              
                                <input class="layui-input" type="text" value="${employee.sex}">
                            </div>
                        </div>

                        
                        <div class="layui-form-item">
                
                            <label for="" class="layui-form-label">邮箱：</label>
                            <div class="layui-input-block">
                              
                                <input class="layui-input " type="text" value="${employee.email}">
                            </div>
                        </div>
                        
                        <div class="layui-form-item">
                
                            <label for="" class="layui-form-label">电话号码：</label>
                            <div class="layui-input-block">
                              
                                <input class="layui-input " type="text" value="${employee.phone}">
                            </div>
                        </div>
                </div>
                </div>
                 
        </div>

        <div class="layui-footer">
                <!-- 底部固定区域 -->
                © LL.M.com 这是属于你的个人空间
 
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
<script type="text/javascript" src="js/layui.all.js"></script>