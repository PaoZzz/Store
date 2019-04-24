package com.jxnydx.util.threadframe.admin;

import com.jxnydx.store.frame.back.AdminUserMerchantAddFrame;

public class ThreadAdminUserMerchantAddFrame extends Thread {
    public void run() {
        new AdminUserMerchantAddFrame("Add Merchant");
    }
}