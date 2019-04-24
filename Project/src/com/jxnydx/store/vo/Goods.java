package com.jxnydx.store.vo;

import java.io.Serializable;

public class Goods implements Serializable{
    private Integer gid;
    private String mid;
    private String gname;
    private Double gprice;
    private Integer gstatus;
    private Merchant merchant;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Double getGprice() {
        return gprice;
    }

    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }

    public Integer getGstatus() {
        return gstatus;
    }

    public void setGstatus(Integer gstatus) {
        this.gstatus = gstatus;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
}
