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
                视频管理模块
                <small>添加视频</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>管理</a></li>
                <li><a href="#">视频</a></li>
                <li class="active">添加</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">添加视频</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">

                            <div class="col-md-10 column">
                                <form action="${base}/addVideoServlet" method="post" class="form-horizontal" role="form" onsubmit="return checkAll()" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label for="title" class="col-sm-2 control-label">视频标题</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="title" name="title"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="title" class="col-sm-2 control-label">视频<font color="red">封面图</font></label>
                                        <div class="col-sm-10">
                                            <input type="file" id="img" name="img" accept="image/*">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="title" class="col-sm-2 control-label">视频</label>
                                        <div class="col-sm-10">
                                            <input type="file" id="video" name="video" accept="video/*">
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
        console.log($("#title").val());
        console.log($("#img").val());
        console.log($("#video").val());

        if($("#title").val()==""){
            flag=false;
        }
        if($("#img").val()==""){
            flag=false;
        }
        if($("#video").val()==""){
            flag=false;
        }
        if(!flag){
            alert("请填写完整信息");
        }
        return flag;
    }
</script>
</body>
</html>