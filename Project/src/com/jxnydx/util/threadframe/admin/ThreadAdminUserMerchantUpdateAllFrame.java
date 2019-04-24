package com.jxnydx.util.threadframe.admin;

import com.jxnydx.store.frame.back.AdminUserMerchantUpdateAllFrame;

public class ThreadAdminUserMerchantUpdateAllFrame extends Thread {
    public void run() {
        new AdminUserMerchantUpdateAllFrame("Update Merchant");
    }
}