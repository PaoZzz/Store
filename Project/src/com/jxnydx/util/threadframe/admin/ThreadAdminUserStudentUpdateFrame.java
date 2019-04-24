package com.jxnydx.util.threadframe.admin;

import com.jxnydx.store.frame.back.AdminUserStudentUpdateFrame;

public class ThreadAdminUserStudentUpdateFrame extends Thread {
    private String sno;

    public ThreadAdminUserStudentUpdateFrame(String sno) {
        this.sno = sno;
    }

    public void run() {
        new AdminUserStudentUpdateFrame("Intro", this.sno);
    }
}