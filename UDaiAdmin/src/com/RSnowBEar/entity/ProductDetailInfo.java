package com.RSnowBEar.entity;

import java.sql.Date;
import java.util.Map;

/**
 * 查询结果用实体类——商品详情
 */
public class ProductDetailInfo {
    private Integer productID;  //商品ID
    private String productName; //商品名称
    private Integer categoryID;  //商品类型编号
    private String categoryName;    //商品类型名
    private java.sql.Date shelfTime;    //上传时间
    private Integer skuID;  //sku表编号
    private Object skuAttribute;    //sku属性
    private Double price;   //单价
    private Integer inventory;  //库存

    public ProductDetailInfo() {
    }

    public ProductDetailInfo(Integer productID) {
        this.productID = productID;
    }

    public ProductDetailInfo(String skuAttribute) {
        this.skuAttribute = skuAttribute;
    }

    public ProductDetailInfo(Integer productID, String productName, Integer categoryID, String categoryName, Date shelfTime, Integer skuID, Object skuAttribute, Double price, Integer inventory) {
        this.productID = productID;
        this.productName = productName;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.shelfTime = shelfTime;
        this.skuID = skuID;
        this.skuAttribute = skuAttribute;
        this.price = price;
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "ProductDetailInfo{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", categoryID=" + categoryID +
                ", categoryName='" + categoryName + '\'' +
                ", shelfTime=" + shelfTime +
                ", skuID=" + skuID +
                ", skuAttribute='" + skuAttribute + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                '}';
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(Date shelfTime) {
        this.shelfTime = shelfTime;
    }

    public Integer getSkuID() {
        return skuID;
    }

    public void setSkuID(Integer skuID) {
        this.skuID = skuID;
    }

    public Object getSkuAttribute() {
        return skuAttribute;
    }

    public void setSkuAttribute(Object skuAttribute) {
        this.skuAttribute = skuAttribute;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}
