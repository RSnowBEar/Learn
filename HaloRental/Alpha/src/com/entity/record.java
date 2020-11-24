package com.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 汽车租赁记录表
 */
public class record implements Serializable {
    private Integer id;     //租赁标号（订单号）
    private Integer user_id;        //用户编号
    private Integer car_id;     //汽车编号
    private Date start_date;    //租出时间
    private Date return_date;    //还车时间
    private Float payment;      //支付租金总额

    public record() { }

    public record(Integer id, Integer user_id, Integer car_id, Date start_date, Date return_date,Float payment) {
        this.id = id;
        this.user_id = user_id;
        this.car_id = car_id;
        this.start_date = start_date;
        this.return_date = return_date;
        this.payment = payment;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String start_dateStr = sdf.format(start_date);
        String return_dateStr = sdf.format(return_date);
        return id+selectCarAll.getT(id)+
                user_id+selectCarAll.getT(user_id)+
                car_id+selectCarAll.getT(car_id)+
                start_dateStr+selectCarAll.getT(start_dateStr)+
                return_dateStr+selectCarAll.getT(return_dateStr)+
                payment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
