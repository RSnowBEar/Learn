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
                商品管理模块
                <small>查看视频信息</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>管理</a></li>
                <li><a href="#">视频</a></li>
                <li class="active">查看</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">视频信息表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>视频编号</th>
                                    <th>视频标题</th>
                                    <th>封面图</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="video" items="${requestScope.pageBean.list}">
                                        <tr>
                                            <td>${video.videoId}</td>
                                            <td>${video.title}</td>
                                            <td><img src="${video.imgRelaticePath}" style="width: 50px;height:50px;"></td>
                                            <td>
                                                <a id="video${video.videoId}" href="#video${video.videoId}" role="button" class="btn" data-toggle="modal">
                                                    <button type="button" class="btn-primary btn">查看视频</button>
                                                </a>
                                                <button type="button" class="btn-danger btn" onclick="deleteNotice(${video.videoId})">删除</button>
                                            </td>

                                                <%--遮罩窗体--%>
                                            <div class="modal fade" id="video${video.videoId}" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" style="width: 600px;height:400px;">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <video style="width:100%;height:100%;" src="${video.videoRelativePath}" controls></video>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>


                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>


                            <%--分页--%>
                            <nav>
                                <ul id="limit" class="pagination">
                                    <li>
                                        <a href="<%=request.getContextPath()%>/queryVideoServlet?currentPage=1&rows=10">
                                            首页
                                        </a>
                                    </li>
                                    <li style="${requestScope.pageBean.currentPage==1?"display:none":""}">
                                        <a href="<%=request.getContextPath()%>/queryVideoServlet?currentPage=${requestScope.pageBean.currentPage-1}&rows=10" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                    <c:forEach var="i"
                                               begin="${requestScope.pageBean.currentPage-2<=0?1:requestScope.pageBean.currentPage-2}"
                                               end="${requestScope.pageBean.currentPage+2>=requestScope.pageBean.totalPage?requestScope.pageBean.totalPage:requestScope.pageBean.currentPage+2}">
                                        <li ${i==requestScope.pageBean.currentPage?"class='active'":""}>
                                            <a href="<%=request.getContextPath()%>/queryVideoServlet?currentPage=${i}&rows=10">${i}</a>
                                        </li>
                                    </c:forEach>
                                    <li style="${requestScope.pageBean.currentPage==requestScope.pageBean.totalPage?"display:none":""}">
                                        <a href="<%=request.getContextPath()%>/queryVideoServlet?currentPage=${requestScope.pageBean.currentPage+1}&rows=10" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="<%=request.getContextPath()%>/queryVideoServlet?currentPage=${requestScope.pageBean.totalPage}&rows=10">
                                            尾页
                                        </a>
                                    </li>
                                </ul>
                            </nav>
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
    function deleteNotice(videoId){
        if(confirm("确定要删除该视频吗？")){
            $.post("${base}/deleteVideoServlet",{videoId:videoId},function () {
                window.location.href = "${bese}/UDaiAdmin/queryVideoServlet";
            })
        }
    }
</script>
</body>
</html>