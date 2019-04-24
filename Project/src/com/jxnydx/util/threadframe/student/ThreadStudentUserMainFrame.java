package com.jxnydx.util.threadframe.student;

import com.jxnydx.store.frame.front.student.StudentUserMainFrame;

public class ThreadStudentUserMainFrame extends Thread {
    private String sno;

    public ThreadStudentUserMainFrame(String sno) {
        this.sno = sno;
    }

    public void run() {
        new StudentUserMainFrame("Student", this.sno);
    }
}