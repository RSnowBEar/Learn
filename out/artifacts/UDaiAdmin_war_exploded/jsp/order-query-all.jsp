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
                订单管理模块
                <small>查看所有订单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>管理</a></li>
                <li><a href="#">订单</a></li>
                <li class="active">查看</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">订单查询表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>订单编号</th>
                                    <th>下单用户</th>
                                    <th>购买商品</th>
                                    <th>购买规格</th>
                                    <th>单价</th>
                                    <th>购买数量</th>
                                    <th>实付价格</th>
                                    <th>订单状态</th>
                                    <th>收货详情</th>
                                    <th>下单时间</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="order" items="${requestScope.pageBean.list}">
                                        <tr>
                                            <td>${order.orderId}</td>
                                            <td>${order.phone}</td>
                                            <td>${order.productName}</td>
                                            <td>${order.skuAttribute}</td>
                                            <td>${order.price}</td>
                                            <td>${order.buyNum}</td>
                                            <td>${order.discountPrice}</td>
                                            <td>${order.status}</td>
                                            <td>
                                                <a id="order${order.orderId}" href="#order${order.orderId}" role="button" class="btn" data-toggle="modal">
                                                    <button type="button" class="btn-primary btn">地址详情</button>
                                                </a>
                                            </td>
                                            <td>${order.buyTime}</td>

                                            <%--遮罩窗体--%>
                                            <div class="modal fade" id="order${order.orderId}" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                        </div>
                                                        <div class="modal-body" id="address${order.addressId}">
                                                            <textarea style="border: 0px;width: 300px;height: 100px;resize: none" readonly>${order.province}${order.city}${order.area}${order.town}${order.detail}</textarea>
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
                                        <a href="<%=request.getContextPath()%>/queryOrderInfoAllServlet?currentPage=1&rows=10">
                                            首页
                                        </a>
                                    </li>
                                    <li style="${requestScope.pageBean.currentPage==1?"display:none":""}">
                                        <a href="<%=request.getContextPath()%>/queryOrderInfoAllServlet?currentPage=${requestScope.pageBean.currentPage-1}&rows=10" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                    <c:forEach var="i"
                                               begin="${requestScope.pageBean.currentPage-2<=0?1:requestScope.pageBean.currentPage-2}"
                                               end="${requestScope.pageBean.currentPage+2>=requestScope.pageBean.totalPage?requestScope.pageBean.totalPage:requestScope.pageBean.currentPage+2}">
                                        <li ${i==requestScope.pageBean.currentPage?"class='active'":""}>
                                            <a href="<%=request.getContextPath()%>/queryOrderInfoAllServlet?currentPage=${i}&rows=10">${i}</a>
                                        </li>
                                    </c:forEach>
                                    <li style="${requestScope.pageBean.currentPage==requestScope.pageBean.totalPage?"display:none":""}">
                                        <a href="<%=request.getContextPath()%>/queryOrderInfoAllServlet?currentPage=${requestScope.pageBean.currentPage+1}&rows=10" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="<%=request.getContextPath()%>/queryOrderInfoAllServlet?currentPage=${requestScope.pageBean.totalPage}&rows=10">
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

</script>
</body>
</html>