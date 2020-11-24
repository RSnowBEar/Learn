package com.entity;

import java.io.Serializable;

/**
 * 查询汽车用类
 */
public class selectCarAll implements Serializable {
    private Integer id;     //汽车编号
    private String car_num;     //车牌号
    private String brand_name;  //汽车品牌名称
    private String model;   //汽车型号
    private String color;   //汽车颜色
    private String category_name;       //汽车类型名称
    private String comments;        //汽车描述
    private float price;    //汽车市场价
    private float rent;     //日租价格
    private Integer status;     //当前可租赁状态(0:可借   1:不可借)
    private Integer useable;    //当前上下架状态(0:上架   1:下架)

    public selectCarAll() {
    }

    public selectCarAll(Integer id, String car_num, String brand_name, String model, String color, String category_name, String comments, float price, float rent, Integer status, Integer useable) {
        this.id = id;
        this.car_num = car_num;
        this.brand_name = brand_name;
        this.model = model;
        this.color = color;
        this.category_name = category_name;
        this.comments = comments;
        this.price = price;
        this.rent = rent;
        this.status = status;
        this.useable = useable;
    }

    @Override
    public String toString() {
        String statusStr=(status==0?"可租":"已租出");
        String useableStr=(useable==0?"上架":"已下架");
        return id + getT(id)+
                car_num +getT(car_num)+
                brand_name +getT(brand_name)+
                model +getT(model)+
                color +getT(color)+
                category_name +getT(category_name)+
                comments +getT(comments)+
                price +getT(price)+
                rent +getT(rent)+
                statusStr+getT(statusStr)+
                useableStr;
    }

    //拼接制表符(对齐查询列表用)
    public static String getT(Object obj){
        String str="";
        String sb = ""+obj;
        int sub = 4-(sb.length()%4);
        if(sub==4)
            sub=0;
        for(int i=0;i<sub;i++){
            str+=" ";
        }
        str+="\t\t";
        return str;
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

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
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

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
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
