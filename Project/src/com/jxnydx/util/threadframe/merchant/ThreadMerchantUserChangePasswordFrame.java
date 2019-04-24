package com.jxnydx.util.threadframe.merchant;

import com.jxnydx.store.frame.front.merchant.MerchantUserChangePasswordFrame;

public class ThreadMerchantUserChangePasswordFrame extends Thread {
    private String mid;

    public ThreadMerchantUserChangePasswordFrame(String mid) {
        this.mid = mid;
    }

    public void run() {
        new MerchantUserChangePasswordFrame("Change Password", this.mid);
    }
}