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
                <small>查看商品信息</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>管理</a></li>
                <li><a href="#">商品</a></li>
                <li class="active">查看</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">商品信息表</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="example2" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" id="checkAll" name="checkAll"></th>
                                    <th>商品编号</th>
                                    <th>商品名称</th>
                                    <th>类型编号</th>
                                    <th>上架时间</th>
                                    <th>上下架状态</th>
                                    <th>预览图</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="product" items="${requestScope.pageBean.list}">
                                        <tr>
                                            <td><input type="checkbox" name="checkOne"></td>
                                            <td>${product.productId}</td>
                                            <td>${product.productName}</td>
                                            <td>${product.categoryID}</td>
                                            <td>${product.shelfTime}</td>
                                            <td>
                                                <c:if test="${product.shelfStatus==0}">
                                                    上架
                                                </c:if>
                                                <c:if test="${product.shelfStatus==1}">
                                                    下架
                                                </c:if>
                                            </td>
                                            <td><img src="${product.imgRelativePath}" style="width: 25px;height: 25px;"></td>
                                            <td>
                                                <a href="${base}/queryProductDetailServlet?productID=${product.productId}">
                                                    <button type="button" class="btn btn-default">详细</button>
                                                </a>
                                                <button type="button" class="btn btn-default btn-danger" onclick="deleteProduct(${product.productId})">删除</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>


                            <%--分页--%>
                            <nav>
                                <ul id="limit" class="pagination">
                                    <li>
                                        <a href="<%=request.getContextPath()%>/queryProductAllServlet?currentPage=1&rows=10">
                                            首页
                                        </a>
                                    </li>
                                    <li style="${requestScope.pageBean.currentPage==1?"display:none":""}">
                                        <a href="<%=request.getContextPath()%>/queryProductAllServlet?currentPage=${requestScope.pageBean.currentPage-1}&rows=10" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                    <c:forEach var="i"
                                               begin="${requestScope.pageBean.currentPage-2<=0?1:requestScope.pageBean.currentPage-2}"
                                               end="${requestScope.pageBean.currentPage+2>=requestScope.pageBean.totalPage?requestScope.pageBean.totalPage:requestScope.pageBean.currentPage+2}">
                                        <li ${i==requestScope.pageBean.currentPage?"class='active'":""}>
                                            <a href="<%=request.getContextPath()%>/queryProductAllServlet?currentPage=${i}&rows=10">${i}</a>
                                        </li>
                                    </c:forEach>
                                    <li style="${requestScope.pageBean.currentPage==requestScope.pageBean.totalPage?"display:none":""}">
                                        <a href="<%=request.getContextPath()%>/queryProductAllServlet?currentPage=${requestScope.pageBean.currentPage+1}&rows=10" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="<%=request.getContextPath()%>/queryProductAllServlet?currentPage=${requestScope.pageBean.totalPage}&rows=10">
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
    function deleteProduct(productId){
        if(confirm("确定要删除该商品及起所有库存信息吗")){
            $.post("${base}/deleteProductServlet",{productId:productId},function () {
                window.location.href = "${base}/queryProductAllServlet";
            });
        }
    }
</script>
</body>
</html>