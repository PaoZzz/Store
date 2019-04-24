package com.jxnydx.util.threadframe.merchant;

import com.jxnydx.store.frame.front.merchant.MerchantUserGoodsAddFrame;

public class ThreadMerchantUserGoodsAddFrame extends Thread {
    private String mid;

    public ThreadMerchantUserGoodsAddFrame(String mid) {
        this.mid = mid;
    }

    public void run() {
        new MerchantUserGoodsAddFrame("Add Goods", this.mid);
    }
}