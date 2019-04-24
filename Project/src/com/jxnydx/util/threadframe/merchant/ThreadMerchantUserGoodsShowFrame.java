package com.jxnydx.util.threadframe.merchant;

import com.jxnydx.store.frame.front.merchant.MerchantUserGoodsShowFrame;

public class ThreadMerchantUserGoodsShowFrame extends Thread {
    private String mid;

    public ThreadMerchantUserGoodsShowFrame(String mid) {
        this.mid = mid;
    }

    public void run() {
        new MerchantUserGoodsShowFrame("Show Goods", this.mid);
    }
}