package com.view;

import com.entity.*;

import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 * 客户端
 */
public class Client {
    private static message message;
    private static Map data;
    private static Scanner sc = new Scanner(System.in);

    private static Socket socket;
    private static InputStream is;
    private static OutputStream os;
    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;

    private static String loginingUserName;

    public static void main(String[] args) {
        System.out.println("=====================");
        System.out.println("欢迎使用Halo租车系统");
        System.out.println("=====================");
        mainMenu();
    }

    //主菜单
    private static void mainMenu(){
        System.out.println("");
        System.out.println("****************");
        System.out.println("您的账号类型：");
        System.out.println("\t1.用户");
        System.out.println("\t2.管理员");
        System.out.println("\t3.退出");
        System.out.println("****************");
        switch(getChoose()){
            //用户主菜单
            case "1":
                userMainMenu();
                break;

            //管理员主菜单
            case "2":
                adminMainMenu();
                break;

            //退出
            case "3":
                loginingUserName="";
                System.exit(0);
                break;

            //其他输入
            default:
                System.out.println("输入有误，请重试");
                toBeContinue();
                mainMenu();
        }
    }

    //用户主菜单
    private static void userMainMenu(){
        System.out.println();
        System.out.println("****************");
        System.out.println("用户操作菜单：");
        System.out.println("\t1.登录");
        System.out.println("\t2.注册");
        System.out.println("\t3.返回");
        System.out.println("****************");
        switch(getChoose()){
            //用户登录
            case "1":
                data=new HashMap();
                String loginUserName = getUserName();
                data.put("userName",loginUserName);
                data.put("password",getPassword());
                String verifyCode = verifyCode();
                System.out.println("验证码："+verifyCode);
                if(!getVerifyCode().equals(verifyCode)){
                    System.out.println("验证码错误，请重试");
                    toBeContinue();
                    userMainMenu();
                }
                boolean userLogin = (boolean) sendRequest("userLogin");
                if(userLogin) {
                    loginingUserName=loginUserName;
                    System.out.println("登陆成功");
                    showUserQueryCarList("userQueryCarAll");
                    toBeContinue();
                    //进入用户操作菜单
                    userOperationMenu();
                }else{
                    System.out.println("用户名或密码有误,请重试");
                    toBeContinue();
                    userMainMenu();
                }
                break;

            //用户注册
            case "2":
                data=new HashMap();
                data.put("userName", getUserName());
                data.put("Pwd", getPassword());
                data.put("VifPwd",getVerifyPassword());
                data.put("Sex", getSex());
                data.put("IDNumber", getIDNumber());
                data.put("Tel", getTel());
                data.put("Address", getAddress());
                boolean userRegister = (boolean)sendRequest("userRegister");
                if(userRegister){
                    System.out.println("注册成功");
                    toBeContinue();
                }else{
                    System.out.println("注册失败，请重试");
                    toBeContinue();
                }
                userMainMenu();
                break;

            //返回主菜单
            case "3":
                mainMenu();
                break;
                //其他输入
            default:
                System.out.println("输入有误，请重试");
                toBeContinue();
                userMainMenu();
        }
    }

    //管理员主菜单
    private static void adminMainMenu(){
        System.out.println();
        System.out.println("****************");
        System.out.println("用户操作菜单：");
        System.out.println("\t1.登录");
        System.out.println("\t2.返回");
        System.out.println("****************");
        switch(getChoose()){
            //管理员登录
            case "1":
                data=new HashMap();
                String loginAdminName=getUserName();
                data.put("adminName",loginAdminName);
                data.put("adminPwd", getPassword());
                boolean adminLogin = (boolean) sendRequest("adminLogin");
                if(adminLogin){
                    loginingUserName=loginAdminName;
                    System.out.println("登陆成功");
                    adminControlMenu();
                }else{
                    System.out.println("登陆失败,请重试");
                    toBeContinue();
                    adminMainMenu();
                }
                break;

            //返回主菜单
            case "2":
                mainMenu();
                //其他输入
            default:
                System.out.println("输入有误，请重试");
                toBeContinue();
                adminMainMenu();
        }
    }

    //用户操作菜单
    private static void userOperationMenu(){
        System.out.println();
        System.out.println("****************");
        System.out.println("用户操作菜单:");
        System.out.println("\t1.查询汽车");
        System.out.println("\t2.租车");
        System.out.println("\t3.还车");
        System.out.println("\t4.查询租车记录");
        System.out.println("\t5.退出登录");
        System.out.println("****************");
        switch(getChoose()){
            //用户查询汽车
            case "1":
                //用户查询汽车菜单
                userQueryCarMainMenu();
                break;
            //用户租车
            case "2":
                userRent();
                break;
            //用户还车
            case "3":
                userReturn();
                break;
            //用户查询租赁记录
            case "4":
                showUserQueryRecord("userQueryRecord");
                break;
            //退出登录
            case "5":
                loginingUserName="";
                mainMenu();
            default:
                System.out.println("输入有误，请重试");
                toBeContinue();
                userOperationMenu();
        }
    }

    //用户查询汽车菜单
    private static void userQueryCarMainMenu(){
        System.out.println();
        System.out.println("****************");
        System.out.println("查询汽车菜单:");
        System.out.println("\t1.查询全部汽车");
        System.out.println("\t2.按照日租价格");
        System.out.println("\t3.按照市场价格");
        System.out.println("\t4.按照车型");
        System.out.println("\t5.按照品牌");
        System.out.println("\t6.按照颜色");
        System.out.println("\t7.返回操作菜单 ");
        System.out.println("****************");
        switch(getChoose()){
            //用户查询全部汽车
            case "1":
                showUserQueryCarList("userQueryCarAll");
                break;
            //按照日租金排序
            case "2":
                userQueryCarMainMenu_RentMenu();
                break;
            //按照市场价格排序
            case "3":
                userQueryCarMainMenu_PriceMenu();
                break;
            //按照品牌排序
            case "4":
                showUserQueryCarList("userQueryCarOrderByCategory");
                break;
            //按照车型排序
            case "5":
                showUserQueryCarList("userQueryCarOrderByBrand");
                break;
            //按照车型排序
            case "6":
                showUserQueryCarList("userQueryCarOrderByColor");
                break;
            //返回操作菜单
            case "7":
                userOperationMenu();
                break;
            default:
                System.out.println("输入有误，请重试");
                toBeContinue();
                userQueryCarMainMenu();
        }
        toBeContinue();
        userQueryCarMenu_topic();
    }

    //用户按照日租金查询菜单
    private static void userQueryCarMainMenu_RentMenu(){
        System.out.println();
        System.out.println("****************");
        System.out.println("\t1.升序");
        System.out.println("\t2.降序");
        System.out.println("****************");
        switch(getChoose()){
            //升序
            case "1":
                showUserQueryCarList("userQueryCarOrderByRentAsc");
                break;

            //降序
            case "2":
                showUserQueryCarList("userQueryCarOrderByRentDesc");
                break;

            default:
                System.out.println("输入有误,即将返回查询菜单");
                toBeContinue();
                userQueryCarMainMenu();
        }
    }

    //用户按照市场价格查询菜单
    private static void userQueryCarMainMenu_PriceMenu(){
        System.out.println();
        System.out.println("****************");
        System.out.println("\t1.升序");
        System.out.println("\t2.降序");
        System.out.println("****************");
        switch(getChoose()){
            //升序
            case "1":
                showUserQueryCarList("userQueryCarOrderByPriceAsc");
                break;

            //降序
            case "2":
                showUserQueryCarList("userQueryCarOrderByPriceDesc");
                break;

            default:
                System.out.println("输入有误,即将返回查询菜单");
                toBeContinue();
                userQueryCarMainMenu();
        }
    }

    //用户查询结果附加菜单
    private static void userQueryCarMenu_topic(){
        System.out.println();
        System.out.println("****************");
        System.out.println("\t1.租车");
        System.out.println("\t2.返回主菜单");
        System.out.println("****************");
        switch(getChoose()){
            //租车
            case "1":
                userRent();
                break;

            //返回用户主菜单
            case "2":
                userOperationMenu();

            default:
                System.out.println("输入有误,请重试");
                toBeContinue();
                userQueryCarMainMenu();
        }
    }

    //输出用户查询租赁记录
    private static void showUserQueryRecord(String function){
        data=new HashMap();
        data.put("userName",loginingUserName);
        List<selectRecord> userQueryRecord = (List) sendRequest(function);
        showQueryRecordListTitle();
        for(selectRecord s:userQueryRecord){
            System.out.println(s);
        }
        toBeContinue();
        userOperationMenu();
    }

    //用户租车面板
    private static void userRent(){
        data=new HashMap();
        data.put("userName", loginingUserName);
        data.put("carID",getCarID());
        data.put("rentDays", getRentDays());
        boolean userRent = (boolean)sendRequest("userRent");
        if(userRent){
            System.out.println("租车成功");
            System.out.println();
            showUserQueryRecord("userQueryRecord");
            toBeContinue();
            userOperationMenu();
        }else{
            System.out.println("租车失败");
            toBeContinue();
            userQueryCarMainMenu();
        }
    }

    //用户还车面板
    private static void userReturn(){
        data=new HashMap();
        data.put("userName", loginingUserName);
        data.put("carID", getCarID());
        boolean userReturn = (boolean)sendRequest("userReturn");
        if(userReturn){
            System.out.println("还车成功");
            toBeContinue();
            userOperationMenu();
        }else{
            System.out.println("还车失败,即将跳转到记录表");
            toBeContinue();
            showUserQueryRecord("userQueryRecord");
        }
    }

    //管理员操作菜单
    private static void adminControlMenu(){
        System.out.println();
        System.out.println("****************");
        System.out.println("管理员操作菜单:");
        System.out.println("\t1.查询汽车");
        System.out.println("\t2.添加车辆");
        System.out.println("\t3.添加汽车品牌");
        System.out.println("\t4.添加汽车类型");
        System.out.println("\t5.修改汽车");
        System.out.println("\t6.删除汽车");
        System.out.println("\t7.查询租赁记录");
        System.out.println("\t8.退出登录");
        System.out.println("****************");
        switch(getChoose()){
            //查询汽车
            case "1":
                adminQueryCarMenu();
                break;

            //添加汽车
            case "2":
                adminInsertCar();
                break;

            //添加汽车品牌
            case "3":
                data = new HashMap();
                data.put("userName", loginingUserName);
                data.put("brandName", getBrandName());
                boolean adminInsertBrand = (boolean) sendRequest("adminInsertBrand");
                if(adminInsertBrand){
                    System.out.println("添加成功");
                    adminQueryBrandAll();
                    toBeContinue();
                    adminControlMenu();

                }else{
                    System.out.println("添加失败,请重试");
                    toBeContinue();
                    adminControlMenu();
                }
                break;

            //添加汽车类别
            case "4":
                data = new HashMap();
                data.put("userName", loginingUserName);
                data.put("categoryName", getCategoryName());
                boolean adminInsertCategory = (boolean) sendRequest("adminInsertCategory");
                if(adminInsertCategory){
                    System.out.println("添加成功");
                    adminQueryCategoryAll();
                    toBeContinue();
                    adminControlMenu();

                }else{
                    System.out.println("添加失败,请重试");
                    toBeContinue();
                    adminControlMenu();
                }
                break;

            //修改汽车
            case "5":
                showAdminQueryCarList("adminQueryCarAll");
                adminupdateCarMenu(getCarID());
                break;

            //删除汽车
            case "6":
                System.out.println("暂未提供此功能，请期待后续版本");
                toBeContinue();
                adminControlMenu();
                break;

            //查询租赁记录
            case "7":
                adminQueryRecordMenu();
                break;

            //退出登录
            case "8":
                loginingUserName="";
                mainMenu();
                break;

            default:
                System.out.println("输入有误，请重试");
                toBeContinue();
                adminControlMenu();
                break;
        }
    }

    //管理员查询租赁记录
    private static void adminQueryRecordMenu(){
        System.out.println();
        System.out.println("****************");
        System.out.println("管理员查询记录菜单:");
        System.out.println("\t1.查询全部");
        System.out.println("\t2.根据用户编号查询");
        System.out.println("\t3.根据车辆编号查询");
        System.out.println("\t4.按照支付租金排序");
        System.out.println("\t5.返回");
        System.out.println("****************");
        switch(getChoose()){
            //查询全部
            case "1":
                showAdminQueryRecordList("adminQueryRecordAll","");
                break;

            //根据用户编号查询
            case "2":
                adminQueryUserAll();
                showAdminQueryRecordList("adminQueryRecordByUID",getUID());
                break;

            //根据车辆编号查询
            case "3":
                showAdminQueryCarList("adminQueryCarAll");
                showAdminQueryRecordList("adminQueryRecordByCID", getCarID());
                break;

            //按照支付金额排序
            case "4":
                showAdminQueryRecordList("adminQueryRecordByPay","");
                break;

            //返回
            case "5":
                adminControlMenu();

            default:
                System.out.println("输入有误，请重试");
                toBeContinue();
                adminQueryRecordMenu();
        }
        toBeContinue();
        adminQueryRecordMenu();
    }

    //输出管理员查询记录表
    private static void showAdminQueryRecordList(String function,String ID){
        data=new HashMap();
        data.put("ID", ID);
        data.put("adminName",loginingUserName);
        List<selectRecord> query = (List<selectRecord>) sendRequest(function);
        if(query!=null){
            showQueryRecordListTitle();
            for(selectRecord s:query){
                System.out.println(s);
            }
        }else
            System.out.println("该编号目标尚未拥有记录");
    }

    //管理员修改汽车
    private static void adminupdateCarMenu(String cid){
        Map updateList = new HashMap();
        updateList.put("adminName", loginingUserName);
        updateList.put("cid", cid);
        System.out.println();
        System.out.println("****************");
        System.out.println("管理员修改汽车菜单:");
        System.out.println("\t1.修改车牌号");
        System.out.println("\t2.修改品牌编号");
        System.out.println("\t3.修改型号");
        System.out.println("\t4.修改类型编号");
        System.out.println("\t5.修改颜色");
        System.out.println("\t6.修改描述");
        System.out.println("\t7.修改市场价");
        System.out.println("\t8.修改日租金");
        System.out.println("\t9.修改租赁状态");
        System.out.println("\t10.修改上下架状态");
        System.out.println("\t11.返回");
        System.out.println("****************");
        boolean adminUpdate=false;
        switch(getChoose()){
            //修改车牌号
            case "1":
                updateList.put("car_num", getCar_Num());
                data=updateList;
                adminUpdate = (boolean)sendRequest("adminUpdateCar_Num");
                break;

            //修改品牌编号
            case "2":
                adminQueryBrandAll();
                updateList.put("brand_id", getBrand_ID());
                data=updateList;
                adminUpdate = (boolean)sendRequest("adminUpdateBrand_id");
                break;

            //修改汽车型号
            case "3":
                updateList.put("model", getModel());
                data=updateList;
                adminUpdate = (boolean)sendRequest("adminUpdateModel");
                break;

            //修改类型编号
            case "4":
                adminQueryCategoryAll();
                updateList.put("category_id",getCategory_ID());
                data=updateList;
                adminUpdate = (boolean)sendRequest("adminUpdateCategory_id");
                break;

            //修改汽车颜色
            case "5":
                updateList.put("color", getColor());
                data=updateList;
                adminUpdate = (boolean)sendRequest("adminUpdateColor");
                break;

            //修改汽车描述
            case "6":
                updateList.put("comments", getComments());
                data=updateList;
                adminUpdate = (boolean)sendRequest("adminUpdateComments");
                break;

            //修改市场价
            case "7":
                updateList.put("price", getPrice());
                data=updateList;
                adminUpdate = (boolean)sendRequest("adminUpdatePrice");
                break;

            //修改日租金
            case "8":
                updateList.put("rent", getRent());
                data=updateList;
                adminUpdate =(boolean) sendRequest("adminUpdateRent");
                break;

            //修改租赁状态
            case "9":
                updateList.put("status", getStatus());
                data=updateList;
                adminUpdate =(boolean) sendRequest("adminUpdateStatus");
                break;

            //修改上下架状态
            case "10":
                updateList.put("useable", getUseable());
                data=updateList;
                adminUpdate = (boolean)sendRequest("adminUpdateUseable");
                break;

                //返回
            case "11":
                adminControlMenu();
                break;

            default:
                System.out.println("输入有误，请重试");
                toBeContinue();
                adminupdateCarMenu(cid);
        }
        if(adminUpdate) {
            System.out.println("修改成功");
            data=new HashMap();
            data.put("carID",cid);
            data.put("adminName", loginingUserName);
            showAdminQueryCarList("adminQueryCarByID");
        }
        else {
            System.out.println("修改失败,请检查车辆租赁状态");
            toBeContinue();
            adminControlMenu();
        }
        toBeContinue();
        adminupdateCarMenu(cid);
    }

    //管理员查询汽车菜单
    private static void adminQueryCarMenu(){
        System.out.println();
        System.out.println("****************");
        System.out.println("管理员查询菜单:");
        System.out.println("\t1.查询所有汽车");
        System.out.println("\t2.根据汽车编号查询");
        System.out.println("\t3.根据上下架情况查询");
        System.out.println("\t4.根汽车租赁状态查询");
        System.out.println("\t5.返回主菜单");
        System.out.println("****************");
        switch(getChoose()){
            //查询所有
            case "1":
                data=new HashMap();
                data.put("adminName", loginingUserName);
                showAdminQueryCarList("adminQueryCarAll");
                break;

            //根据汽车编号
            case "2":
                data=new HashMap();
                data.put("carID", getCarID());
                data.put("adminName", loginingUserName);
                showAdminQueryCarList("adminQueryCarByID");
                break;

            //根据上下架情况查询
            case "3":
                data=new HashMap();
                data.put("adminName", loginingUserName);
                showAdminQueryCarList("adminQueryCarOrderByUseable");
                break;

            //根据租赁状态查询
            case "4":
                data=new HashMap();
                data.put("adminName", loginingUserName);
                showAdminQueryCarList("adminQueryCarOrderByStatus");
                break;

            //返回管理员主菜单
            case "5":
                adminControlMenu();

            default:
                System.out.println("输入有误，请重试");
                toBeContinue();
                adminQueryCarMenu();
        }
        toBeContinue();
        adminQueryCarMenu();
    }

    //管理员添加汽车面板
    private static void adminInsertCar(){
        Map insertList=new HashMap();
        insertList.put("adminName", loginingUserName);
        insertList.put("car_num", getCar_Num());
        adminQueryBrandAll();
        insertList.put("brand_id", getBrand_ID());
        insertList.put("model", getModel());
        insertList.put("color", getColor());
        adminQueryCategoryAll();
        insertList.put("category_id", getCategory_ID());
        insertList.put("comments", getComments());
        insertList.put("price", getPrice());
        insertList.put("rent", getRent());
        insertList.put("status", getStatus());
        insertList.put("useable", getUseable());
        data=insertList;
        boolean adminInsertCar = (boolean)sendRequest("adminInsertCar");
        if(adminInsertCar){
            System.out.println("添加成功");
            toBeContinue();
            adminControlMenu();
        }else{
            System.out.println("添加失败");
            toBeContinue();
            adminControlMenu();
        }
    }

    //输出用户表
    private static void adminQueryUserAll(){
        data=new HashMap();
        data.put("adminName", loginingUserName);
        List<user> list = (List<user>) sendRequest("adminQueryUserAll");
        showQueryUserListTitle();
        for(user u:list){
            System.out.println(u);
        }
    }

    //输出品牌表
    private static void adminQueryBrandAll(){
        data=new HashMap();
        data.put("adminName",loginingUserName);
        List<brand> adminQueryBrandAll = (List<brand>) sendRequest("adminQueryBrandAll");
        System.out.println("****************");
        showQueryBrandListTitle();
        for(brand b:adminQueryBrandAll){
            System.out.println(b);
        }
        System.out.println("****************");
    }

    //输出汽车类型表
    private static void adminQueryCategoryAll(){
        data=new HashMap();
        data.put("adminName", loginingUserName);
        List<category> adminQueryCategoryAll = (List<category>) sendRequest("adminQueryCategoryAll");
        System.out.println("****************");
        showQueryCategoryListTitle();
        for(category c:adminQueryCategoryAll){
            System.out.println(c);
        }
        System.out.println("****************");
    }


    //输出用户查询车辆的结果
    private static void showUserQueryCarList(String function){
        data=new HashMap();
        data.put("userName",loginingUserName);
        List<selectCarAll> userQueryCarAll = (List) sendRequest(function);
        showQueryCarListTitle();
        for(selectCarAll car:userQueryCarAll){
            System.out.println(car);
        }
    }

    //输出管理员查询车辆的结果
    private static void showAdminQueryCarList(String function){
        List<selectCarAll> adminQueryCarAll = (List) sendRequest(function);
        showQueryCarListTitle();
        for(selectCarAll car:adminQueryCarAll){
            System.out.println(car);
        }
    }

    //查询用户表头
    private static void showQueryUserListTitle(){
        System.out.println(
                "用户编号\t\t" +
                        "用户名\t\t" +
                        "密码\t\t\t\t" +
                        "性别\t\t\t" +
                        "身份证号\t\t\t\t\t" +
                        "电话号码\t\t\t\t\t" +
                        "住址\t\t\t" +
                        "账号类型"
        );
    }

    //查询品牌表头
    private static void showQueryBrandListTitle(){
        System.out.println(
                "品牌编号\t\t"+
                        "品牌名称"
        );
    }

    //查询汽车类型表头
    private static void showQueryCategoryListTitle(){
        System.out.println(
                "类型编号\t\t"+
                        "类型名称"
        );
    }

    //查询记录表头
    private static void showQueryRecordListTitle(){
        System.out.println(
                "单号\t\t\t" +
                        "用户编号\t\t" +
                        "用户名\t\t" +
                        "车辆编号\t\t" +
                        "车牌号\t\t\t" +
                        "型号\t\t\t" +
                        "颜色\t\t\t" +
                        "租车时间\t\t\t\t" +
                        "还车时间\t\t\t\t" +
                        "支付租金"
        );
    }

    //查询汽车表头
    private static void showQueryCarListTitle(){
        System.out.println(
                "汽车编号\t\t"+
                        "车牌号\t\t\t"+
                        "品牌\t\t\t"+
                        "型号\t\t\t"+
                        "颜色\t\t\t"+
                        "类型\t\t\t"+
                        "描述\t\t\t\t"+
                        "市场价\t\t\t" +
                        "日租金\t\t\t" +
                        "租赁状态\t\t" +
                        "商品状态"
        );
    }

    //获取菜单选择项
    private static String getChoose(){
        System.out.println("请选择：");
        return new String(sc.next());
    }

    //获取用户输入的品牌名称
    private static String getBrandName(){
        System.out.println("请输入汽车品牌名称：");
        return new String(sc.next());
    }

    //获取用户输入的类别名称
    private static String getCategoryName(){
        System.out.println("请输入汽车类别名称：");
        return new String(sc.next());
    }

    //获取输入的用户编号
    private static String getUID(){
        System.out.println("请输入用户编号：");
        return new String(sc.next());
    }

    //获取输入的车牌号
    private static String getCar_Num(){
        System.out.println("请输入车牌号:");
        return new String(sc.next());
    }

    //获取输入的品牌编号
    private static String getBrand_ID(){
        System.out.println("请输入品牌编号:");
        return new String(sc.next());
    }

    //获取输入的汽车型号
    private static String getModel(){
        System.out.println("请输入汽车型号:");
        return new String(sc.next());
    }

    //获取输入的汽车颜色
    private static String getColor(){
        System.out.println("请输入汽车颜色:");
        return new String(sc.next());
    }

    //获取输入的汽车类型编号
    private static String getCategory_ID(){
        System.out.println("请输入汽车类型编号:");
        return new String(sc.next());
    }

    //获取输入的汽车描述
    private static String getComments(){
        System.out.println("请输入汽车描述:");
        return new String(sc.next());
    }

    //获取输入的汽车价格
    private static String getPrice(){
        System.out.println("请输入汽车的市场价格:");
        return new String(sc.next());
    }

    //获取输入的汽车日租金
    private static String getRent(){
        System.out.println("请输入汽车的日租金:");
        return new String(sc.next());
    }

    //获取输入的汽车的租赁状态
    private static String getStatus(){
        System.out.println("请输入汽车的租赁状态(0:可租\t非0:已租出):");
        return new String(sc.next());
    }

    //获取输入的汽车的上下架状态
    private static String getUseable(){
        System.out.println("请输入汽车的上下架状态(0:上架\t非0:已下架):");
        return new String(sc.next());
    }

    //获取输入的验证码
    private static String getVerifyCode(){
        System.out.println("请输入验证码:(注意区分大小写)");
        return new String(sc.next());
    }

    //获取输入的用户名
    private static String getUserName(){
        System.out.println("请输入您的用户名:");
        return new String(sc.next());
    }

    //获取输入的密码
    private static String getPassword(){
        System.out.println("请输入您的密码:");
        return new String(sc.next());
    }

    //获取输入的验证密码
    private static String getVerifyPassword(){
        System.out.println("请再次确认您的密码:");
        return new String(sc.next());
    }

    //获取输入的性别
    private static String getSex(){
        System.out.println("请输入您的性别:");
        return new String(sc.next());
    }

    //获取输入的身份证号
    private static String getIDNumber(){
        System.out.println("请输入您的身份证号:");
        return new String(sc.next());
    }

    //获取输入的电话号码
    private static String getTel(){
        System.out.println("请输入电话号码:");
        return new String(sc.next());
    }

    //获取输入的地址
    private static String getAddress(){
        System.out.println("请输入您的地址:");
        return new String(sc.next());
    }

    //获取输入的汽车编号
    private static String getCarID(){
        System.out.println("请输入汽车的编号:");
        return new String(sc.next());
    }

    //获取输入的租车天数
    private static String getRentDays(){
        System.out.println("请输入要租的天数:");
        return new String(sc.next());
    }

    //按下回车继续
    private static void toBeContinue(){
        System.out.println("...按下回车继续...");
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //生成验证码
    public static String verifyCode(){
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        for(int count=0;count<=3;count++) {
            int i = r.nextInt(3);
            switch(i){
                case 0:
                    int j = r.nextInt(10);
                    sb.append(j);
                    break;
                case 1:
                    char ch = (char)(r.nextInt(26)+65);
                    sb.append(ch);
                    break;
                case 2:
                    char ch1 = (char)(r.nextInt(26)+97);
                    sb.append(ch1);
                    break;
            }
        }
        return new String(sb);
    }

    //发送请求与数据给服务器端
    private static Object sendRequest(String function){
        Object feedBack=null;
        message=new message();
        message.setFunction(function);
        message.setData(data);
        try {
            socket=new Socket("127.0.0.1",9878);
            os=socket.getOutputStream();
            oos=new ObjectOutputStream(os);
            oos.writeObject(message);
            is=socket.getInputStream();
            ois=new ObjectInputStream(is);
            message receive = (message) ois.readObject();
            Map receiveData = receive.getData();
            feedBack =  receiveData.get(function);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return feedBack;


    }
}