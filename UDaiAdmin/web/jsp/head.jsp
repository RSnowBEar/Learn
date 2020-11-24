<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 页面头部 -->
<header class="main-header">

    <!-- Logo -->
    <a href="all-admin-index.jsp" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>UDai</b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>UDai网</b>后台管理</span>
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
                <img src="../img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>admin</p>
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
                        <a href="all-admin-404.html">
                            <i class="fa fa-circle-o"></i> 查看用户信息
                        </a>
                    </li>

                    <%--修改用户昵称--%>
                    <li id="admin-login">
                        <a href="all-admin-login.html">
                            <i class="fa fa-circle-o"></i> 修改用户昵称
                        </a>
                    </li>

                    <%--修改用户头像--%>
                    <li id="admin-register">
                        <a href="all-admin-register.html">
                            <i class="fa fa-circle-o"></i> 修改用户头像
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
                        <a href="all-charts-chartjs.html">
                            <i class="fa fa-circle-o"></i>查看所有商品
                        </a>
                    </li>

                    <%--添加商品--%>
                    <li id="charts-morris">
                        <a href="all-charts-morris.html">
                            <i class="fa fa-circle-o"></i>添加商品
                        </a>
                    </li>

                    <%--修改商品信息--%>
                    <li id="charts-flot">
                        <a href="all-charts-flot.html">
                            <i class="fa fa-circle-o"></i>修改商品信息
                        </a>
                    </li>

                    <%--删除商品--%>
                    <li id="charts-inline">
                        <a href="all-charts-inline.html">
                            <i class="fa fa-circle-o"></i>删除商品
                        </a>
                    </li>

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
                        <a href="all-elements-general.html">
                            <i class="fa fa-circle-o"></i>查询订单
                        </a>
                    </li>

                    <%--修改订单--%>
                    <li id="elements-icons">
                        <a href="all-elements-icons.html">
                            <i class="fa fa-circle-o"></i>修改订单
                        </a>
                    </li>

                    <%----%>
                    <%--<li id="elements-buttons">--%>
                    <%--<a href="all-elements-buttons.html">--%>
                    <%--<i class="fa fa-circle-o"></i> 按钮 Buttons--%>
                    <%--</a>--%>
                    <%--</li>--%>
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
                        <a href="all-form-general.html">
                            <i class="fa fa-circle-o"></i> 查看公告履历
                        </a>
                    </li>

                    <%--上传/新增公告--%>
                    <li id="form-advanced">
                        <a href="all-form-advanced.html">
                            <i class="fa fa-circle-o"></i> 上传/新增公告
                        </a>
                    </li>

                    <%--发布公告--%>
                    <li id="form-editors">
                        <a href="all-form-editors.html">
                            <i class="fa fa-circle-o"></i> 发布公告
                        </a>
                    </li>

                    <%--删除公告--%>
                    <li id="form-editors">
                        <a href="all-form-editors.html">
                            <i class="fa fa-circle-o"></i> 删除公告
                        </a>
                    </li>

                </ul>
            </li>


            <%--超级管理--%>
            <li class="treeview" style="display: none">
                <a href="#">
                    <i class="fa fa-table"></i> <span>超管菜单</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <%--查询所有管理员--%>
                    <li id="tables-simple">
                        <a href="all-tables-simple.html">
                            <i class="fa fa-circle-o"></i> 查询所有管理员
                        </a>
                    </li>

                    <%--添加管理员--%>
                    <li id="tables-data">
                        <a href="all-tables-data.html">
                            <i class="fa fa-circle-o"></i> 添加管理员
                        </a>
                    </li>

                    <%--删除管理员--%>
                    <li id="tables-data">
                        <a href="all-tables-data.html">
                            <i class="fa fa-circle-o"></i> 删除管理员
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
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<!-- 导航侧栏 /-->
</body>
</html>