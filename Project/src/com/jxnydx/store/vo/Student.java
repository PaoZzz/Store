package com.jxnydx.store.vo;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
    private String sno;
    private String spassword;
    private String sname;
    private Double smoney;
    private Integer sstatus;
    private String sclass;
    private String slocate;
    private String sphone;
    private List<Orders> allOrders;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Double getSmoney() {
        return smoney;
    }

    public void setSmoney(Double smoney) {
        this.smoney = smoney;
    }

    public Integer getSstatus() {
        return sstatus;
    }

    public void setSstatus(Integer sstatus) {
        this.sstatus = sstatus;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getSlocate() {
        return slocate;
    }

    public void setSlocate(String slocate) {
        this.slocate = slocate;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public List<Orders> getAllOrders() {
        return allOrders;
    }

    public void setAllOrders(List<Orders> allOrders) {
        this.allOrders = allOrders;
    }
}
