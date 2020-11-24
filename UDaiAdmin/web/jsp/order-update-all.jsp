<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="link.jsp"%>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <section class="content-header">
                <h1>
                    订单管理模块
                    <small>修改订单信息</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i>管理</a></li>
                    <li><a href="#">订单</a></li>
                    <li class="active">修改</li>
                </ol>
            </section>
        </div>
    </div>
    <div class="form-group" style="visibility: hidden">
        <label for="userId" class="col-sm-4 control-label">订单编号</label>
        <div class="col-sm-8">
            <h3>输入订单信息</h3>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-4 column">
            <form action="updateOrderServlet" method="post" class="form-horizontal" role="form">
                <c:set var="order" value="${requestScope.order}"></c:set>
                <div class="form-group">
                    <label for="userId" class="col-sm-4 control-label">订单编号</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="userId" name="userId" value="${order==null?"":order.orderId}" ${order==null?"":"readonly='readonly'"}/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button id="queryUser" type="submit" class="btn btn-default">搜索</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="col-md-8 column" style="display: ${user==null?'none':'inline'}":}>
            <form action="updateUserInfoServlet" method="post" class="form-horizontal" role="form" enctype="multipart/form-data">
                <input type="text" name="userID" value="${user.userId}" style="display: none">
                <div class="form-group">
                    <label class="col-sm-4 control-label">性别</label>
                    <div class="col-sm-5">
                        <select name="gander">
                            <option value="0" ${user.gander==0?"selected='selected'":""}>男</option>
                            <option value="1" ${user.gander==1?"selected='selected'":""}>女</option>
                            <option value="2" ${user.gander==2?"selected='selected'":""}>保密</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">生日</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="birthday" value="${user.birthday}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">昵称</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="nickName" value="${user.nickName}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">余额</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="balance" value="${user.balance}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">积分</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="integral" value="${user.integral}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">会员等级</label>
                    <div class="col-sm-5">
                        <select name="memberLevel">
                            <option value="0" ${user.memberLevel==0?"selected='selected'":""}>普通会员</option>
                            <option value="1" ${user.memberLevel==1?"selected='selected'":""}>一级会员</option>
                            <option value="2" ${user.memberLevel==2?"selected='selected'":""}>二级会员</option>
                            <option value="3" ${user.memberLevel==3?"selected='selected'":""}>高级会员</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">头像</label>
                    <div class="col-sm-5">
                        <img src="${user.iconRelativePath}">
                        <br/>
                        <input type="file" name="icon">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary" style="width:200px;height:40px;">修改</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="scripts.jsp"%>
</body>
</html>
