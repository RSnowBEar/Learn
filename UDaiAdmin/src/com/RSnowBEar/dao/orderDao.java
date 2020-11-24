package com.RSnowBEar.dao;

import com.RSnowBEar.entity.OrderDetailInfo;
import com.RSnowBEar.entity.Orderinfo;

import java.util.List;

public interface orderDao {
    //查询所有数据的总条数
    public Integer countAll();

    //分页查询
    public List<OrderDetailInfo> queryLimit(Integer currentPage, Integer rows);

    //按照ID查询订单
    public List<OrderDetailInfo> selectOrderByID(Orderinfo order);

    //添加订单
    public int insertOrder(Orderinfo order);

    //修改订单
    public int updateOrder(Orderinfo order);

    //删除订单
    public int deleteOrder(Orderinfo order);
}
