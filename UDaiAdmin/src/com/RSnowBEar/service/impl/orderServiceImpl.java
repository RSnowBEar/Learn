package com.RSnowBEar.service.impl;

import com.RSnowBEar.dao.impl.OrderDaoImpl;
import com.RSnowBEar.dao.orderDao;
import com.RSnowBEar.entity.OrderDetailInfo;
import com.RSnowBEar.entity.Product;
import com.RSnowBEar.entity.pageBean;
import com.RSnowBEar.service.orderService;

import java.util.List;

public class orderServiceImpl implements orderService {
    orderDao od = new OrderDaoImpl();

    //分页查询
    @Override
    public pageBean<OrderDetailInfo> queryLimit(String currentPage, String rows) {
        Integer totalSize = od.countAll();
        pageBean<OrderDetailInfo> pageBean = new pageBean<>();
        pageBean.setTotalSize(totalSize);
        List<OrderDetailInfo> orders = null;
        try{
            orders = od.queryLimit(Integer.parseInt(currentPage), Integer.parseInt(rows));
            pageBean.setCurrentPage(Integer.parseInt(currentPage));
        }catch (Exception e){
            orders = od.queryLimit(1,10);
            pageBean.setCurrentPage(1);
        }
        pageBean.setList(orders);
        return pageBean;
    }
}
