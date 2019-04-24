package com.jxnydx.util.threadframe.merchant;

import com.jxnydx.store.frame.front.merchant.MerchantUserMainFrame;

public class ThreadMerchantUserMainFrame extends Thread {
    private String mid;

    public ThreadMerchantUserMainFrame(String mid) {
        this.mid = mid;
    }

    public void run() {
        new MerchantUserMainFrame("Merchant", this.mid);
    }
}