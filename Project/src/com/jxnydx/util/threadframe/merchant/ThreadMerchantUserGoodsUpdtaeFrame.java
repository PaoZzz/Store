package com.jxnydx.util.threadframe.merchant;

import com.jxnydx.store.frame.front.merchant.MerchantUserGoodsUpdateFrame;

public class ThreadMerchantUserGoodsUpdtaeFrame extends Thread {
    private String mid;

    public ThreadMerchantUserGoodsUpdtaeFrame(String mid) {
        this.mid = mid;
    }

    public void run() {
        new MerchantUserGoodsUpdateFrame("Update Goods", this.mid);
    }
}