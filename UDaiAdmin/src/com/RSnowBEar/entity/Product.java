package com.RSnowBEar.entity;


import java.sql.Timestamp;

public class Product {

  private long productId;
  private String productName;
  private Integer categoryID; // 商品类别ID
  private java.sql.Timestamp shelfTime;
  private Integer shelfStatus;  //上下架状态
  private String imgRelativePath;
  private String imgRealPath;

  public Product() {
  }

  public Product(long productId) {
    this.productId = productId;
  }

  public Product(String imgRelativePath, String imgRealPath) {
    this.imgRelativePath = imgRelativePath;
    this.imgRealPath = imgRealPath;
  }

  public Product(String productName, Integer categoryID, Timestamp shelfTime, Integer shelfStatus) {
    this.productName = productName;
    this.categoryID = categoryID;
    this.shelfTime = shelfTime;
    this.shelfStatus = shelfStatus;
  }

  public Product(long productId, String productName, Integer categoryID, Timestamp shelfTime, Integer shelfStatus, String imgRelativePath, String imgRealPath) {
    this.productId = productId;
    this.productName = productName;
    this.categoryID = categoryID;
    this.shelfTime = shelfTime;
    this.shelfStatus = shelfStatus;
    this.imgRelativePath = imgRelativePath;
    this.imgRealPath = imgRealPath;
  }

  public Integer getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(Integer categoryID) {
    this.categoryID = categoryID;
  }

  public Integer getShelfStatus() {
    return shelfStatus;
  }

  public void setShelfStatus(Integer shelfStatus) {
    this.shelfStatus = shelfStatus;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }


  public java.sql.Timestamp getShelfTime() {
    return shelfTime;
  }

  public void setShelfTime(java.sql.Timestamp shelfTime) {
    this.shelfTime = shelfTime;
  }


  public String getImgRelativePath() {
    return imgRelativePath;
  }

  public void setImgRelativePath(String imgRelativePath) {
    this.imgRelativePath = imgRelativePath;
  }


  public String getImgRealPath() {
    return imgRealPath;
  }

  public void setImgRealPath(String imgRealPath) {
    this.imgRealPath = imgRealPath;
  }

}
