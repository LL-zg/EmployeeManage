<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加新部门</title>
    
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
    <div class="container">
        
        <form class="layui-form layui-form-pane" action="saveDepartment" method="post" enctype="multipart/form-data">
                <div class="layui-form-item">
                    <label class="layui-form-label">部门名称:</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input" name="dname" required >
                    </div>
                </div>
                
            
                <div class="layui-form-item">                     
                    <label for="" class="layui-form-label">部门经理:</label>
                    <div class="layui-input-block">      
                        <input class="layui-input " type="text" name="dmanger">
                    </div>
                </div>
        
                <div class="layui-form-item">
                    <label for="" class="layui-form-label">部门人数:</label>
                    <div class="layui-input-block">
                        <input class="layui-input" type="text" name="dnumber">
                    </div>
                </div>
        
                
                <div class="layui-form-item">
        
                    <label for="" class="layui-form-label">部门介绍:</label>
                    <div class="layui-input-block">
                        
                        <input class="layui-input " type="text" name="ddesc">
                    </div>
                </div>
                
                
                <div>
                    <input class="sub" type="submit" value="提交"> 
               
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

