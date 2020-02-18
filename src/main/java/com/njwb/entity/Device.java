package com.njwb.entity;

import java.util.Date;

public class Device {
    int device_Id; //设备订单编号
    String device_address; //地址
    String device_kind; //设备名称
    int device_num; //使用数量
    boolean device_rend;//租或者买
    String device_price;//设备单价
    boolean device_return;//是否归还
    Date device_start; //开始使用时间
    Date device_returntime; //归还时间
    String device_pay; //支付费用

    public int getDevice_Id() {
        return device_Id;
    }

    public String getDevice_address() {
        return device_address;
    }

    public String getDevice_kind() {
        return device_kind;
    }

    public int getDevice_num() {
        return device_num;
    }

    public boolean isDevice_rend() {
        return device_rend;
    }

    public String getDevice_price() {
        return device_price;
    }

    public boolean isDevice_return() {
        return device_return;
    }

    public Date getDevice_start() {
        return device_start;
    }

    public Date getDevice_returntime() {
        return device_returntime;
    }

    public String getDevice_pay() {
        return device_pay;
    }

    public void setDevice_Id(int device_Id) {
        this.device_Id = device_Id;
    }

    public void setDevice_address(String device_address) {
        this.device_address = device_address;
    }

    public void setDevice_kind(String device_kind) {
        this.device_kind = device_kind;
    }

    public void setDevice_num(int device_num) {
        this.device_num = device_num;
    }

    public void setDevice_rend(boolean device_rend) {
        this.device_rend = device_rend;
    }

    public void setDevice_price(String device_price) {
        this.device_price = device_price;
    }

    public void setDevice_return(boolean device_return) {
        this.device_return = device_return;
    }

    public void setDevice_start(Date device_start) {
        this.device_start = device_start;
    }

    public void setDevice_returntime(Date device_returntime) {
        this.device_returntime = device_returntime;
    }

    public void setDevice_pay(String device_pay) {
        this.device_pay = device_pay;
    }
}
