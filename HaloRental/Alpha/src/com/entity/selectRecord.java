package com.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 查询记录表用类
 */
public class selectRecord implements Serializable{
    private Integer id;     //单号
    private Integer user_id;        //用户编号
    private String username;        //用户名
    private Integer car_id;      //车辆编号
    private String car_num;     //车牌号
    private String model;       //汽车型号
    private String color;       //汽车颜色
    private Date start_date;    //租车时间
    private Date return_date;   //还车时间
    private Float payment;      //支付租金

    public selectRecord() {
    }

    public selectRecord(Integer id, Integer user_id, String username, Integer car_id, String car_num, String model, String color, Date start_date, Date return_date, Float payment) {
        this.id = id;
        this.user_id = user_id;
        this.username = username;
        this.car_id = car_id;
        this.car_num = car_num;
        this.model = model;
        this.color = color;
        this.start_date = start_date;
        this.return_date = return_date;
        this.payment = payment;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String start_dateStr = sdf.format(start_date);
        String return_dateStr = sdf.format(return_date);
        String paymentStr = (payment==null?"未支付":String.valueOf(payment));
        return id+selectCarAll.getT(id)+
                user_id+selectCarAll.getT(user_id)+
                username+selectCarAll.getT(username)+
                car_id+selectCarAll.getT(car_id)+
                car_num+selectCarAll.getT(car_num)+
                model+selectCarAll.getT(model)+
                color+selectCarAll.getT(color)+
                start_dateStr+selectCarAll.getT(start_dateStr)+
                return_dateStr+selectCarAll.getT(return_dateStr)+
                paymentStr;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCar_num() {
        return car_num;
    }

    public void setCar_num(String car_num) {
        this.car_num = car_num;
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

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Float getPayment() {
        return payment;
    }

    public void setPayment(Float payment) {
        this.payment = payment;
    }
}
