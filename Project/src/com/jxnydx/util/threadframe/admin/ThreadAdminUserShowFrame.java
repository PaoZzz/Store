package com.jxnydx.util.threadframe.admin;

import com.jxnydx.store.frame.back.AdminUserShowFrame;

public class ThreadAdminUserShowFrame extends Thread {
    public void run() {
        new AdminUserShowFrame("Show");
    }
}