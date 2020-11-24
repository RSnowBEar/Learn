package com.RSnowBEar.entity;


public class Productsku {

  private long skuId;   //skuID
  private long productId;   //商品编号
  private String skuAttribute;    //sku属性
  private double price;   //单价
  private long inventory;   //库存
  private String imgRelativePath;   //预览图相对路径
  private String imgRealPath;   //预览图绝对路径

  public Productsku() {
  }

  public Productsku(long skuId) {
    this.skuId = skuId;
  }

  public Productsku(long productId, String skuAttribute, double price, long inventory) {
    this.productId = productId;
    this.skuAttribute = skuAttribute;
    this.price = price;
    this.inventory = inventory;
  }

  public Productsku(long skuId, long productId, String skuAttribute, double price, long inventory, String imgRelativePath, String imgRealPath) {
    this.skuId = skuId;
    this.productId = productId;
    this.skuAttribute = skuAttribute;
    this.price = price;
    this.inventory = inventory;
    this.imgRelativePath = imgRelativePath;
    this.imgRealPath = imgRealPath;
  }

  public long getSkuId() {
    return skuId;
  }

  public void setSkuId(long skuId) {
    this.skuId = skuId;
  }


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public String getSkuAttribute() {
    return skuAttribute;
  }

  public void setSkuAttribute(String skuAttribute) {
    this.skuAttribute = skuAttribute;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public long getInventory() {
    return inventory;
  }

  public void setInventory(long inventory) {
    this.inventory = inventory;
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
