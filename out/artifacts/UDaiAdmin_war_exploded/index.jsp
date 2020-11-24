<%--
  Created by IntelliJ IDEA.
  User: 16907
  Date: 2020/10/19
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>UDai后台管理系统</title>
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="plugins/iCheck/square/blue.css">
</head>

<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="all-admin-index.html"><b>UDai</b>后台管理系统</a>
    </div>
    <div class="login-box-body">
        <p class="login-box-msg">管理员登录系统</p>

        <form id="loginForm" action="indexServlet" method="get" onsubmit="return login()">
            <div class="form-group has-feedback">
                <input id="adminName" name="adminName" type="text" class="form-control" placeholder="用户名" onfocus="init()" onblur="checkName()">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input id="adminPassword" name="adminPassword" type="password" class="form-control" placeholder="密码" onfocus="init()" onblur="checkPwd()">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <span id="errorMsg" style="color: red"></span>
            </div>
            <div class="row">
                <div class="col-xs-3"></div>
                <div class="col-xs-6">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
                <div class="col-xs-3"></div>
            </div>
        </form>
    </div>
</div>

<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<script>
    function init(){
        $("#errorMsg").text(" ");
    }

    function checkName(){
        var adminName = $("#adminName").val();
       if(adminName == null || adminName == ""){
           $("#errorMsg").text("请输入用户名");
           return false;
       }
       return true;
    }

    function checkPwd(){
        var adminPwd = $("#adminPassword").val();
        if(adminPwd == null || adminPwd == ""){
            $("#errorMsg").text("请输入密码");
            return false;
        }
        return true;
    }

    function login(){
        $("#errorMsg").text(" ");
        if(checkName() && checkPwd()){
            var adminName = $("#adminName").val();
            var adminPassword = $("#adminPassword").val();

            $.ajax({
                type:"POST",
                dataType:"json",
                url:"adminLoginServlet",
                data:JSON.stringify({
                    "adminName":adminName,
                    "adminPassword":adminPassword
                }),

                success:function (json) {
                    if(json.ff=="true"){
                        success();
                    }else{
                        $("#errorMsg").text("登录信息输入有误，此次登录已记录在日志");
                    }
                }
            })
        }else{
            $("#errorMsg").text("请输入完整信息");
        }
        return false;
    }

    function success(){
        document.getElementById("loginForm").submit();
    }
</script>
</body>
</html>
