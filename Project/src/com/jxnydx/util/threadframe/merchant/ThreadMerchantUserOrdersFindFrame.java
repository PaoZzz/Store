package com.jxnydx.util.threadframe.merchant;

import com.jxnydx.store.frame.front.merchant.MerchantUserOrdersFindFrame;

public class ThreadMerchantUserOrdersFindFrame extends Thread {
    private String mid;

    public ThreadMerchantUserOrdersFindFrame(String mid) {
        this.mid = mid;
    }

    public void run() {
        new MerchantUserOrdersFindFrame("Find Orders", this.mid);
    }
}