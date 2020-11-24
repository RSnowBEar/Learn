package com.RSnowBEar.service;

import com.RSnowBEar.entity.Product;
import com.RSnowBEar.entity.ProductDetailInfo;
import com.RSnowBEar.entity.Productsku;
import com.RSnowBEar.entity.pageBean;

import java.util.List;

public interface productService {

    //分页查询
    public pageBean<Product> queryLimit(String currentPage, String rows);

    //添加商品表信息
    public boolean insertProduct(Product product,List<Productsku> list);

    //根据商品名和类型编号查询商品
    public List<Product> selectProductByNameAndCID(Product product);

    //查询商品详情
    public List<ProductDetailInfo> queryProductDetail(Product product);

    //删除商品
    public boolean deleteProduct(Product product);
}
