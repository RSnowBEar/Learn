package com.RSnowBEar.dao;

import com.RSnowBEar.entity.*;

import java.util.List;

/**
 * 商品管理控制模块接口
 */
public interface productDao {

    //查询所有数据的总条数
    public Integer countAll();

    //分页查询
    public List<Product> queryLimit(Integer currentPage, Integer rows);

    //按照商品名与类型
    public List<Product> selectProductByNameAndCID(Product product);

    //查询商品详情
    public List<ProductDetailInfo> selectProductDetail(Product product);

    //添加商品
    public int insertNewProduct(Product product,List<Productsku> productskus);

    //修改商品信息
    public int updateProductInfo(Product product);

    //修改商品详细信息
    public int updateProductDetailInfo(Productsku productsku);

    //删除商品
    public int deleteProduct(Product product);

    //查询商品规格(ID)
    public List<Productspecificationdic> selectProductspecificationdicByID(String specificationdicID);

    //查询商品规格(categoryID)
    public List<Productspecificationdic> selectProductspecificationdicByCID(Productcategorydic productcategorydic);

    //查询商品规格(Name,categoryID)
    public List<Productspecificationdic> selectProductspecificationdicByID(Productspecificationdic productspecificationdic);

    //查询商品规格值(ID)
    public List<Productspecificationvalues> selectProductspecificationvaluesByID(String specificationID);

    //查询商品规格值(specificationID)
    public List<Productspecificationvalues> selectProductspecificationvaluesBySID(Productspecificationdic productspecificationdic);

    //查询商品规格值(Name,specificationID)
    public List<Productspecificationvalues> selectProductspecificationvaluesBySIDAndName(Productspecificationvalues productspecificationvalues);

    //查询商品类别(ID)
    public List<Productcategorydic> selectProductCategoryByID(Productcategorydic productcategorydic);

    //查询商品类别(PID)
    public List<Productcategorydic> selectProductCategoryByPID(Productcategorydic productcategorydic);
}
