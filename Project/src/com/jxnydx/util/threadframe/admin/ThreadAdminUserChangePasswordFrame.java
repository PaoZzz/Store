package com.jxnydx.util.threadframe.admin;

import com.jxnydx.store.frame.back.AdminUserChangePasswordFrame;

public class ThreadAdminUserChangePasswordFrame extends Thread {
    private String aid;

    public ThreadAdminUserChangePasswordFrame(String aid) {
        this.aid = aid;
    }

    public void run() {
        new AdminUserChangePasswordFrame("Change Password", this.aid);
    }
}