package com.jxnydx.util.threadframe.student;

import com.jxnydx.store.frame.front.student.StudentUserUpdateFrame;

public class ThreadStudentUserUpdateFrame extends Thread {
    private String sno;

    public ThreadStudentUserUpdateFrame(String sno) {
        this.sno = sno;
    }

    public void run() {
        new StudentUserUpdateFrame("Update", this.sno);
    }
}