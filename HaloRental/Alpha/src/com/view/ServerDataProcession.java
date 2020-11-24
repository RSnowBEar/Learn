package com.view;

import com.CustomException.*;
import com.entity.*;
import com.logging.PrintException;
import com.logging.PrintLogging;
import com.service.serviceImpl.adminServiceImpl;
import com.service.serviceImpl.userServiceImpl;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 服务器数据处理类
 */
public class ServerDataProcession extends Thread{
    private static userServiceImpl usi = new userServiceImpl();
    private static adminServiceImpl asi = new adminServiceImpl();
    private static message message;
    private static Map data;

    private static InputStream is;
    private static OutputStream os;
    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;
    private static Socket accept;
    private static List<selectCarAll> userQueryCarList;
    private static List<selectRecord> userQueryRecordList;
    private static List<selectCarAll> adminQueryCarList;
    private static List<selectRecord> adminQueryRecordList;
    private static List<brand> adminQueryBrandList;
    private static List<category> adminQueryCategoryList;

    public ServerDataProcession(Socket socket) {
        accept=socket;
        userQueryCarList = new LinkedList<>();
        userQueryRecordList = new LinkedList<>();
        adminQueryCarList = new LinkedList<>();
        adminQueryRecordList = new LinkedList<>();
        adminQueryBrandList = new LinkedList<>();
        adminQueryCategoryList = new LinkedList<>();
    }

    //主线程
    @Override
    public void run() {
        try {
            is = accept.getInputStream();
            ois = new ObjectInputStream(is);
            message message = (message) ois.readObject();
            switch (message.getFunction()) {
                //用户登录请求
                case "userLogin":
                    data = message.getData();
                    boolean userLogin=false;
                    try {
                        userLogin = usi.login((String) data.get("userName"),
                                (String) data.get("password"));
                    }catch(LoginException e){
                        PrintException.outputException(e,accept);
                    }
                    PrintLogging.outputLogging((String) data.get("userName"), message.getFunction());
                    sendFeedBack(accept,message.getFunction(),userLogin);
                    break;

                //用户注册请求
                case "userRegister":
                    data =message.getData();
                    boolean userRegister=false;
                    try {
                        userRegister = usi.register((String) data.get("userName"),
                                (String) data.get("Pwd"),
                                (String) data.get("VifPwd"),
                                (String) data.get("Sex"),
                                (String) data.get("IDNumber"),
                                (String) data.get("Tel"),
                                (String) data.get("Address"));
                    }catch (UserRegisterException e){
                        PrintException.outputException(e,accept);
                    }
                    PrintLogging.outputLogging((String) data.get("userName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),userRegister);
                    break;

                //管理员登录请求
                case "adminLogin":
                    data=message.getData();
                    boolean adminLogin=false;
                    try {
                        adminLogin = asi.login((String) data.get("adminName"),
                                (String) data.get("adminPwd"));
                    }catch(LoginException e){
                        PrintException.outputException(e,accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept,message.getFunction(), adminLogin);
                    break;

                //用户查询所有车辆
                case "userQueryCarAll":
                    data=message.getData();
                    userQueryCarList = usi.queryCarAll(1, (String) data.get("userName"));
                    PrintLogging.outputLogging((String) data.get("userName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),userQueryCarList);
                    break;

                //用户查询所有车辆，按日租金升序
                case "userQueryCarOrderByRentAsc":
                    data=message.getData();
                    userQueryCarList = usi.queryCarAll(3, (String) data.get("userName"));
                    PrintLogging.outputLogging((String) data.get("userName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),userQueryCarList);
                    break;

                //用户查询所有车辆，按日租金降序序
                case "userQueryCarOrderByRentDesc":
                    data=message.getData();
                    userQueryCarList = usi.queryCarAll(4,(String) data.get("userName"));
                    PrintLogging.outputLogging((String) data.get("userName"), message.getFunction());
                    sendFeedBack(accept,message.getFunction(),userQueryCarList);
                    break;

                //用户查询所有车辆，按市场价升序
                case "userQueryCarOrderByPriceAsc":
                    data=message.getData();
                    userQueryCarList = usi.queryCarAll(5, (String) data.get("userName"));
                    PrintLogging.outputLogging((String) data.get("userName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),userQueryCarList);
                    break;

                //用户查询所有车辆，按市场价降序
                case "userQueryCarOrderByPriceDesc":
                    data=message.getData();
                    userQueryCarList = usi.queryCarAll(6, (String) data.get("userName"));
                    PrintLogging.outputLogging((String) data.get("userName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),userQueryCarList);
                    break;

                //用户查询所有车辆，按车型升序
                case "userQueryCarOrderByCategory":
                    data=message.getData();
                    userQueryCarList = usi.queryCarAll(7, (String) data.get("userName"));
                    PrintLogging.outputLogging((String) data.get("userName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),userQueryCarList);
                    break;

                //用户查询所有车辆，按品牌升序
                case "userQueryCarOrderByBrand":
                    data=message.getData();
                    userQueryCarList = usi.queryCarAll(8, (String) data.get("userName"));
                    PrintLogging.outputLogging((String) data.get("userName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),userQueryCarList);
                    break;

                //用户查询所有车辆，按品牌升序
                case "userQueryCarOrderByColor":
                    data=message.getData();
                    userQueryCarList = usi.queryCarAll(9, (String) data.get("userName"));
                    PrintLogging.outputLogging((String) data.get("userName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),userQueryCarList);
                    break;

                //用户租车
                case "userRent":
                    data=message.getData();
                    boolean userRent=false;
                    try {
                        userRent = usi.rentCar((String) data.get("userName"),
                                Integer.parseInt(String.valueOf(data.get("carID"))),
                                Integer.parseInt(String.valueOf(data.get("rentDays"))));
                    }catch (UserRentException e){
                        PrintException.outputException(e,accept);
                    }
                    PrintLogging.outputLogging((String) data.get("userName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),userRent);
                    break;

                //用户查询租赁记录
                case "userQueryRecord":
                    data=message.getData();
                    userQueryRecordList = usi.selectRecord((String) data.get("userName"));
                    PrintLogging.outputLogging((String) data.get("userName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(), userQueryRecordList);
                    break;

                //用户还车
                case "userReturn":
                    data=message.getData();
                    boolean userReturn=false;
                    try {
                        userReturn = usi.returnCar((String) data.get("userName"),
                                Integer.parseInt(String.valueOf(data.get("carID"))));
                    }catch(UserReturnException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("userName"), message.getFunction());
                    sendFeedBack(accept,message.getFunction(),userReturn);
                    break;

                //管理员查询所有汽车
                case "adminQueryCarAll":
                    data=message.getData();
                    adminQueryCarList = asi.selectCar(1,0);
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),adminQueryCarList);
                    break;

                //管理员通过车辆编号查询汽车
                case "adminQueryCarByID":
                    data=message.getData();
                    try {
                        adminQueryCarList = asi.selectCar(2,
                                Integer.parseInt(String.valueOf(data.get("carID"))));
                    }catch (AdminQueryCarException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(), adminQueryCarList);
                    break;

                //管理员查询汽车按照上下架情况
                case "adminQueryCarOrderByUseable":
                    data=message.getData();
                    adminQueryCarList = asi.selectCar(3,0);
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),adminQueryCarList);
                    break;

                //管理员查询汽车按照租赁状态
                case "adminQueryCarOrderByStatus":
                    data=message.getData();
                    adminQueryCarList = asi.selectCar(4,0);
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),adminQueryCarList);
                    break;

                //管理员查询品牌表
                case "adminQueryBrandAll":
                    data=message.getData();
                    adminQueryBrandList= asi.selectBrand();
                    PrintLogging.outputLogging((String)data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(), adminQueryBrandList);
                    break;

                //管理员查询汽车类型表
                case "adminQueryCategoryAll":
                    data=message.getData();
                    adminQueryCategoryList = asi.selectCategory();
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept,message.getFunction(),adminQueryCategoryList);
                    break;

                //管理员添加汽车
                case "adminInsertCar":
                    data=message.getData();
                    boolean adminCreateCar =false;
                    try {
                        adminCreateCar = asi.createCar((String) data.get("car_num"),
                                Integer.parseInt(String.valueOf(data.get("brand_id"))),
                                (String) data.get("model"),
                                (String) data.get("color"),
                                Integer.parseInt(String.valueOf(data.get("category_id"))),
                                (String) data.get("comments"),
                                Float.parseFloat(String.valueOf(data.get("price"))),
                                Float.parseFloat(String.valueOf(data.get("rent"))),
                                Integer.parseInt(String.valueOf(data.get("status"))),
                                Integer.parseInt(String.valueOf(data.get("useable"))));
                    }catch (AdminInsertCarException e){
                        PrintException.outputException(e, accept);
                    }catch (NumberFormatException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(), adminCreateCar);
                    break;

                //管理员修改车牌号
                case "adminUpdateCar_Num":
                    data=message.getData();
                    boolean adminUpdateCar_Num = false;
                    try {
                        adminUpdateCar_Num = asi.modifyCarByID(1,
                                Integer.parseInt(String.valueOf(data.get("cid"))),
                                data.get("car_num"));
                    }catch (AdminUpdateCarException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),adminUpdateCar_Num);
                    break;

                //管理员修改品牌编号
                case "adminUpdateBrand_id":
                    data=message.getData();
                    boolean adminUpdateBrand_id = false;
                    try {
                        adminUpdateBrand_id = asi.modifyCarByID(2,
                                Integer.parseInt(String.valueOf(data.get("cid"))),
                                data.get("brand_id"));
                    }catch (AdminUpdateCarException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),adminUpdateBrand_id);
                    break;

                //管理员修改汽车型号
                case "adminUpdateModel":
                    data=message.getData();
                    boolean adminUpdateModel = false;
                    try {
                        adminUpdateModel = asi.modifyCarByID(3,
                                Integer.parseInt(String.valueOf(data.get("cid"))),
                                data.get("model"));
                    }catch (AdminUpdateCarException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),adminUpdateModel);
                    break;

                //管理员修改汽车类型编号
                case "adminUpdateCategory_id":
                    data=message.getData();
                    boolean adminUpdateCategory_id = false;
                    try {
                        adminUpdateCategory_id = asi.modifyCarByID(4,
                                Integer.parseInt(String.valueOf(data.get("cid"))),
                                data.get("category_id"));
                    }catch (AdminUpdateCarException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),adminUpdateCategory_id);
                    break;

                //管理员修改汽车颜色
                case "adminUpdateColor":
                    data=message.getData();
                    boolean adminUpdateColor = false;
                    try {
                        adminUpdateColor = asi.modifyCarByID(5,
                                Integer.parseInt(String.valueOf(data.get("cid"))),
                                data.get("color"));
                    }catch (AdminUpdateCarException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),adminUpdateColor);
                    break;

                //管理员修改描述
                case "adminUpdateComments":
                    data=message.getData();
                    boolean adminUpdateComments = false;
                    try {
                        adminUpdateComments = asi.modifyCarByID(6,
                                Integer.parseInt(String.valueOf(data.get("cid"))),
                                data.get("comments"));
                    }catch (AdminUpdateCarException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),adminUpdateComments);
                    break;

                //管理员修改市场价格
                case "adminUpdatePrice":
                    data=message.getData();
                    boolean adminUpdatePrice = false;
                    try {
                        adminUpdatePrice = asi.modifyCarByID(7,
                                Integer.parseInt(String.valueOf(data.get("cid"))),
                                data.get("price"));
                    }catch (AdminUpdateCarException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),adminUpdatePrice);
                    break;

                //管理员修改日租金
                case "adminUpdateRent":
                    data=message.getData();
                    boolean adminUpdateRent = false;
                    try {
                        adminUpdateRent = asi.modifyCarByID(8,
                                Integer.parseInt(String.valueOf(data.get("cid"))),
                                data.get("rent"));
                    }catch (AdminUpdateCarException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),adminUpdateRent);
                    break;

                //管理员修改租赁状态
                case "adminUpdateStatus":
                    data=message.getData();
                    boolean adminUpdateStatus = false;
                    try {
                        adminUpdateStatus = asi.modifyCarByID(9,
                                Integer.parseInt(String.valueOf(data.get("cid"))),
                                data.get("status"));
                    }catch (AdminUpdateCarException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(), adminUpdateStatus);
                    break;

                //管理员修改上下架状态
                case "adminUpdateUseable":
                    data=message.getData();
                    boolean adminUpdateUseable = false;
                    try {
                        adminUpdateUseable = asi.modifyCarByID(10,
                                Integer.parseInt(String.valueOf(data.get("cid"))),
                                data.get("useable"));
                    }catch (AdminUpdateCarException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),adminUpdateUseable);
                    break;

                //管理员查询所有非管理员用户
                case "adminQueryUserAll":
                    data=message.getData();
                    List adminQueryUserList = asi.selectUser();
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(),adminQueryUserList);
                    break;

                    //管理员查询记录表全部
                case "adminQueryRecordAll":
                    data=message.getData();
                    adminQueryRecordList = asi.selectRecord(1,-1);
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept,message.getFunction(),adminQueryRecordList);
                    break;

                //管理员根据用户编号查询记录表
                case "adminQueryRecordByUID":
                    data=message.getData();
                    try {
                        adminQueryRecordList = asi.selectRecord(2,
                                Integer.parseInt(String.valueOf(data.get("ID"))));
                    }catch (AdminQueryRecordException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept,message.getFunction(),adminQueryRecordList);
                    break;

                //管理员根据车辆编号查询记录表
                case "adminQueryRecordByCID":
                    data=message.getData();
                    try {
                        adminQueryRecordList = asi.selectRecord(3,
                                Integer.parseInt(String.valueOf(data.get("ID"))));
                    }catch (AdminQueryRecordException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(), adminQueryRecordList);
                    break;
                //管理员按照支付金额排序记录表
                case "adminQueryRecordByPay":
                    data=message.getData();
                    adminQueryRecordList = asi.selectRecord(4,-1);
                    PrintLogging.outputLogging((String) data.get("adminName"), message.getFunction());
                    sendFeedBack(accept,message.getFunction(),adminQueryRecordList);
                    break;

                //添加品牌
                case "adminInsertBrand":
                    data=message.getData();
                    boolean adminInsertBrand = false;
                    try {
                        adminInsertBrand = asi.insertBrand((String) data.get("brandName"));
                    }catch (AdminInsertBrandException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String) data.get("userName"),message.getFunction());
                    sendFeedBack(accept, message.getFunction(),adminInsertBrand);
                    break;

                case "adminInsertCategory":
                    data=message.getData();
                    boolean adminInsertCategory = false;
                    try{
                        adminInsertCategory = asi.insertCategory((String) data.get("categoryName"));
                    }catch (AdminInsertCategoryException e){
                        PrintException.outputException(e, accept);
                    }
                    PrintLogging.outputLogging((String)data.get("userName"), message.getFunction());
                    sendFeedBack(accept, message.getFunction(), adminInsertCategory);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //发送反馈到客户端
    private static void sendFeedBack(Socket accept,String function,Object value){
        try {
            os = accept.getOutputStream();
            oos = new ObjectOutputStream(os);
            data = new HashMap();
            data.put(function,value);
            message = new message();
            message.setData(data);
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
