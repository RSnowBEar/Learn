package com.dao;

import com.entity.car;

import java.util.List;

/**
 * 管理员操作数据访问层
 */
public interface adminDao {
    //登录
    public List login(String userName,String Pwd);

    //查询汽车
    public List selectCar(Integer selectNum,Integer cid);

    //生成查询汽车的sql语句
    public String getSQL(Integer selectNum);

    //添加汽车
    public int insertCar(car car);

    //通过车牌号查询汽车
    public List selectCarByCar_Num(String car_num);

    //通过品牌编号查询品牌
    public List selectBrandByID(Integer ID);

    //通过汽车类型编号查询类型
    public List selectCategoryByID(Integer ID);

    //修改汽车
    public int upadteCar(Integer updateNum, Integer cid,Object obj);

    //生成修改汽车的sql语句
    public  String getupdateCarSql(Integer updateNum);

    //通过汽车编号查询汽车
    public List selectCarByID(Integer ID);

    //通过汽车编号查询该车是否被租出
    public List selectCarStatusByID(Integer ID);

    //查询租赁记录
    public List selectRecordAll(Integer selectNum,Integer ID);

    //生成查询记录表的sql语句
    public String getSelectRecordSql(Integer selectNum);

    //查询品牌表
    public List selectBrandAll();

    //查询汽车类别表
    public List selectCategoryAll();

    //查询user表的非管理用户
    public List selectUser();

    //通过品牌名称查询该品牌是否存在
    public List selectBrandByName(String brandName);

    //添加品牌
    public int insertBrand(String brandName);

    //通过类型名称查询汽车类型是否存在
    public List selectCategoryByName(String categoryName);

    //添加汽车类型
    public int insertCategory(String categoryName);
}
