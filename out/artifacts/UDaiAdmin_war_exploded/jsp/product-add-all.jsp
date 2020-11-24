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
                <small>添加商品</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>管理</a></li>
                <li><a href="#">商品</a></li>
                <li class="active">添加</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">添加商品</h3>
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
                                                            <input type="text" id="productName" name="productName" class="form-control" id="inputEmail3" />
                                                        </div>
                                                    </div>


                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">商品类别</label>
                                                        <div class="col-sm-3" id="categoryList">
                                                           <select id="category1" onchange="getCategory2()">
                                                               <option value="-1">--请选择--</option>
                                                               <option value="1">男装</option>
                                                               <option value="2">女装</option>
                                                               <option value="3">包包</option>
                                                               <option value="4">童装</option>
                                                               <option value="5">鞋靴</option>
                                                           </select>
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
                                            </thead>
                                            <tbody>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <div class="col-md-2 column">
                                    </div>
                                    <div class="col-md-8 column">
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button type="button" class="btn btn-primary" style="width:200px;" onclick="send()">提交</button>
                                            </div>
                                        </div>
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
<script>
    function checkProName(){
        var productName = $("#productName").val();
        if(productName!="")
            return true;
        return false;
    }

    function checkCategory(){
        var categoryID = $("#category3").val();
        if(categoryID!=-1 && categoryID!=undefined)
            return true;
        return false;
    }

    function checkSkuValue(){
        var $skuValye = $("select[name=skuValue]");
        for(var i=0;i<$skuValye.length;i++){
            if($skuValye[i].value==-1){
                return false;
            }
        }
        return true;
    }

    function checkPrice(){
        var $price = $("input[name=price]");
        for(var i=0;i<$price.length;i++){
            if($price[i].value==""){
                return false;
            }
        }
        return true;
    }

    function checkInventory(){
        var $inventory = $("input[name=inventory]");
        for(var i=0;i<$inventory.length;i++){
            if($inventory[i].value==""){
                return false;
            }
        }
        return true;
    }

    function send(){
        //提交验证
        if(
            checkProName() &&
            checkCategory() &&
            checkSkuValue() &&
            checkPrice() &&
            checkInventory()
        ){
            var str = "{";

            var productName = $("#productName").val();
            str+="productName:"+productName+",";

            var category3 = $("#category3").val();
            str+="categoryID:"+category3;


            var $skuValue = $("select[name=skuValue]");
            var $price = $("input[name=price]");
            var $inventory = $("input[name=inventory]");
            var $tr = $("tbody tr");


            for(var i=0,j=0;i<$tr.length;i++,j+=2){
                str+=","

                var sku1 = $skuValue[j].value;
                str+="sku1:"+sku1+",";

                var sku2 = $skuValue[j+1].value;
                str+="sku2:"+sku2+",";

                var price = $price[i].value;
                str+="price:"+price+",";

                var inventory = $inventory[i].value;
                str+="inventory:"+inventory;
            }
            str+="}";

            $.post("${base}/addProductServlet",{data:str},function () {
                window.location.href = "${base}/queryProductAllServlet";

            })
        }else{
            alert("填入信息不完整，请检查");
        }
    }

    function delSku(obj){
        if(confirm("确定删除这一条吗")){
            obj.parentNode.parentNode.remove();
        }
    }

    var i=2;

    function newSku(obj){
        var $tr = $(obj.parentNode.parentNode);
        var $newTr = $tr.clone();

        //删除原有按钮
        $newTr[0].firstChild.nextSibling.firstChild.nextSibling.remove();

        //添加新按钮
        $($newTr[0].firstChild.nextSibling).append(
            "<button type=button class=btn onclick=delSku(this)>删除</button>"
        )

        //清空库存值
        $($newTr[0].lastChild.firstChild.nextSibling).val("");

        //清空单价值
        $($newTr[0].lastChild.previousSibling.previousSibling.firstChild.nextSibling).val("");

        //添加一行
        $("#skuTable tbody").append($newTr);
        i=i+1;
    }

    function getCategory2() {
        //如果存在则删除category2选择框
        if(($("#category2").length)>0){
            $("#category2").remove();
        }

        //如果存在则删除category3选择框
        if(($("#category3").length)>0){
            $("#category3").remove();
        }

        //如果存在则删除tbody下所有tr
        if($("#skuTable tbody tr").length>0){
            $("#skuTable tbody tr").remove();
        }

        //新建cateogry2选择框
        $("#categoryList").append(
            "<select id=category2 onchange=getCategory3()></select>"
        )

        //获取选取的值
        var category1 = $("#category1").val();

        //获取category2的值
        $.get("${base}/queryCategoryServlet","categoryID="+category1,function (data) {
            //设置category2的值
            setCategory2(data);
        });
    }

    function getCategory3() {
        //如果存在则删除category3选择框
        if(($("#category3").length)>0){
            $("#category3").remove();
        }

        //如果存在则删除tbody下所有tr
        if($("#skuTable tbody tr").length>0){
            $("#skuTable tbody tr").remove();
        }

        //新建cateogry3选择框
        $("#categoryList").append(
            "<select id=category3 onchange=getSkuTbody()></select>"
        )

        //获取category2选择的值
        var category2 = $("#category2").val();

        //获取category3的值
        $.get("${base}/queryCategoryServlet","categoryID="+category2,function (data) {
            //设置category3的值
            setCategory3(data);
        });
    }

    function getSkuTbody() {
        //如果存在则删除tbody下所有tr
        if($("#skuTable tbody tr").length>0){
            $("#skuTable tbody tr").remove();
        }

        //创建第一行默认的tr
        $("#skuTable tbody").append(
            "<tr>" +
            "   <td>" +
            "       <button type=button class=btn btn-default btn-primary onclick=newSku(this)>增加一条</button>" +
            "   </td>" +
            "   <td id=skuList>" +
            "   </td>" +
            "   <td>" +
            "       <input type=text name=price placeholder=商品单价>" +
            "   </td>" +
            "   <td>" +
            "       <input type=text name=inventory placeholder=现有库存>" +
            "   </td>" +
            "</tr>"
        )

        //获取category3选择的值
        var category3 = $("#category3").val();

        //获取对应属性列表
        $.get("${base}/querySkuServlet","categoryID="+category3,function (data) {
            //设置属性列表
            setSkuTbody(data);
        });

    }

    function setCategory2(data){
        //获取数据
        data = JSON.parse(data);

        //循环插入数据
        $("#category2").append(
            "<option value='-1'>--请选择--</option>"
        )
        for(var i=0;i<data.length;i++){
            var value = data[i].categoryId;
            var text = data[i].categoryName;
            $("#category2").append(
                "<option value="+value+">"+text+"</option>"
            )
        }
    }

    function setCategory3(data){
        //获取数据
        data = JSON.parse(data);

        //循环添加表数据
        $("#category3").append(
            "<option value='-1'>--请选择--</option>"
        )
        for(var i=0;i<data.length;i++){
            var value = data[i].categoryId;
            var text = data[i].categoryName;
            $("#category3").append(
                "<option value="+value+">"+text+"</option>"
            )

        }
    }

    function setSkuTbody(data){
        //获取数据
        data = JSON.parse(data);

        //循环设置
        for(var i=0;i<data.length;i++){
            var skus = data[i];
            var skuid = "sku"+i;
            $("#skuList").append(
                "<select id="+skuid+" name=skuValue></select>"
            );
            $("#"+skuid).append(
                "<option value=-1>--请选择--</option>"
            )
            for(var j=0;j<skus.length;j++){
                $("#"+skuid).append(
                    "<option value="+skus[j].specificationId+">"+skus[j].specificationName+"</option>"
                )
            }
        }
    }

    function vifEmpty(){
        var flag = true;
        var skus = $("select[name=skuValue]");
        if(skus.length==0){
            flag = false;
        }
        for(var i=0;i<skus.length;i++){
            if(skus[i].value==-1){
                flag=false;

            }
        }

        var price = $("input[name=price]");
        var inventory = $("input[name=inventory]");
        var productName = $("input[name=productName]");
        if(price.length==0 || inventory.length==0){
            flag=false;
        }
        if(price[0].value=="" || inventory[0].value==""){
            flag=false;
        }
        if(productName[0].value==""){
            flag=false;
        }


        if(!flag){
            alert("请输入完整信息");
        }
        return flag;
    }

</script>
</body>
</html>