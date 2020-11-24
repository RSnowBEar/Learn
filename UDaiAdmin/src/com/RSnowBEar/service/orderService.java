package com.RSnowBEar.service;

import com.RSnowBEar.entity.OrderDetailInfo;
import com.RSnowBEar.entity.pageBean;

public interface orderService {
    //分页查询
    public pageBean<OrderDetailInfo> queryLimit(String currentPage, String rows);
}
