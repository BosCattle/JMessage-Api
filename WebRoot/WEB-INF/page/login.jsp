<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JMessage后台管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Content-Language" content="zh-CN"/>
    <meta name="Author" content="Kevin"/>
    <meta name="keywords" content="JMessage"/>
    <link rel="Shortcut Icon" href="static/ico/favicon.ico"/>
    <link type="text/css" rel="stylesheet" href="static/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="static/css/flat-ui.css"/>
    <link type="text/css" rel="stylesheet" href="resource/css/base.css"/>
    <style type="text/css">
        #div_login{
            /*position: absolute;*/
            /*left: 50%;*/
            /*top: 50%;*/
            /*margin-left: -200px;*/
            /*margin-top: -200px;*/
        }
    </style>
</head>
<body>
<div class="container">
    <div class="login-form center_vertical" id="div_login">
        <div class="form-group">
            <input type="text" class="form-control login-field" value=""
                   placeholder="用户名"
                   id="login-name"/>
            <label class="login-field-icon fui-user" for="login-name"></label>
        </div>

        <div class="form-group">
            <input type="password" class="form-control login-field" value="" placeholder="密码"
                   id="login-pass"/>
            <label class="login-field-icon fui-lock" for="login-pass"></label>
        </div>

        <a class="btn btn-primary btn-lg btn-block" href="#" id="login_button">登录</a>
        <a class="login-link" href="#">忘记密码</a>
    </div>
</div>
</body>
<script type="text/javascript" src="static/js/jquery.js"></script>
<script type="text/javascript" src="static/js/bootstrap.js"></script>
<script type="text/javascript" src="static/js/flat-ui.js"></script>
<script type="text/javascript" src="static/js/strophe.js"></script>
<script type="text/javascript" src="resource/js/login.js"></script>
</html>
