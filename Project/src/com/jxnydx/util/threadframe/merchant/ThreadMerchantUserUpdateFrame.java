package com.jxnydx.util.threadframe.merchant;

import com.jxnydx.store.frame.front.merchant.MerchantUserUpdateFrame;

public class ThreadMerchantUserUpdateFrame extends Thread {
    private String mid;

    public ThreadMerchantUserUpdateFrame(String mid) {
        this.mid = mid;
    }

    public void run() {
        new MerchantUserUpdateFrame("Show", this.mid);
    }
}