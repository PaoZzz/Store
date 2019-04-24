package com.jxnydx.util.threadframe.admin;

import com.jxnydx.store.frame.back.AdminUserOrdersAllFrame;

public class ThreadAdminUserOrdersAllFrame extends Thread {
    public void run() {
        new AdminUserOrdersAllFrame("All Orders");
    }
}