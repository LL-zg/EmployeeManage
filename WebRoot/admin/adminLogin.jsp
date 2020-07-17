<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
       <meta http-equiv="content-type" content="text/html;charset=UTF-8">
		<title>登陆</title>
		<link type="text/css" rel="stylesheet" href="../style/loginPage.css">
		
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/loginPage.js"></script>
    </head>
   

    <body>
    
        <form>
            <div class="loginBox">
                <h2>管理员登录</h2>
                <div>
					<span id="errorPrompt">用户名或者密码不正确</span>
					<input name="token" value="member" type="hidden">
				</div>
				
                <div class="item">
                    <input type="text" class="type-text" name="username" required>
                    <label for="">UserName</label>
                </div>
                <div class="item">
                    <input type="password" class="type-text" name="password" required>
                    <label for="">Password</label>
                </div>
                <div>
	                <button class="btn" type="button" onclick="javascript:adminLogin()">登  录
	
	                    <span></span>
	                    <span></span>
	                    <span></span>
	                    <span></span>
	                </button>
                </div>
                
                
            </div>

        </form>
        

    </body>

</html>