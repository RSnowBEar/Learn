package com.RSnowBEar.dao.impl;

import com.RSnowBEar.dao.productDao;
import com.RSnowBEar.entity.*;
import com.RSnowBEar.util.jdbcUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class productDaoImpl implements productDao {
    JdbcTemplate temp = jdbcUtil.getJdbcTemplate();
    //查询所有数据的总条数
    @Override
    public Integer countAll() {
        Integer integer = temp.queryForObject("select count(productID) from product",
                Integer.class);
        return integer;
    }

    //分页查询
    @Override
    public List<Product> queryLimit(Integer currentPage, Integer rows) {
        List<Product> query = temp.query("select * from product limit ?,?",
                new BeanPropertyRowMapper<>(Product.class),
                (currentPage - 1) * 10, rows);
        return query;
    }

    //查询商品信息(productName,categoryID)
    @Override
    public List<Product> selectProductByNameAndCID(Product product) {
        List<Product> query = temp.query("select * from product where productName=? and categoryID=?",
                new BeanPropertyRowMapper<>(Product.class),
                product.getProductName(),
                product.getCategoryID());
        return query;
    }

    //查询商品详情
    @Override
    public List<ProductDetailInfo> selectProductDetail(Product product) {
        String sql = "select \n" +
                "\tp.productID,\n" +
                "\tp.productName,\n" +
                "\tpc.categoryID,\n" +
                "\tpc.categoryName,\n" +
                "\tp.shelfTime,\n" +
                "\tps.skuID,\n" +
                "\tps.skuAttribute,\n" +
                "\tps.price,\n" +
                "\tps.inventory \n" +
                "from \n" +
                "\tproduct p,\n" +
                "\tproductsku ps,\n" +
                "\tproductcategorydic pc \n" +
                "where \n" +
                "\tp.productID=ps.productID \n" +
                "and \n" +
                "\tp.categoryID=pc.categoryID \n" +
                "and \n" +
                "\tps.productID=? ";
        List<ProductDetailInfo> query = temp.query(sql,
                new BeanPropertyRowMapper<>(ProductDetailInfo.class),
                product.getProductId());
        return query;
    }

    //添加商品
    @Override
    public int insertNewProduct(Product product, List<Productsku> productskus) {
        //1.添加商品表
        int update = temp.update("insert into product values (default,?,?,?,?,?,?)",
                product.getProductName(),
                product.getCategoryID(),
                product.getShelfTime(),
                product.getImgRelativePath(),
                product.getImgRealPath(),
                product.getShelfStatus());
        //2.循环添加sku表
        int update2=0;

        Product product1 = selectProductByNameAndCID(product).get(0);
        long productId = product1.getProductId();
        for (Productsku productsku : productskus){
            int update1 = temp.update("insert into productsku values(default,?,?,?,?,?,?)",
                    productId,
                    productsku.getSkuAttribute(),
                    productsku.getPrice(),
                    productsku.getInventory(),
                    productsku.getImgRelativePath(),
                    productsku.getImgRealPath());
            update2+=update1;
        }

        if(update>0 && update2==productskus.size())
            return 1;
        return 0;
    }

    //修改商品信息
    @Override
    public int updateProductInfo(Product product) {
        StringBuffer sb = new StringBuffer();
        sb.append("update product ");
        if(product.getProductName()!=null){
            sb.append("productName="+product.getProductName()+",");
        }
        if(product.getShelfStatus()!=null){
            sb.append("shelfStatus="+product.getShelfStatus()+",");
        }
        if(product.getCategoryID()!=null){
            sb.append("categoryID="+product.getCategoryID()+",");
        }
        String substring = sb.substring(0, sb.length() - 1);
        substring+="where productID="+product.getCategoryID();

        int update = temp.update(substring);
        return update;
    }

    //修改商品详细信息
    @Override
    public int updateProductDetailInfo(Productsku productsku) {
        StringBuffer sb = new StringBuffer();
        sb.append("update productSku ");
        if(productsku.getSkuAttribute()!=null){
            sb.append("skuAttribute="+productsku.getSkuAttribute()+",");
        }
        if(productsku.getPrice()!=0.0){
            sb.append("price="+productsku.getPrice()+",");
        }
        if(productsku.getInventory()!=0){
            sb.append("inventory="+productsku.getInventory()+",");
        }
        return 0;
    }

    //删除商品
    @Override
    public int deleteProduct(Product product) {
        int update = temp.update("delete from productsku where productID=?", product.getProductId());
        int update1 = temp.update("delete from product where productID=?", product.getProductId());
        if(update>0 && update1>0)
            return 1;
        return 0;
    }

    //查询商品规格(ID)
    @Override
    public List<Productspecificationdic> selectProductspecificationdicByID(String specificationdicID) {
        List<Productspecificationdic> query = temp.query("select * from productspecificationdic where specificationDicID=?",
                new BeanPropertyRowMapper<>(Productspecificationdic.class),
                specificationdicID);
        return query;
    }

    //查询商品规格(categoryID)
    @Override
    public List<Productspecificationdic> selectProductspecificationdicByCID(Productcategorydic productcategorydic) {
        List<Productspecificationdic> query = temp.query("select * from productspecificationdic where categoryID=?",
                new BeanPropertyRowMapper<>(Productspecificationdic.class),
                productcategorydic.getCategoryId());
        return query;
    }

    //查询商品规格(Name,categoryID)
    @Override
    public List<Productspecificationdic> selectProductspecificationdicByID(Productspecificationdic productspecificationdic) {
        List<Productspecificationdic> query = temp.query("SELECT\n" +
                        "\tspecificationDicID,\n" +
                        "\tspecificationDicName,\n" +
                        "\tcategoryID,\n" +
                        "\tpid \n" +
                        "FROM\n" +
                        "\tproductspecificationdic\n" +
                        "WHERE\n" +
                        "\tspecificationDicName=?\n" +
                        "AND\n" +
                        "\tcategoryID=?",
                new BeanPropertyRowMapper<>(Productspecificationdic.class),
                productspecificationdic.getSpecificationDicName(),
                productspecificationdic.getCategoryID());
        return query;
    }

    //查询商品规格值(ID)
    @Override
    public List<Productspecificationvalues> selectProductspecificationvaluesByID(String specificationID) {
        List<Productspecificationvalues> query = temp.query("select * from productspecificationvalues where specificationID=?",
                new BeanPropertyRowMapper<>(Productspecificationvalues.class),
                specificationID);
        return query;
    }

    //查询商品规格值(specificationID)
    @Override
    public List<Productspecificationvalues> selectProductspecificationvaluesBySID(Productspecificationdic productspecificationdic) {
        List<Productspecificationvalues> query = temp.query("select * from productspecificationvalues where specificationDicID=?",
                new BeanPropertyRowMapper<>(Productspecificationvalues.class),
                productspecificationdic.getSpecificationDicId());
        return query;
    }

    //查询商品规格值(Name,specificationID)
    @Override
    public List<Productspecificationvalues> selectProductspecificationvaluesBySIDAndName(Productspecificationvalues productspecificationvalues) {
        List<Productspecificationvalues> query = temp.query("SELECT\n" +
                        "\tspecificationID,\n" +
                        "\tspecificationDicID,\n" +
                        "\tspecificationName \n" +
                        "FROM\n" +
                        "\tproductspecificationvalues \n" +
                        "WHERE\n" +
                        "\tspecificationName=?\n" +
                        "AND\n" +
                        "\tspecificationDicID=?",
                new BeanPropertyRowMapper<>(Productspecificationvalues.class),
                productspecificationvalues.getSpecificationName(),
                productspecificationvalues.getSpecificationDicId());
        return query;
    }

    //查询商品类别(ID)
    @Override
    public List<Productcategorydic> selectProductCategoryByID(Productcategorydic productcategorydic) {
        List<Productcategorydic> query = temp.query("select * from productcategorydic where categoryID=?",
                new BeanPropertyRowMapper<>(Productcategorydic.class),
                productcategorydic.getCategoryId());
        return query;
    }

    //查询商品类别(PID)
    @Override
    public List<Productcategorydic> selectProductCategoryByPID(Productcategorydic productcategorydic) {
        String sql = "select * from productcategorydic where pid="+productcategorydic.getPid();
        List<Productcategorydic> query = temp.query(sql,
                new BeanPropertyRowMapper<>(Productcategorydic.class));
        return query;
    }


}
