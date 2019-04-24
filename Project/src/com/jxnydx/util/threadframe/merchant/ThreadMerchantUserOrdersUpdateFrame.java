package com.jxnydx.util.threadframe.merchant;

import com.jxnydx.store.frame.front.merchant.MerchantUserOrdersUpdateFrame;

public class ThreadMerchantUserOrdersUpdateFrame extends Thread {
    private String mid;

    public ThreadMerchantUserOrdersUpdateFrame(String mid) {
        this.mid = mid;
    }

    public void run() {
        new MerchantUserOrdersUpdateFrame("Update Orders", this.mid);
    }
}