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
                公告管理模块
                <small>添加公告</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>管理</a></li>
                <li><a href="#">公告</a></li>
                <li class="active">添加</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">添加公告</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">

                            <div class="col-md-10 column">
                                <form action="${base}/addNoticeServlet" method="post" class="form-horizontal" role="form" onsubmit="return checkAll()">
                                    <div class="form-group">
                                        <label for="type" class="col-sm-2 control-label">公告类型</label>
                                        <div class="col-sm-10">
                                           <select id="type" name="type" class="form-control" style="width:100px;">
                                               <option value="-1">--请选择--</option>
                                               <option value="0">公告</option>
                                               <option value="1">新闻</option>
                                               <option value="2">资讯</option>
                                               <option value="3">通知</option>
                                           </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="title" class="col-sm-2 control-label">公告标题</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="title" name="title"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="title" class="col-sm-2 control-label">公告内容</label>
                                        <div class="col-sm-10">
                                            <textarea id="content" name="content" class="form-control"  style="height:250px;resize: none" maxlength="254"></textarea>
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
        if($("#type").val()==-1){
            flag=false;
        }
        if($("#title").val()==""){
            flag=false;
        }
        if($("#content").val()==""){
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