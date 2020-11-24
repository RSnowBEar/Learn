package com.entity;

import java.io.Serializable;

/**
 * 用户表
 */
public class user implements Serializable {
    private Integer id;     //用户编号
    private String username;        //用户名
    private String password;        //密码
    private String sex;     //性别
    private String id_number;       //身份证号
    private String tel;     //电话号码
    private String address;     //地址
    private Integer type;       //账号类型(0:普通用户   1:管理员)

    public user() { }

    public user(Integer id, String username, String password, String sex, String id_number, String tel, String address, Integer type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.id_number = id_number;
        this.tel = tel;
        this.address = address;
        this.type = type;
    }

    public user(String username, String password, String sex, String id_number, String tel, String address, Integer type) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.id_number = id_number;
        this.tel = tel;
        this.address = address;
        this.type = type;
    }

    @Override
    public String toString() {
        return id + selectCarAll.getT(id)+
                username +selectCarAll.getT(username)+
                password +selectCarAll.getT(password)+
                sex +selectCarAll.getT(sex)+
                id_number +selectCarAll.getT(id_number)+
                tel +selectCarAll.getT(tel)+
                address +selectCarAll.getT(address)+
                type;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
