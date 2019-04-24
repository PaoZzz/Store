package com.jxnydx.util.threadframe.admin;

import com.jxnydx.store.frame.back.AdminUserStudentUpdateAllFrame;

public class ThreadAdminUserStudentUpdateAllFrame extends Thread {
    public void run() {
        new AdminUserStudentUpdateAllFrame("Update Student");
    }
}