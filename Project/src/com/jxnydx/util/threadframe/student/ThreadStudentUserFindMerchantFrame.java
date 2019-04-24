package com.jxnydx.util.threadframe.student;

import com.jxnydx.store.frame.front.student.StudentUserFindMerchantFrame;

public class ThreadStudentUserFindMerchantFrame extends Thread {
    private String sno;

    public ThreadStudentUserFindMerchantFrame(String sno) {
        this.sno = sno;
    }

    public void run() {
        new StudentUserFindMerchantFrame("Find Merchant", this.sno);
    }
}