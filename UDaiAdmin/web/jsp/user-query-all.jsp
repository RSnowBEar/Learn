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
                用户管理模块
                <small>查看用户信息</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>管理</a></li>
                <li><a href="#">用户</a></li>
                <li class="active">查看</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户信息表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" id="checkAll" name="checkAll"></th>
                                    <th>手机号</th>
                                    <th>性别</th>
                                    <th>生日</th>
                                    <th>昵称</th>
                                    <th>余额</th>
                                    <th>积分</th>
                                    <th>会员等级</th>
                                    <th>头像</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="user" items="${requestScope.pageBean.list}">
                                        <tr>
                                            <td><input type="checkbox" name="checkOne"></td>
                                            <td>${user.phone}</td>
                                            <td>
                                                <c:if test="${user.gander==0}">
                                                    男
                                                </c:if>
                                                <c:if test="${user.gander==1}">
                                                    女
                                                </c:if>
                                                <c:if test="${user.gander==2}">
                                                    保密
                                                </c:if>
                                            </td>
                                            <td>${user.birthday}</td>
                                            <td>${user.nickName}</td>
                                            <td>${user.balance}</td>
                                            <td>${user.integral}</td>
                                            <td>
                                                <c:if test="${user.memberLevel==0}">
                                                    普通会员
                                                </c:if>
                                                <c:if test="${user.memberLevel==1}">
                                                    一级会员
                                                </c:if>
                                                <c:if test="${user.memberLevel==2}">
                                                    二级会员
                                                </c:if>
                                                <c:if test="${user.memberLevel==3}">
                                                    高级会员
                                                </c:if>
                                            </td>
                                            <td><img src="${user.iconRelativePath}" style="width: 25px;height: 25px;"></td>
                                            <td>
                                                <a href="${base}/updateUserServlet?userID=${user.userId}"><button type="button" class="btn btn-default">修改</button></a>
                                                <a href="${base}/deleteUserServlet?userID=${user.userId}"><button type="button" class="btn btn-default btn-danger">删除</button></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>


                            <%--分页--%>
                            <nav>
                                <ul id="limit" class="pagination">
                                    <li>
                                        <a href="<%=request.getContextPath()%>/queryUserAllServlet?currentPage=1&rows=10">
                                            首页
                                        </a>
                                    </li>
                                    <li style="${requestScope.pageBean.currentPage==1?"display:none":""}">
                                        <a href="<%=request.getContextPath()%>/queryUserAllServlet?currentPage=${requestScope.pageBean.currentPage-1}&rows=10" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                    <c:forEach var="i"
                                               begin="${requestScope.pageBean.currentPage-2<=0?1:requestScope.pageBean.currentPage-2}"
                                               end="${requestScope.pageBean.currentPage+2>=requestScope.pageBean.totalPage?requestScope.pageBean.totalPage:requestScope.pageBean.currentPage+2}">
                                        <li ${i==requestScope.pageBean.currentPage?"class='active'":""}>
                                            <a href="<%=request.getContextPath()%>/queryUserAllServlet?currentPage=${i}&rows=10">${i}</a>
                                        </li>
                                    </c:forEach>
                                    <li style="${requestScope.pageBean.currentPage==requestScope.pageBean.totalPage?"display:none":""}">
                                        <a href="<%=request.getContextPath()%>/queryUserAllServlet?currentPage=${requestScope.pageBean.currentPage+1}&rows=10" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="<%=request.getContextPath()%>/queryUserAllServlet?currentPage=${requestScope.pageBean.totalPage}&rows=10">
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
</body>
</html>