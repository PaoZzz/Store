package com.jxnydx.util.threadframe.admin;

import com.jxnydx.store.frame.back.AdminUserStudentAddFrame;

public class ThreadAdminUserStudentAddFrame extends Thread {
    public void run() {
        new AdminUserStudentAddFrame("Add Student");
    }
}