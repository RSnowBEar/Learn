package com.RSnowBEar.service.impl;

import com.RSnowBEar.dao.impl.productDaoImpl;
import com.RSnowBEar.dao.productDao;
import com.RSnowBEar.entity.*;
import com.RSnowBEar.service.productService;
import com.RSnowBEar.util.skuUtil;

import java.util.List;

public class productServiceImpl implements productService {
    productDao pd = new productDaoImpl();

    //分页查询
    @Override
    public pageBean<Product> queryLimit(String currentPage, String rows) {
        Integer totalSize = pd.countAll();
        pageBean<Product> pageBean = new pageBean<>();
        pageBean.setTotalSize(totalSize);
        List<Product> products = null;
        try{
            products = pd.queryLimit(Integer.parseInt(currentPage), Integer.parseInt(rows));
            pageBean.setCurrentPage(Integer.parseInt(currentPage));
        }catch (Exception e){
            products = pd.queryLimit(1,10);
            pageBean.setCurrentPage(1);
        }
        pageBean.setList(products);
        return pageBean;
    }

    //添加商品
    @Override
    public boolean insertProduct(Product product,List<Productsku> list) {
        int i = pd.insertNewProduct(product, list);
        if(i>0)
            return true;
        return false;
    }


    //根据商品名和类型编号查询商品
    @Override
    public List<Product> selectProductByNameAndCID(Product product) {
        return null;
    }

    //查询商品详情
    @Override
    public List<ProductDetailInfo> queryProductDetail(Product product){
        List<ProductDetailInfo> productDetailInfos = pd.selectProductDetail(product);
        for (ProductDetailInfo pdi : productDetailInfos) {
            pdi.setSkuAttribute(skuUtil.getSkuMap((String)pdi.getSkuAttribute()));
        }
        return productDetailInfos;
    }

    //删除商品
    @Override
    public boolean deleteProduct(Product product) {
        int i = pd.deleteProduct(product);
        if(i>0)
            return true;
        return false;
    }
}
