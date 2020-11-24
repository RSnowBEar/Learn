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
                <small>查看公告履历</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>管理</a></li>
                <li><a href="#">公告</a></li>
                <li class="active">查看</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">公告履历表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>公告编号</th>
                                    <th>公告类型</th>
                                    <th>公告标题</th>
                                    <th>公告内容</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="notice" items="${requestScope.pageBean.list}">
                                        <tr>
                                            <td>${notice.noticeId}</td>
                                            <td>
                                                <c:if test="${notice.type==0}">
                                                    公告
                                                </c:if>
                                                <c:if test="${notice.type==1}">
                                                    新闻
                                                </c:if>
                                                <c:if test="${notice.type==2}">
                                                    咨询
                                                </c:if>
                                                <c:if test="${notice.type==3}">
                                                    通知
                                                </c:if>
                                            </td>
                                            <td>《${notice.title}》</td>
                                            <td>
                                                <a id="notice${notice.noticeId}" href="#notice${notice.noticeId}" role="button" class="btn" data-toggle="modal">
                                                    <button type="button" class="btn-primary btn">查看内容</button>
                                                </a>
                                                <button type="button" class="btn-danger btn" onclick="deleteNotice(${notice.noticeId})">删除</button>
                                            </td>

                                            <%--遮罩窗体--%>
                                            <div class="modal fade" id="notice${notice.noticeId}" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <textarea style="width: 100%;height:250px;border: 0px;resize: none;" readonly>${notice.content}</textarea>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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
                                        <a href="<%=request.getContextPath()%>/queryNoticeServlet?currentPage=1&rows=10">
                                            首页
                                        </a>
                                    </li>
                                    <li style="${requestScope.pageBean.currentPage==1?"display:none":""}">
                                        <a href="<%=request.getContextPath()%>/queryNoticeServlet?currentPage=${requestScope.pageBean.currentPage-1}&rows=10" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                    <c:forEach var="i"
                                               begin="${requestScope.pageBean.currentPage-2<=0?1:requestScope.pageBean.currentPage-2}"
                                               end="${requestScope.pageBean.currentPage+2>=requestScope.pageBean.totalPage?requestScope.pageBean.totalPage:requestScope.pageBean.currentPage+2}">
                                        <li ${i==requestScope.pageBean.currentPage?"class='active'":""}>
                                            <a href="<%=request.getContextPath()%>/queryNoticeServlet?currentPage=${i}&rows=10">${i}</a>
                                        </li>
                                    </c:forEach>
                                    <li style="${requestScope.pageBean.currentPage==requestScope.pageBean.totalPage?"display:none":""}">
                                        <a href="<%=request.getContextPath()%>/queryNoticeServlet?currentPage=${requestScope.pageBean.currentPage+1}&rows=10" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="<%=request.getContextPath()%>/queryNoticeServlet?currentPage=${requestScope.pageBean.totalPage}&rows=10">
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
    function deleteNotice(noticeId){
        var flag = confirm("你确定要删除此公告吗");

        if(flag){
            $.get("${base}/deleteNoticeServlet","noticeId="+noticeId,function () {
                window.location.reload();
            })
        }
    }
</script>
</body>
</html>