package com.jxnydx.util.threadframe.admin;

import com.jxnydx.store.frame.back.AdminUserMerchantIntroFrame;

public class ThreadAdminUserMerchantIntroFrame extends Thread {
    private String mid;

    public ThreadAdminUserMerchantIntroFrame(String mid) {
        this.mid = mid;
    }

    public void run() {
        new AdminUserMerchantIntroFrame("Intro", this.mid);
    }
}