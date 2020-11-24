package com.dao.daoImpl;

import com.entity.*;
import com.dao.adminDao;
import com.util.jdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 管理员操作访问数据实现类
 */
public class adminDaoImpl implements adminDao {
    private JdbcTemplate temp = jdbcUtil.getJdbcTemplate();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //登录
    @Override
    public List login(String userName, String Pwd) {
        List<user> query = temp.query("select * from user where username=? and password=? and type=?",
                new BeanPropertyRowMapper<>(user.class),
                userName, Pwd,1);
        return query;
    }

    //查询汽车
    @Override
    public List selectCar(Integer selectNum,Integer cid) {
        List<selectCarAll> query=null;
        if(selectNum!=2){
            query =temp.query(getSQL(selectNum),
                    new BeanPropertyRowMapper<>(selectCarAll.class));
        }else{
            query =temp.query(getSQL(selectNum),
                    new BeanPropertyRowMapper<>(selectCarAll.class),
                    cid);
        }
        return query;
    }

    //生成查询的SQL语句
    @Override
    public String getSQL(Integer selectNum) {
        StringBuffer sql=new StringBuffer("select c.id,c.car_num,brand.name 'brand_name',c.model,c.color,cate.name 'category_name',c.comments,c.price,c.rent,c.status,c.useable " +
                "from category cate,car c,brand " +
                "where cate.id=c.category_id and brand.id=c.brand_id ");
        switch(selectNum){
            //查询所有
            case 1:
                sql.append("order by c.id ");
                break;

            //根据汽车编号查询
            case 2:
                sql.append("and c.id=? order by c.id ");
                break;

            //根据上下架情况查询
            case 3:
                sql.append("order by useable asc ");
                break;

            //根据汽车状态查询
            case 4:
                sql.append("order by status asc ");
                break;
        }
        return new String(sql);
    }

    //添加汽车
    @Override
    public int insertCar(car car) {
        int update = temp.update("insert into car values (default,?,?,?,?,?,?,?,?,?,?)",
                car.getCar_num(), car.getBrand_id(), car.getModel(), car.getColor(), car.getCategory_id(),
                car.getComments(), car.getPrice(), car.getRent(), car.getStatus(), car.getUseable());
        return update;
    }

    //通过车牌号查询汽车
    @Override
    public List selectCarByCar_Num(String car_num) {
        List query = temp.query("select * from car where car_num=?",
                new BeanPropertyRowMapper<>(car.class),
                car_num);
        return query;
    }

    //通过品牌编号查询品牌
    @Override
    public List selectBrandByID(Integer ID) {
        List<brand> query = temp.query("select * from brand where id=?",
                new BeanPropertyRowMapper<>(brand.class),
                ID);
        return query;
    }

    //通过汽车类型编号查询类型
    @Override
    public List selectCategoryByID(Integer ID) {
        List<category> query = temp.query("select * from category where id=?",
                new BeanPropertyRowMapper<>(category.class),
                ID);
        return query;
    }

    //修改汽车
    @Override
    public int upadteCar(Integer updateNum,Integer cid,Object obj) {
        int update = temp.update(getupdateCarSql(updateNum),
                obj, cid);
        return update;
    }

    //生成修改汽车的sql语句
    @Override
    public String getupdateCarSql(Integer updateNum) {
        StringBuffer sql = new StringBuffer("update car set ");
        switch(updateNum){

            //修改车牌号
            case 1:
                sql.append("car_num=? ");
                break;

            //修改品牌编号
            case 2:
                sql.append("brand_id=? ");
                break;

            //修改汽车型号
            case 3:
                sql.append("model=? ");
                break;

            //修改汽车类型编号
            case 4:
                sql.append("category_id=? ");
                break;

            //修改汽车颜色
            case 5:
                sql.append("color=? ");
                break;

            //修改汽车描述
            case 6:
                sql.append("comments=?" );
                break;

            //修改汽车市场价
            case 7:
                sql.append("price=? ");
                break;

            //修改日租金
            case 8:
                sql.append("rent=? ");
                break;

            //修改租赁状态
            case 9:
                sql.append("status=? ");
                break;

            //修改汽车上下架状态
            case 10:
                sql.append("useable=? ");
                break;
        }
        sql.append("where id=? ");
        return new String(sql);
    }

    //通过汽车编号查询汽车
    @Override
    public List selectCarByID(Integer ID) {
        List<car> query = temp.query("select * from car where id=?",
                new BeanPropertyRowMapper<>(car.class),
                ID);
        return query;
    }

    //通过汽车编号查询该车是否被租出
    @Override
    public List selectCarStatusByID(Integer ID) {
        List<car> query = temp.query("select * from car where id=? and status=0",
                new BeanPropertyRowMapper<>(car.class),ID);
        return query;
    }

    //查询租赁记录表
    @Override
    public List selectRecordAll(Integer selectNum,Integer ID) {
        List<selectRecord> query=null;
        if(selectNum==2 ||selectNum==3){
            query = temp.query(getSelectRecordSql(selectNum),
                    new BeanPropertyRowMapper<>(selectRecord.class),
                    ID);
        }else{
            query = temp.query(getSelectRecordSql(selectNum),
                    new BeanPropertyRowMapper<>(selectRecord.class));
        }
        return query;
    }

    //生成查询记录表的sql语句
    @Override
    public String getSelectRecordSql(Integer selectNum) {
        StringBuffer sql = new StringBuffer("select r.id,r.user_id,u.username,r.car_id,c.car_num,c.model,c.color,start_date,return_date,payment from record r,user u,car c where r.user_id=u.id and r.car_id=c.id ");
        switch(selectNum){
            //查询全部
            case 1:
                sql.append("order by id");
                break;

            //根据用户编号查询
            case 2:
                sql.append("and user_id=?");
                break;

            //按照汽车编号查询
            case 3:
                sql.append("and car_id=?");
                break;

            //按照支付租金排序
            case 4:
                sql.append("order by payment desc");
                break;
        }
        return new String(sql);
    }

    //查询品牌表
    @Override
    public List selectBrandAll() {
        List<brand> query = temp.query("select * from brand order by id", new BeanPropertyRowMapper<>(brand.class));
        return query;
    }

    //查询汽车类别表
    @Override
    public List selectCategoryAll() {
        List<category> query = temp.query("select * from category", new BeanPropertyRowMapper<>(category.class));
        return query;
    }

    //查询user表的非管理用户的用户编号
    @Override
    public List selectUser() {
        List<user> query = temp.query("select * from user where type=0", new BeanPropertyRowMapper<>(user.class));
        return query;
    }

    //通过品牌名称查询该品牌是否存在
    @Override
    public List selectBrandByName(String brandName) {
        List<brand> query = temp.query("select * from brand where name=?", new BeanPropertyRowMapper(brand.class), brandName);
        return query;
    }

    //添加品牌
    @Override
    public int insertBrand(String brandName) {
        int update = temp.update("insert into brand values (default,?)", brandName);
        return update;
    }

    //通过类型名称查询汽车类型是否存在
    @Override
    public List selectCategoryByName(String categoryName) {
        List<category> query = temp.query("select * from category where name=?", new BeanPropertyRowMapper<>(category.class), categoryName);
        return query;
    }

    //添加汽车类型
    @Override
    public int insertCategory(String categoryName) {
        int update = temp.update("insert into category values (default,?)", categoryName);
        return update;
    }
}
