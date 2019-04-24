package com.jxnydx.store.vo;

import java.util.List;

public class Merchant {
    private String mid;
    private String mpassword;
    private String mname;
    private Double mmoney;
    private Integer mstatus;
    private String mlocate;
    private String mphone;
    private List<Goods> allGoods;
    private List<Orders> allOrders;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Double getMmoney() {
        return mmoney;
    }

    public void setMmoney(Double mmoney) {
        this.mmoney = mmoney;
    }

    public Integer getMstatus() {
        return mstatus;
    }

    public void setMstatus(Integer mstatus) {
        this.mstatus = mstatus;
    }

    public String getMlocate() {
        return mlocate;
    }

    public void setMlocate(String mlocate) {
        this.mlocate = mlocate;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public List<Goods> getAllGoods() {
        return allGoods;
    }

    public void setAllGoods(List<Goods> allGoods) {
        this.allGoods = allGoods;
    }

    public List<Orders> getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(List<Orders> allOrders) {
        this.allOrders = allOrders;
    }
}
