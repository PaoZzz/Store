package com.jxnydx.util.threadframe.student;

import com.jxnydx.store.frame.front.student.StudentUserChangePasswordFrame;

public class ThreadStudentUserChangePasswordFrame extends Thread {
    private String sno;

    public ThreadStudentUserChangePasswordFrame(String sno) {
        this.sno = sno;
    }

    public void run() {
        new StudentUserChangePasswordFrame("Change Password", this.sno);
    }
}