<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base" value="<%=pageContext.getServletContext().getContextPath()%>"></c:set>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <%@include file="link.jsp"%>
</head>

<body class="hold-transition sidebar-mini">

<div class="wrapper">
    <!-- 内容区域 -->
    <!-- Content Wrapper. Contains page content -->
    <div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                管理员管理模块
                <small>添加管理员</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>管理</a></li>
                <li><a href="#">管理员</a></li>
                <li class="active">添加</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">添加管理员</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">

                            <div class="col-md-10 column">
                                <form action="${base}/addAdminServlet" method="post" class="form-horizontal" role="form" enctype="multipart/form-data" onsubmit="return checkAll()">
                                    <div class="form-group">
                                        <label for="adminName" class="col-sm-2 control-label">管理员登录名</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="adminName" name="adminName"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="adminPassword" class="col-sm-2 control-label">登陆密码</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="adminPassword" name="adminPassword"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="adminPasswordVif" class="col-sm-2 control-label">再次输入密码</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="adminPasswordVif" name="adminPasswordVif"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="adminIcon" class="col-sm-2 control-label">管理员头像</label>
                                        <div class="col-sm-10">
                                            <input type="file" class="form-control" id="adminIcon" name="adminIcon"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-default">提交</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="col-md-2 column"></div>

                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->

                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <!-- page script -->
    <!-- 内容区域 /-->
</div>

<%--外部script--%>
<%@include file="scripts.jsp"%>
<script>
    $(function () {

    })

    function checkAll(){
        var flag=true;
        if($("#adminName").val()==""){
            flag=false;
        }
        if($("#adminPassword").val()==""){
            flag=false;
        }
        if($("#adminPasswordVif").val()==""){
            flag=false;
        }
        if($("#adminPassword").val()!=$("#adminPasswordVif").val()){
            flag=false;
        }
        if($("#adminIcon").val()==""){
            flag=false;
        }

        if(!flag){
            alert("请填写正确信息");
        }
        return flag;
    }
</script>
</body>
</html>