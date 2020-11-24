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
                    用户管理模块
                    <small>删除用户</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i>管理</a></li>
                    <li><a href="#">用户</a></li>
                    <li class="active">删除</li>
                </ol>
            </section>
        </div>
    </div>
    <div class="form-group" style="visibility: hidden">
        <label for="userId" class="col-sm-4 control-label">用户编号</label>
        <div class="col-sm-8">
            <h3>输入用户信息</h3>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-4 column">
            <form action="deleteUserServlet" method="post" class="form-horizontal" role="form">
                <c:set var="user" value="${requestScope.user}"></c:set>
                <div class="form-group">
                    <label for="userId" class="col-sm-4 control-label">用户编号</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="userId" name="userId" value="${user==null?"":user.userId}" ${user==null?"":"readonly='readonly'"}/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-4 control-label">手机号</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="phone" name="phone" value="${user==null?"":user.phone}" ${user==null?"":"readonly='readonly'"}/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button id="queryUser" type="submit" class="btn btn-default">搜索</button>
                        <a href="<%=pageContext.getServletContext().getContextPath()%>/deleteUserServlet">
                            <button type="button" class="btn btn-default">清除</button>
                        </a>
                    </div>
                </div>
            </form>
        </div>

        <div class="col-md-8 column" style="display: ${user==null?'none':'inline'}":}>
            <form action="deleteUserInfoServlet" method="post" class="form-horizontal" role="form">
                <input type="password" id="id" name="userID" value="${user.userId}" style="display: none">
                <div class="form-group">
                    <label class="col-sm-4 control-label">性别</label>
                    <div class="col-sm-5">
                        <c:if test="${user.gander==0}">
                            <c:set var="gander" value="男"></c:set>
                        </c:if>
                        <c:if test="${user.gander==1}">
                            <c:set var="gander" value="女"></c:set>
                        </c:if>
                        <c:if test="${user.gander==2}">
                            <c:set var="gander" value="保密"></c:set>
                        </c:if>
                        <input type="text" class="form-control" name="birthday" value="${gander}" readonly/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">生日</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="birthday" value="${user.birthday}" readonly/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">昵称</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="nickName" value="${user.nickName}" readonly/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">余额</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="balance" value="${user.balance}" readonly/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">积分</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="integral" value="${user.integral}" readonly/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">会员等级</label>
                    <div class="col-sm-5">
                        <c:if test="${user.memberLevel==0}">
                            <c:set var="memberLevel" value="普通会员"></c:set>
                        </c:if>
                        <c:if test="${user.memberLevel==1}">
                            <c:set var="memberLevel" value="一级会员"></c:set>
                        </c:if>
                        <c:if test="${user.memberLevel==2}">
                            <c:set var="memberLevel" value="二级会员"></c:set>
                        </c:if>
                        <c:if test="${user.memberLevel==3}">
                            <c:set var="memberLevel" value="高级会员"></c:set>
                        </c:if>
                        <input type="text" class="form-control" name="memberLevel" value="${memberLevel}" readonly/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">头像</label>
                    <div class="col-sm-5">
                        <img src="${user.iconRelativePath}">
                        <br/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-danger" style="width:200px;height:40px;">删除用户</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="scripts.jsp"%>
</body>
</html>
