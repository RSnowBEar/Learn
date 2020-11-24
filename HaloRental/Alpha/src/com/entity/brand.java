package com.entity;

import java.io.Serializable;

/**
 * 汽车品牌表
 */
public class brand implements Serializable {
    private Integer id;     //品牌编号
    private String name;    //品牌名称

    public brand() { }

    public brand(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id+selectCarAll.getT(id)+
                name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
