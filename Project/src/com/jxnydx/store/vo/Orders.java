package com.jxnydx.store.vo;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable{
    private Integer oid;
    private String mid;
    private String Gname;
    private String sno;
    private Date credate;
    private Double pay;
    private Integer ostatus;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public Integer getOstatus() {
        return ostatus;
    }

    public void setOstatus(Integer ostatus) {
        this.ostatus = ostatus;
    }

    public String getGname() {
        return Gname;
    }

    public void setGname(String gname) {
        Gname = gname;
    }
}
