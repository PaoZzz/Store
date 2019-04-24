package com.jxnydx.util.threadframe.student;

import com.jxnydx.store.frame.front.student.StudentUserFindGoodsFrame;

public class ThreadStudentUserFindGoodsFrame extends Thread {
    private String mid;
    private String sno;

    public ThreadStudentUserFindGoodsFrame(String mid, String sno) {
        this.mid = mid;
        this.sno = sno;
    }

    public void run() {
        new StudentUserFindGoodsFrame("Find Goods", this.mid, this.sno);
    }
}