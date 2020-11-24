package com.service;

import com.entity.car;

import java.net.InetAddress;
import java.util.List;

/**
 * 管理员操作业务层
 */
public interface adminSerivce {
    //登录
    public boolean login(String userName,String Pwd);

    //查询汽车
    public List selectCar(Integer selectNum,Integer cid);

    //添加汽车
    public boolean createCar(String car_num,Integer brand_id,String model,String color,Integer category_id,String comments,Float price,Float rent,Integer status,Integer useable);

    //通过车牌号查询是否存在该汽车
    public boolean existsCarByCar_Num(String car_num);

    //通过品牌编号查询是否存在该品牌
    public boolean existsBrandByID(Integer ID);

    //通过汽车类型编号查询是否存在该类型
    public boolean existsCategoryByID(Integer ID);

    //根据车辆编号修改汽车
    public boolean modifyCarByID(Integer updateNum,Integer cid,Object obj);

    //根据车辆编号查询是否存在该汽车
    public boolean existsCarByID(Integer ID);

    //根据车辆编号车讯该车是否已租出
    public boolean queryCarStatusByCID(Integer ID);

    //查询租赁记录
    public List selectRecord(Integer selectNum,Integer ID);

    //查询品牌表
    public List selectBrand();

    //查询汽车类别表
    public List selectCategory();

    //查询user表的普通用户
    public List selectUser();

    //通过品牌名查询品牌是否存在
    public boolean existsBrandByName(String brandName);

    //添加品牌
    public boolean insertBrand(String brandName);

    //通过类型名称查询汽车类型是否存在
    public boolean existsCategoryByName(String categoryName);

    //添加汽车类型
    public boolean insertCategory(String categoryName);
}
