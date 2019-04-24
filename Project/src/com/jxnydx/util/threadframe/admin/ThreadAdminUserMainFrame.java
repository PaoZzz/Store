package com.jxnydx.util.threadframe.admin;

import com.jxnydx.store.frame.back.AdminUserMainFrame;

public class ThreadAdminUserMainFrame extends Thread {
    private String aid;

    public ThreadAdminUserMainFrame(String aid) {
        this.aid = aid;
    }

    public void run() {
        new AdminUserMainFrame("Admin", this.aid);
    }
}