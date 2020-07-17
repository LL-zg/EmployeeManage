<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加工资单</title>
    
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
        
        <form class="layui-form layui-form-pane" action="addSalary" method="post" enctype="multipart/form-data">
                <div class="layui-form-item">
                    <label class="layui-form-label">基本工资：</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input" name="basePay" required>
                    </div>
                </div>
                
                 <div class="layui-form-item">
                    <label class="layui-form-label">津贴：</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input" name="subsidy" required>
                    </div>
                </div>
                
            
                <div class="layui-form-item">                     
                    <label for="" class="layui-form-label">公积金：</label>
                    <div class="layui-input-block">      
                        <input class="layui-input " type="text" name="acFuncd">
                    </div>
                </div>
        
                <div class="layui-form-item">
                    <label for="" class="layui-form-label">保险费：</label>
                    <div class="layui-input-block">
                        <input class="layui-input" type="text" name="socialSec">
                    </div>
                </div>
        
                
                <div class="layui-form-item">
        
                    <label for="" class="layui-form-label">水电杂费：</label>
                    <div class="layui-input-block">
                        
                        <input class="layui-input " type="text" name="misc">
                    </div>
                </div>
                
                <div class="layui-form-item">
        
                    <label for="" class="layui-form-label">电话号码：</label>
                    <div class="layui-input-block"> 
                        <input class="layui-input " type="text" name="phone">
                    </div>
                </div>
                
                
                <div class="layui-form-item">
        			<select name="employee.id" id="">   
        					<option value="">请选择员工</option>              	
                        	<c:forEach var="employee" items="${listEmployee}">
                        		<option value="${employee.id}">${employee.username}</option>                
                        	</c:forEach> 
              		</select>
                </div>
                
                
                <div>
                    <input class="sub" type="submit" value="提交"> 
               
                </div>
        </form>
    </div>
    
    <script type="text/javascript" src="./layui/layui.js"></script>
    <script>
//一般直接写在一个js文件中
    layui.use(['element','form'], function(){
          var element = layui.element, //导航的hover效果、二级菜单等功能，需要依赖element模块
          		form=layui.form;
          //监听导航点击
          element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
          });
          
        });
	</script>
    
  </body>

</html>



