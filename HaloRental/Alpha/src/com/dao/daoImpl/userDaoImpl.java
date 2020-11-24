package com.dao.daoImpl;

import com.dao.userDao;
import com.entity.*;
import com.util.jdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 用户操作数据访问层实现类
 */
public class userDaoImpl implements userDao {
    private JdbcTemplate temp = jdbcUtil.getJdbcTemplate();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //登录
    @Override
    public List login(String username,String password) {
        List<user> query = temp.query(
                "select * from user where username=? and password=? and type=?",
                new BeanPropertyRowMapper<>(user.class),
                username, password,0);
        return query;
    }


    //注册
    @Override
    public int register(user user){
        int update = temp.update(
                "insert into user values (default,?,?,?,?,?,?,?)",
                user.getUsername(), user.getPassword(), user.getSex(), user.getId_number(),
                user.getTel(), user.getAddress(), user.getType());
        return update;
    }

    //查询所有汽车信息
    @Override
    public List selectCarAll(Integer selectNum,Integer type) {
        List<selectCarAll> query=null;
        query = temp.query(getqueryCarSql(selectNum,type),
                    new BeanPropertyRowMapper<>(selectCarAll.class));
        return query;
    }

    //拼接查询汽车语句
    private String getqueryCarSql(Integer selectNum,Integer type){
        StringBuffer sql=new StringBuffer("select c.id,c.car_num,brand.name 'brand_name',c.model,c.color,cate.name 'category_name',c.comments,c.price,c.rent,c.status,c.useable " +
                "from category cate,car c,brand " +
                "where cate.id=c.category_id and brand.id=c.brand_id ");
        if(type==0)
            sql.append("and useable=0 ");
        switch(selectNum){
            //查询全部
            case 1:
                sql.append("order by c.id");
                break;

            //查询全部已上架车辆(废弃)
            case 2:
                break;

            //按照租金升序
            case 3:
                sql.append("order by rent asc");
                break;

            //按照租金降序
            case 4:
                sql.append("order by rent desc");
                break;

            //按照市场价升序
            case 5:
                sql.append("order by price asc");
                break;

            //按照市场价降序
            case 6:
                sql.append("order by price desc");
                break;

            //按照车型排序
            case 7:
                sql.append("order by model");
                break;

            //按照品牌排序
            case 8:
                sql.append("order by brand_name");
                break;

            //按照颜色排序
            case 9:
                sql.append("order by color");
                break;
        }
        return new String(sql);
    }

    //租赁汽车
    @Override
    public int rentCar(Integer cid,Integer uid,String start_date,String return_date) throws SQLException {
        Connection conn = getconn();
        PreparedStatement ps=null;
        try{
            //开启事务
            conn.setAutoCommit(false);

            ps = conn.prepareStatement("update car set status=? where id=?");
            ps.setInt(1, 1);
            ps.setInt(2, cid);
            int updateCar = ps.executeUpdate();

            ps = conn.prepareStatement("insert into record values(default,?,?,?,?,null)");
            ps.setInt(1,uid);
            ps.setInt(2,cid);
            ps.setString(3,start_date);
            ps.setString(4,return_date);
            int updateRecord = ps.executeUpdate();

            if(updateCar>0 && updateRecord>0){
                conn.commit();
                return 1;
            }
        }catch(Exception e){
            conn.rollback();
            e.printStackTrace();
        }finally {
            conn.close();
        }
        return 0;
    }

    //通过车辆编号查找汽车是否可以被租出
    @Override
    public List<car> selectCarCanOrNotRentByCarID(Integer cid) {
        List<car> query = temp.query("select * from car where id=? and status=? and useable=?",
                new BeanPropertyRowMapper<>(car.class),
                cid,0,0);
        return query;
    }

    //归还汽车
    @Override
    public int returnCar(Integer uid,Integer cid,String return_date,Float payment) throws SQLException {
        Connection conn = getconn();
        PreparedStatement ps=null;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("update car set status=? where id=?");
            ps.setInt(1, 0);
            ps.setInt(2, cid);
            int updateCar = ps.executeUpdate();

            ps = conn.prepareStatement("update record set return_date=?,payment=? where user_id=? and car_id=? and payment is null");
            ps.setString(1, return_date);
            ps.setFloat(2, payment);
            ps.setInt(3, uid);
            ps.setInt(4, cid);
            int updateRecord = ps.executeUpdate();
            if (updateCar > 0 && updateRecord > 0) {
                conn.commit();
                return 1;
            }
        }catch (Exception e){
            e.printStackTrace();
            conn.rollback();
        }finally {
            ps.close();
            conn.close();
        }
        return 0;
    }

    //通过车辆编号查询该车是否未归还
    @Override
    public List selectCarCanOrNotReturnByCID(Integer cid) {
        List<record> query = temp.query("select * from record where payment is null and car_id=?",
                new BeanPropertyRowMapper<>(record.class),
                cid);
        return query;
    }

    //通过用户名查找用户
    public List selectUserByUserName(String username){
        List<user> query = temp.query("select * from user where username=?",
                new BeanPropertyRowMapper<>(user.class),
                username);
        return query;
    }

    //通过编号返回车辆
    @Override
    public List selectCarByCID(Integer cid) {
        List<car> query = temp.query("select * from car where id=?",
                new BeanPropertyRowMapper<>(car.class),
                cid);
        return query;
    }

    //查询租赁记录
    @Override
    public List selectRecord(Integer uid) {
        List<selectRecord> query = temp.query("select r.id,r.user_id,u.username,r.car_id,c.car_num,c.model,c.color,start_date,return_date,payment from record r,user u,car c where r.user_id=u.id and r.car_id=c.id and r.user_id=? order by r.id",
                new BeanPropertyRowMapper<>(selectRecord.class),
                uid);
        return query;
    }

    //从框架获取conn对象
    @Override
    public Connection getconn() throws SQLException {
        return temp.getDataSource().getConnection();
    }
}
