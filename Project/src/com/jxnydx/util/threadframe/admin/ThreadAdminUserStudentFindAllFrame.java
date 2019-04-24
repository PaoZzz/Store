package com.jxnydx.util.threadframe.admin;

import com.jxnydx.store.frame.back.AdminUserStudentFindAllFrame;

public class ThreadAdminUserStudentFindAllFrame extends Thread {
    public void run() {
        new AdminUserStudentFindAllFrame("All Student");
    }
}