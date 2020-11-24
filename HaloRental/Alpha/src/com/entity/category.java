package com.entity;

import java.io.Serializable;

/**
 * 汽车类别表
 */
public class category implements Serializable {
    private Integer id;     //类别编号
    private String name;    //类别名称

    public category() {
    }

    public category(Integer id, String name) {
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
