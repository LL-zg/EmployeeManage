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
  
  <body>
    <h1>输入你的更改信息</h1>
    <div class="container">
        
        <form class="layui-form layui-form-pane" action="modifyEmployee" method="post" enctype="multipart/form-data">
                <div class="layui-form-item">
                	<input type="hidden" name="id" value="${sessionScope.employee.id}">
                    <label class="layui-form-label">用户名：</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input" name="username" required placeholder="输入更改用户名" autocomplete="off">
                    </div>
                </div>
                
                <div class="layui-form-item">
                    <label class="layui-form-label">密码：</label>
                    <div class="layui-input-block">
                        <input type="password" class="layui-input" name ="password"  required placeholder="输入更改密码" >
                    </div>
                </div>
            
                <div class="layui-form-item">                     
                    <label for="" class="layui-form-label">年龄：</label>
                    <div class="layui-input-block">      
                        <input class="layui-input " type="text" name="age">
                    </div>
                </div>
        
                <div class="layui-form-item">
                    <label for="" class="layui-form-label">性别：</label>
                    <div class="layui-input-block">
                        <input class="layui-input" type="text" name="sex">
                    </div>
                </div>
        
<!--                 <div class="layui-form-item">
        
                    <label for="" class="layui-form-label">所属部门：</label>
                    <div class="layui-input-block">
                        
                        <input class="layui-input" type="text" name="did">
                    </div>
                </div> -->
                
                <div class="layui-form-item">
        
                    <label for="" class="layui-form-label">邮箱：</label>
                    <div class="layui-input-block">
                        
                        <input class="layui-input " type="text" name="email">
                    </div>
                </div>
                
                <div class="layui-form-item">
        
                    <label for="" class="layui-form-label">电话号码：</label>
                    <div class="layui-input-block"> 
                        <input class="layui-input " type="text" name="phone">
                    </div>
                </div>
                
                <div>
                    <input class="sub" type="submit" value="确认更改"> 
                   <a href="login.jsp"> <input class="sub" type="button" value="还是算了">  </a>             
                </div>
        </form>
    </div>
    
    <script type="text/javascript" src="layui/layui.js"></script>
    <script>
//一般直接写在一个js文件中
    layui.use('layer', function() {
    	var layer=layui.layer;
    	layer.msg('Hello!');
    });
	</script>
    
  </body>

</html>

