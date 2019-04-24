package com.jxnydx.util.threadframe.admin;

import com.jxnydx.store.frame.back.AdminUserStudentIntroFrame;

public class ThreadAdminUserStudentIntroFrame extends Thread {
    private String sno;

    public ThreadAdminUserStudentIntroFrame(String sno) {
        this.sno = sno;
    }

    public void run() {
        new AdminUserStudentIntroFrame("Intro", this.sno);
    }
}