<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/base.css" type="text/css">
<link rel="stylesheet" href="style/register.css" type="text/css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/commonJs.js"></script>
<script type="text/javascript" src="js/registerPage.js"></script>
<title></title>


</head>
<body>
    <!--logo栏-->
    <div class="logo-main-wrp">
        <div class="container main">

            <div class="title-con">
                <h1>注册</h1>
            </div>
        </div>
    </div>


    <!--中间部位：注册内容区域-->
    <div id="registerWrap">
          <div class="container main">
            <!--注册需填写的信息-->
            <div class="register-panel">
                <div class="register-content">
                    <h4>填写账户信息，以下信息均为必填：</h4>
                    <form id="registerForm">
                    
                        <ul class="register-info">
                            <li>
                                <div class="reg-col-1 fl">用户名：</div>
                                <div class="reg-col-2 fl">
                                    <input name="username" id="account" type="text">
                                    <span class="error-con">* 登录账号不能为空</span>
                                </div>
                            </li>
                            <li>
                                <div class="reg-col-1 fl">密码：</div>
                                <div class="reg-col-2 fl">
                                    <input name="password" id="password" type="password" >
                                    <span class="error-con">* 密码不合法</span>
                                </div>
                            </li>
                            <li>
                                <div class="reg-col-1 fl">确认密码：</div>
                                <div class="reg-col-2 fl">
                                    <input name="confirmPwd" id="confirmPwd" type="password" >
                                    <span class="error-con">* 两次密码输入不一致</span>
                                </div>
                            </li>
                            <li>
                                <div class="reg-col-1 fl">邮箱：</div>
                                <div class="reg-col-2 fl">
                                    <input name="email" id="email" type="text">
                                    <span class="error-con">* 邮箱地址不合法</span>
                                </div>
                            </li>
                            
                             <li>
                                <div class="reg-col-1 fl">性别：</div>
                                <div class="reg-col-2 fl">
                                    <input name="sex" id="sex" type="text">
                                </div>
                            </li>
                            
                             <li>
                                <div class="reg-col-1 fl">年龄：</div>
                                <div class="reg-col-2 fl">
                                    <input name="age" id="age" type="text">
                                </div>
                            </li>
                            
                            <li>
                                <div class="reg-col-1 fl">手机：</div>
                                <div class="reg-col-2 fl">
                                    <input name="phone" id="phone" type="text">
<!--                                     <label id="getValidNum" style="display:none">获取验证码</label> -->
                                    <span class="error-con">* 手机号码不合法</span>
                                </div>
                            </li>
                            
<!--                         	<li>
                                <div class="reg-col-1 fl">手机验证码：</div>
                                <div class="reg-col-2 fl">
                                    <input name="validNum" id="validNum" type="text">
                                    <span class="error-con">* 手机验证码不正确</span>
                                </div>
                            </li> -->
    
                            <li class="agreement-wrp">
                                <label for="agreement" class="agree-lab">
                                    <i id="selected"></i>
                                    <input id="agreement" name="agreement" type="checkbox">
                                    <a href="javascript:;">我已阅读并同意《用户注册协议》</a>
                                </label>
                            </li>

                            <li class="btn-wrp">
                                <input type="button" id="registerBtn" value="注册" onclick="javascript:registerUser();"/>
                            </li>
                            <li class="login-link">
                                <a href="http://localhost:8082/store/forget" id="forgetPwd">你忘记密码了吗？</a>
                                我已有账号，<a href="http://localhost:8082/store/login" id="loginLink">我要登录</a>
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
    </div>

</body></html>
