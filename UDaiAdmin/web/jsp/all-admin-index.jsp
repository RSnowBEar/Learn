<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base" value="<%=pageContext.getServletContext().getContextPath()%>"></c:set>
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <title>数据 - AdminLTE2定制版</title>

    <%--外部引入样式--%>
    <%@include file="link.jsp"%>
</head>

<body class="hold-transition skin-purple sidebar-mini">

    <div class="wrapper">
        <!-- 页面头部 -->
        <header class="main-header">

            <!-- Logo -->
            <a href="all-admin-index.jsp" class="logo">
                <!-- mini logo for sidebar mini 50x50 pixels -->
                <span class="logo-mini"><b>UDai</b></span>
                <!-- logo for regular state and mobile devices -->
                <span class="logo-lg"><b>UDai</b>后台管理</span>
            </a>


            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top">
                <!-- Sidebar toggle button-->
                <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                </a>


            </nav>
        </header>
        <!-- 页面头部 /-->

        <!-- 导航侧栏 -->
        <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
                <!-- Sidebar user panel -->
                <div class="user-panel">
                    <div class="pull-left image">
                        <img src="${sessionScope.admin.iconRelativePath}"  class="img-circle" alt="User Image">
                    </div>
                    <div class="pull-left info">
                        <p>${sessionScope.admin.adminName}</p>
                        <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
                    </div>
                </div>

                <!-- sidebar menu: : style can be found in sidebar.less -->
                <ul class="sidebar-menu">
                    <li class="header">菜单</li>

                    <li id="admin-index"><a href="all-admin-index.jsp"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>



                    <!-- 菜单 -->
                        <%--用户管理--%>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-folder"></i> <span>用户管理模块</span>
                                <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                            </a>
                            <ul class="treeview-menu">

                                    <%--查看用户信息--%>
                                <li id="admin-404">
                                    <a href="${base}/queryUserAllServlet" target="iframe">
                                        <i class="fa fa-circle-o"></i> 查看用户信息
                                    </a>
                                </li>

                                    <%--修改用户信息--%>
                                <li id="admin-login">
                                    <a href="${base}/updateUserServlet" target="iframe">
                                        <i class="fa fa-circle-o"></i> 修改用户信息
                                    </a>
                                </li>

                                    <%--删除用户--%>
                                <li id="admin-register">
                                    <a href="${base}/deleteUserServlet" target="iframe">
                                        <i class="fa fa-circle-o"></i> 删除用户
                                    </a>
                                </li>
                            </ul>
                        </li>


                        <%--商品管理--%>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-pie-chart"></i> <span>商品管理模块</span>
                                <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                            </a>
                            <ul class="treeview-menu">

                                    <%--查看所有商品--%>
                                <li id="charts-chartjs">
                                    <a href="${base}/queryProductAllServlet" target="iframe">
                                        <i class="fa fa-circle-o"></i>查看所有商品
                                    </a>
                                </li>

                                    <%--添加商品--%>
                                <li id="charts-morris">
                                    <a href="product-add-all.jsp" target="iframe">
                                        <i class="fa fa-circle-o"></i>添加商品
                                    </a>
                                </li>

                                    <%--修改商品信息--%>
                                    <%--<li id="charts-flot">--%>
                                    <%--<a href="product-detail-all.jsp" target="iframe">--%>
                                    <%--<i class="fa fa-circle-o"></i>修改商品信息--%>
                                    <%--</a>--%>
                                    <%--</li>--%>
                            </ul>
                        </li>


                        <%--订单管理--%>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-laptop"></i> <span>订单管理模块</span>
                                <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                            </a>
                            <ul class="treeview-menu">

                                    <%--查询订单--%>
                                <li id="elements-general">
                                    <a href="${base}/queryOrderInfoAllServlet" target="iframe">
                                        <i class="fa fa-circle-o"></i>查询订单
                                    </a>
                                </li>

                                    <%--修改订单--%>
                                <li id="elements-icons">
                                    <a href="order-update-all.jsp" target="iframe">
                                        <i class="fa fa-circle-o"></i>修改订单
                                    </a>
                                </li>
                            </ul>
                        </li>


                        <%--公告管理--%>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>公告管理模块</span>
                                <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                            </a>
                            <ul class="treeview-menu">

                                    <%--查看公告履历--%>
                                <li id="form-general">
                                    <a href="${base}/queryNoticeServlet" target="iframe">
                                        <i class="fa fa-circle-o"></i> 查看公告履历
                                    </a>
                                </li>

                                    <%--新增公告--%>
                                <li id="form-advanced">
                                    <a href="notice-add-all.jsp" target="iframe">
                                        <i class="fa fa-circle-o"></i> 新增公告
                                    </a>
                                </li>

                            </ul>
                        </li>


                        <%--热卖管理--%>
                        <%--<li class="treeview">--%>
                            <%--<a href="#">--%>
                                <%--<i class="fa fa-table"></i> <span>热卖品管理模块</span>--%>
                                <%--<span class="pull-right-container">--%>
                        <%--<i class="fa fa-angle-left pull-right"></i>--%>
                    <%--</span>--%>
                            <%--</a>--%>
                            <%--<ul class="treeview-menu">--%>

                                    <%--&lt;%&ndash;查询所有热卖商品&ndash;%&gt;--%>
                                <%--<li id="tables-simple">--%>
                                    <%--<a href="all-tables-simple.html">--%>
                                        <%--<i class="fa fa-circle-o"></i> 查询热卖商品--%>
                                    <%--</a>--%>
                                <%--</li>--%>

                                    <%--&lt;%&ndash;添加热卖商品&ndash;%&gt;--%>
                                <%--<li id="tables-data">--%>
                                    <%--<a href="all-tables-data.html">--%>
                                        <%--<i class="fa fa-circle-o"></i> 添加热卖商品--%>
                                    <%--</a>--%>
                                <%--</li>--%>

                                    <%--&lt;%&ndash;移除热卖商品&ndash;%&gt;--%>
                                <%--<li id="tables-data">--%>
                                    <%--<a href="all-tables-data.html">--%>
                                        <%--<i class="fa fa-circle-o"></i> 移除热卖商品--%>
                                    <%--</a>--%>
                                <%--</li>--%>
                            <%--</ul>--%>
                        <%--</li >--%>


                        <%--视频管理模块--%>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>视频管理模块</span>
                                <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                            </a>
                            <ul class="treeview-menu">

                                    <%--查询所有视频--%>
                                <li id="tables-simple">
                                    <a href="${base}/queryVideosServlet" target="iframe">
                                        <i class="fa fa-circle-o"></i> 查询所有视频
                                    </a>
                                </li>

                                    <%--添加视频--%>
                                <li id="tables-data">
                                    <a href="video-add-all.jsp" target="iframe">
                                        <i class="fa fa-circle-o"></i> 添加视频
                                    </a>
                                </li>
                            </ul>
                        </li >


                    <%--超级管理--%>
                    <c:if test="${sessionScope.admin.pid==0}">
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>超管菜单</span>
                                <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                            </a>
                            <ul class="treeview-menu">

                                    <%--查询所有管理员--%>
                                <li id="tables-simple">
                                    <a href="${base}/queryAdminServlet" target="iframe">
                                        <i class="fa fa-circle-o"></i> 查询所有管理员
                                    </a>
                                </li>

                                    <%--添加管理员--%>
                                <li id="tables-data">
                                    <a href="admin-add-all.jsp" target="iframe">
                                        <i class="fa fa-circle-o"></i> 添加管理员
                                    </a>
                                </li>

                                    <%--修改管理员信息--%>
                                <li id="tables-data">
                                    <a href="all-tables-data.html">
                                        <i class="fa fa-circle-o"></i> 修改管理员信息
                                    </a>
                                </li>

                            </ul>
                        </li >
                    </c:if>
                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>
        <!-- 导航侧栏 /-->

        <!-- 内容区域 -->
        <div class="content-wrapper">
            <iframe src="welcome.jsp" name="iframe" style="width: 100%;height:85%;"></iframe>
        </div>
        <!-- 内容区域 /-->

         <%--页脚--%>
        <%@include file="foot.jsp"%>
    </div>

<%--外部引入script--%>
    <%@include file="scripts.jsp"%>
</body>

</html>