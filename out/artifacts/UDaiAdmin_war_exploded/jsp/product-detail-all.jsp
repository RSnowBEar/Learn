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
    <style>
        .n{
            display: none;
        }
    </style>
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
                <small>商品详情</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>管理</a></li>
                <li><a href="#">商品</a></li>
                <li class="active">详情</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">商品详情</h3>
                        </div>

                        <!-- /.box-header -->
                        <div class="box-body">
                            <div class="container">
                                <div class="row clearfix">
                                    <div class="col-md-2 column">
                                    </div>
                                    <div class="col-md-8 column">
                                        <div class="row clearfix">
                                            <div class="col-md-2 column">
                                            </div>
                                            <div class="col-md-8 column">


                                                <form action="${base}/addProductServlet" method="post" class="form-horizontal" role="form" onsubmit="return vifEmpty()">
                                                    <div class="form-group">
                                                        <label for="inputEmail3" class="col-sm-2 control-label">商品名称</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" id="productName" name="productName" class="form-control" id="inputEmail3" value="${requestScope.productDetailList[0].productName}" readonly/>
                                                        </div>
                                                    </div>


                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">商品类别</label>
                                                        <div class="col-sm-3" id="categoryList">
                                                           <input type="text" value="${requestScope.category1}" readonly>
                                                           <input type="text" value="${requestScope.category2}" readonly>
                                                           <input type="text" value="${requestScope.category3}" readonly>
                                                        </div>
                                                    </div>
                                            </div>
                                            <div class="col-md-2 column">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-2 column">
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <div class="col-md-12 column">
                                        <table id="skuTable" class="table">
                                            <thead>
                                                <th>商品属性</th>
                                                <th>单价</th>
                                                <th>现有库存</th>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="productDetailList" items="${requestScope.productDetailList}">
                                                    <tr>
                                                       <td id=skuList>
                                                            <c:forEach var="sku" items="${productDetailList.skuAttribute}">
                                                                <input type="text" value="${sku}" readonly>
                                                            </c:forEach>
                                                       </td>
                                                       <td>
                                                           <input type=text name=price value="${productDetailList.price}" readonly>
                                                       </td>
                                                       <td>
                                                           <input type=text name=inventory value="${productDetailList.inventory}" readonly>
                                                       </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <div class="col-md-2 column">
                                    </div>
                                    <div class="col-md-8 column">
                                        </form>
                                    </div>
                                    <div class="col-md-2 column">
                                    </div>
                                </div>

                            </div>
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