package com.RSnowBEar.entity;


import java.sql.Timestamp;

public class Orderinfo {

  private Long orderId;
  private Long userId;
  private Long addressId;
  private Long skuId;
  private Double price;
  private Long buyNum;
  private Double discountPrice;
  private Long status;
  private java.sql.Timestamp buyTime;

  public Orderinfo() {
  }

  public Orderinfo(Long orderId) {
    this.orderId = orderId;
  }

  public Orderinfo(Long userId, Long addressId, Long skuId, Double price, Long buyNum, Double discountPrice, Long status, Timestamp buyTime) {
    this.userId = userId;
    this.addressId = addressId;
    this.skuId = skuId;
    this.price = price;
    this.buyNum = buyNum;
    this.discountPrice = discountPrice;
    this.status = status;
    this.buyTime = buyTime;
  }

  @Override
  public String toString() {
    return "Orderinfo{" +
            "orderId=" + orderId +
            ", userId=" + userId +
            ", addressId=" + addressId +
            ", skuId=" + skuId +
            ", price=" + price +
            ", buyNum=" + buyNum +
            ", discountPrice=" + discountPrice +
            ", status=" + status +
            ", buyTime=" + buyTime +
            '}';
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }


  public Long getAddressId() {
    return addressId;
  }

  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }


  public Long getSkuId() {
    return skuId;
  }

  public void setSkuId(Long skuId) {
    this.skuId = skuId;
  }


  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }


  public Long getBuyNum() {
    return buyNum;
  }

  public void setBuyNum(Long buyNum) {
    this.buyNum = buyNum;
  }


  public Double getDiscountPrice() {
    return discountPrice;
  }

  public void setDiscountPrice(Double discountPrice) {
    this.discountPrice = discountPrice;
  }


  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }


  public java.sql.Timestamp getBuyTime() {
    return buyTime;
  }

  public void setBuyTime(java.sql.Timestamp buyTime) {
    this.buyTime = buyTime;
  }

}
