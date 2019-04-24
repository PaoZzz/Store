package com.jxnydx.util.threadframe.student;

import com.jxnydx.store.frame.front.student.StudentUserFindOrdersFrame;

public class ThreadStudentUserFindOrdersFrame extends Thread {
    private String son;

    public ThreadStudentUserFindOrdersFrame(String sno) {
        this.son = sno;
    }

    public void run() {
        new StudentUserFindOrdersFrame("Find Orders", this.son);
    }
}