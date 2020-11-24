package com.entity;

import java.io.Serializable;

/**
 * 汽车信息表
 */
public class car implements Serializable {
    private Integer id;     //汽车编号
    private String car_num;     //车牌号
    private Integer brand_id;       //品牌编号
    private String model;       //汽车型号
    private String color;       //汽车颜色
    private Integer category_id;        //类别编号
    private String comments;        //汽车简介
    private float price;        //汽车市场价
    private float rent;     //每日租金
    private Integer status;     //当前租赁状态(0:可借   1:不可借)
    private Integer useable;    //当前上下架状态(0:上架   1:下架)

    public car() { }

    public car(Integer id, String car_num, Integer brand_id, String model, String color, Integer category_id, String comments, float price, float rent, Integer status, Integer useable) {
        this.id = id;
        this.car_num = car_num;
        this.brand_id = brand_id;
        this.model = model;
        this.color = color;
        this.category_id = category_id;
        this.comments = comments;
        this.price = price;
        this.rent = rent;
        this.status = status;
        this.useable = useable;
    }

    public car(String car_num, Integer brand_id, String model, String color, Integer category_id, String comments, float price, float rent, Integer status, Integer useable) {
        this.car_num = car_num;
        this.brand_id = brand_id;
        this.model = model;
        this.color = color;
        this.category_id = category_id;
        this.comments = comments;
        this.price = price;
        this.rent = rent;
        this.status = status;
        this.useable = useable;
    }

    @Override
    public String toString() {
        return "car{" +
                "id=" + id +
                ", car_num='" + car_num + '\'' +
                ", brand_id=" + brand_id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", category_id=" + category_id +
                ", comments='" + comments + '\'' +
                ", price=" + price +
                ", rent=" + rent +
                ", status=" + status +
                ", useable=" + useable +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCar_num() {
        return car_num;
    }

    public void setCar_num(String car_num) {
        this.car_num = car_num;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRent() {
        return rent;
    }

    public void setRent(float rent) {
        this.rent = rent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUseable() {
        return useable;
    }

    public void setUseable(Integer useable) {
        this.useable = useable;
    }
}
