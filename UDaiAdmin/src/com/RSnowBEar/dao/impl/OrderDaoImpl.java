package com.RSnowBEar.dao.impl;

import com.RSnowBEar.dao.orderDao;
import com.RSnowBEar.entity.OrderDetailInfo;
import com.RSnowBEar.entity.Orderinfo;
import com.RSnowBEar.util.jdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderDaoImpl implements orderDao {
    JdbcTemplate temp = jdbcUtil.getJdbcTemplate();

    //查询所有数据的总条数
    @Override
    public Integer countAll() {
        Integer integer = temp.queryForObject("select count(orderID) from orderinfo",
                Integer.class);
        return integer;
    }

    //分页查询
    @Override
    public List<OrderDetailInfo> queryLimit(Integer currentPage, Integer rows) {
        String sql = "SELECT\n" +
                "\to.orderId,\n" +
                "\tu.userId,\n" +
                "\tu.phone,\n" +
                "\tua.addressId,\n" +
                "\tua.province,\n" +
                "\tua.city,\n" +
                "\tua.area,\n" +
                "\tua.town,\n" +
                "\tua.detail,\n" +
                "\tp.productID,\n" +
                "\tp.productName,\n" +
                "\tps.skuID,\n" +
                "\tps.skuAttribute,\n" +
                "\tps.price,\n" +
                "\to.buyNum,\n" +
                "\to.discountPrice,\n" +
                "\to.status,\n" +
                "\to.buyTime\n" +
                "FROM\n" +
                "\tuser u,\n" +
                "\tuseraddress ua,\n" +
                "\tproduct p,\n" +
                "\tproductsku ps,\n" +
                "\torderinfo o \n" +
                "WHERE\n" +
                "\tu.userId=o.userId \n" +
                "AND\n" +
                "\tps.skuID=o.skuID\n" +
                "AND\n" +
                "\tp.productID=ps.productID\n" +
                "AND\n" +
                "\tua.addressId=o.addressId\n" +
                "LIMIT ?,?";
        List<OrderDetailInfo> query = temp.query(sql,
                new BeanPropertyRowMapper<>(OrderDetailInfo.class),
                (currentPage - 1) * 10, rows);
        return query;
    }

    //按照ID查询订单
    @Override
    public List<OrderDetailInfo> selectOrderByID(Orderinfo order) {

        return null;
    }

    //添加订单
    @Override
    public int insertOrder(Orderinfo order) {
        return 0;
    }

    //修改订单
    @Override
    public int updateOrder(Orderinfo order) {
        return 0;
    }

    //删除订单
    @Override
    public int deleteOrder(Orderinfo order) {
        return 0;
    }
}
