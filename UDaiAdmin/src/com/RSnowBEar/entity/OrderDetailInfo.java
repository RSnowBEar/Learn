package com.RSnowBEar.entity;

import java.sql.Timestamp;

public class OrderDetailInfo {
    private Long orderId;   //订单编号
    private Long userId;    //用户编号
    private String phone;   //用户手机号
    private Long addressId; //订单目的地编号
    private String province; //地址
    private String city; //地址
    private String area; //地址
    private String town; //地址
    private String detail; //详情
    private Long productId; //购买商品编号
    private String productName; //购买商品名称
    private Long skuId; //购买规格编号
    private Object skuAttribute;    //购买规格
    private Double price;   //单价
    private Long buyNum;    //购买数量
    private Double discountPrice;   //合计
    private Long status;    //订单状态
    private Timestamp buyTime;  //下单时间

    public OrderDetailInfo() {
    }

    public OrderDetailInfo(Long orderId) {
        this.orderId = orderId;
    }

    public OrderDetailInfo(String province, String city, String area, String town) {
        this.province = province;
        this.city = city;
        this.area = area;
        this.town = town;
    }

    public OrderDetailInfo(Long userId, String phone, Long addressId, Long productId, String productName, Long skuId, Object skuAttribute, Double price, Long buyNum, Double discountPrice, Long status, Timestamp buyTime) {
        this.userId = userId;
        this.phone = phone;
        this.addressId = addressId;
        this.productId = productId;
        this.productName = productName;
        this.skuId = skuId;
        this.skuAttribute = skuAttribute;
        this.price = price;
        this.buyNum = buyNum;
        this.discountPrice = discountPrice;
        this.status = status;
        this.buyTime = buyTime;
    }

    public OrderDetailInfo(Long orderId, Long userId, String phone, Long addressId, Long productId, String productName, Long skuId, Object skuAttribute, Double price, Long buyNum, Double discountPrice, Long status, Timestamp buyTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.phone = phone;
        this.addressId = addressId;
        this.productId = productId;
        this.productName = productName;
        this.skuId = skuId;
        this.skuAttribute = skuAttribute;
        this.price = price;
        this.buyNum = buyNum;
        this.discountPrice = discountPrice;
        this.status = status;
        this.buyTime = buyTime;
    }

    @Override
    public String toString() {
        return "OrderDetailInfo{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", phone='" + phone + '\'' +
                ", addressId=" + addressId +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", town='" + town + '\'' +
                ", detail='" + detail + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", skuId=" + skuId +
                ", skuAttribute=" + skuAttribute +
                ", price=" + price +
                ", buyNum=" + buyNum +
                ", discountPrice=" + discountPrice +
                ", status=" + status +
                ", buyTime=" + buyTime +
                '}';
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
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

    public Timestamp getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Timestamp buyTime) {
        this.buyTime = buyTime;
    }
}
