package com.jxnydx.util.threadframe.admin;

import com.jxnydx.store.frame.back.AdminUserMerchantUpdateFrame;

public class ThreadAdminUserMerchantUpdateFrame extends Thread {
    private String mid;

    public ThreadAdminUserMerchantUpdateFrame(String mid) {
        this.mid = mid;
    }

    public void run() {
        new AdminUserMerchantUpdateFrame("Intro", this.mid);
    }
}