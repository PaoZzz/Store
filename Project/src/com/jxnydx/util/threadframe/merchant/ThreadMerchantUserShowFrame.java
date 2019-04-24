package com.jxnydx.util.threadframe.merchant;

import com.jxnydx.store.frame.front.merchant.MerchantUserShowFrame;

public class ThreadMerchantUserShowFrame extends Thread {
    private String mid;

    public ThreadMerchantUserShowFrame(String mid) {
        this.mid = mid;
    }

    public void run() {
        new MerchantUserShowFrame("Show", this.mid);
    }
}