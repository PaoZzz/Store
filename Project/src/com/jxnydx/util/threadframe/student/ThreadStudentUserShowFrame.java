package com.jxnydx.util.threadframe.student;

import com.jxnydx.store.frame.front.student.StudentUserShowFrame;

public class ThreadStudentUserShowFrame extends Thread {
    private String sno;

    public ThreadStudentUserShowFrame(String sno) {
        this.sno = sno;
    }

    public void run() {
        new StudentUserShowFrame("Show", this.sno);
    }
}