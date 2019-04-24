package com.jxnydx.util.threadframe.admin;

import com.jxnydx.store.frame.back.AdminUserMerchantFindAllFrame;

public class ThreadAdminUserMerchantFindAllFrame extends Thread {
    public void run() {
        new AdminUserMerchantFindAllFrame("All Merchant");
    }
}