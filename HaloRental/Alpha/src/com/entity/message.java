package com.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class message implements Serializable {
    private String function;        //功能
    private Map data;      //数据

    public message() {
    }

    public message(String function, Map data) {
        this.function = function;
        this.data = data;
    }

    @Override
    public String toString() {
        return "message{" +
                "function='" + function + '\'' +
                ", data=" + data +
                '}';
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }
}
