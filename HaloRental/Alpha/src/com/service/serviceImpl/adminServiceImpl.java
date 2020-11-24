package com.service.serviceImpl;

import com.CustomException.*;
import com.dao.daoImpl.adminDaoImpl;
import com.entity.*;
import com.service.adminSerivce;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 管理员操作业务实现类
 */

public class adminServiceImpl implements adminSerivce {
    adminDaoImpl adi = new adminDaoImpl();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //登录
    @Override
    public boolean login(String userName, String Pwd) {
        List login = adi.login(userName, Pwd);
        if(login.size()!=0)
            return true;
        throw new LoginException("[管理员]用户名或密码有误");
    }

    //查询汽车
    /*
    selectNum为查询类别：
        1.查询所有
        2.通过汽车编号查询
        3.根据上下架情况查询
        4.根汽车状态查询
     */
    @Override
    public List selectCar(Integer selectNum,Integer cid) {
        List<selectCarAll> list = adi.selectCar(selectNum,cid);
        if(list.size()!=0) {
            return list;
        }
        throw new AdminQueryCarException("不存在此车");
    }

    //添加汽车
    @Override
    public boolean createCar(String car_num,Integer brand_id, String model, String color,Integer category_id, String comments, Float price, Float rent, Integer status, Integer useable) {
        if(!existsCarByCar_Num(car_num)){
            if(existsBrandByID(brand_id)){
                if(existsCategoryByID(category_id)){
                    car car = new car(car_num,brand_id,model,color,category_id,comments,price,rent,status,useable);
                    int i = adi.insertCar(car);
                    if(i>0)
                        return true;
                    throw new AdminInsertCarException("发生未知错误");
                }
                throw new AdminInsertCarException("不存在该编号的类型");
            }
            throw new AdminInsertCarException("不存在该编号的品牌");
        }
        throw new AdminInsertCarException("该车牌号已存在");
    }

    //通过车牌号查询是否存在该车(true为存在)
    @Override
    public boolean existsCarByCar_Num(String car_num) {
        List<car> list = adi.selectCarByCar_Num(car_num);
        if(list.size()!=0)
            return true;
        return false;
    }

    //通过品牌编号查询是否存在该品牌
    @Override
    public boolean existsBrandByID(Integer ID){
        List<brand> list = adi.selectBrandByID(ID);
        if(list.size()!=0)
            return true;
        return false;
    }

    //通过汽车类型编号查询是否存在该类型
    @Override
    public boolean existsCategoryByID(Integer ID) {
        List<category> list = adi.selectCategoryByID(ID);
        if(list.size()!=0)
            return true;
        return false;
    }

    //根据车辆编号修改汽车
    /*
        updateNum--修改编号
        1.修改车牌号
        2.修改品牌编号
        3.修改汽车型号
        4.修改类型编号
        5.修改颜色
        6.修改描述
        7.修改市场价
        8.修改日租金
        9.修改租赁状态
        10.修改上下架状态
     */
    @Override
    public boolean modifyCarByID(Integer updateNum,Integer cid,Object obj) {
        if(existsCarByID(cid)){
            if(queryCarStatusByCID(cid)) {
                boolean flag = true;
                if(updateNum == 1){
                    flag = !existsCarByCar_Num((String)obj);
                    if(!flag)
                        throw new AdminUpdateCarException("该车牌号已存在");
                }
                if (updateNum == 2) {
                    flag = existsBrandByID(Integer.parseInt(String.valueOf(obj)));
                    if(flag==false)
                        throw new AdminUpdateCarException("不存在该编号的品牌");
                }
                if (updateNum == 4) {
                    flag = existsCategoryByID(Integer.parseInt(String.valueOf(obj)));
                    if(flag==false)
                        throw new AdminUpdateCarException("不存在该编号的汽车类型");
                }
                if (flag) {
                    int i = adi.upadteCar(updateNum, cid,obj);
                    if (i > 0) {
                        return true;
                    }
                    throw  new AdminUpdateCarException("发生未知错误");
                }

            }
            throw new AdminUpdateCarException("无法修改已被租出的汽车");
        }
        throw new AdminUpdateCarException("该车不存在");
    }

    //根据车辆编号来查询是否存在该汽车
    @Override
    public boolean existsCarByID(Integer ID) {
        List<car> list = adi.selectCarByID(ID);
        if(list.size()!=0)
            return true;
        return false;
    }

    //根据车辆编号车讯该车是否已租出(true存在且为没有租出)
    @Override
    public boolean queryCarStatusByCID(Integer ID) {
        List list = adi.selectCarStatusByID(ID);
        if(list.size()!=0)
            return true;
        return false;
    }

    //查询租赁记录
    /*
        selectNum--查询编号
            1.查询全部
            2.按照用户编号
            3.按照汽车编号
            4.按照支付租金
     */
    @Override
    public List<selectRecord> selectRecord(Integer selectNum,Integer ID){
        List list = adi.selectRecordAll(selectNum,ID);
        if(list.size()!=0)
            return list;
        throw new AdminQueryRecordException("查询目标不存在");
    }

    //查询品牌表
    @Override
    public List selectBrand(){
        List list = adi.selectBrandAll();
        return list;
    }

    //查询汽车类别表
    @Override
    public List selectCategory() {
        List list = adi.selectCategoryAll();
        return list;
    }

    //查询user表的普通用户
    @Override
    public List selectUser() {
        List user = adi.selectUser();
        return user;
    }

    //通过品牌名查询品牌是否存在
    @Override
    public boolean existsBrandByName(String brandName) {
        List list = adi.selectBrandByName(brandName);
        if(list.size()>0)
            return true;
        return false;
    }

    //添加品牌
    @Override
    public boolean insertBrand(String brandName) {
        if(!existsBrandByName(brandName)){
            int i = adi.insertBrand(brandName);
            if(i>0){
                return true;
            }
            throw new AdminInsertBrandException("发生未知错误");
        }
        throw new AdminInsertBrandException("该品牌已存在");
    }

    //通过类型名称查询汽车类型是否存在
    @Override
    public boolean existsCategoryByName(String categoryName) {
        List list = adi.selectCategoryByName(categoryName);
        if(list.size()>0)
            return true;
        return false;
    }

    //添加汽车类型
    @Override
    public boolean insertCategory(String categoryName) {
        if(!existsCategoryByName(categoryName)){
            int i = adi.insertCategory(categoryName);
            if(i>0){
                return true;
            }
            throw new AdminInsertCategoryException("发生未知错误");
        }
        throw new AdminInsertCategoryException("该汽车类型已存在");
    }
}
