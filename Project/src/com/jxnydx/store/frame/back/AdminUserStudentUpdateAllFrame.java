package com.jxnydx.store.frame.back;

import com.jxnydx.store.factory.ServiceBackFactory;
import com.jxnydx.store.vo.Student;
import com.jxnydx.util.threadframe.admin.ThreadAdminUserStudentUpdateFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class AdminUserStudentUpdateAllFrame extends JFrame {
    private List<Student> studentList;

    public AdminUserStudentUpdateAllFrame(String frameName) {
        try {
            this.studentList = ServiceBackFactory.getIStudentServiceBackInstance().list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(700, 400);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(this.studentList.size(),4));

        Iterator<Student> iter = studentList.iterator();
        while (iter.hasNext()) {
            final Student student = iter.next();
            JPanel jPanelOnePointOne = new JPanel();
            JPanel jPanelOnePointTwo = new JPanel();
            JPanel jPanelOnePointThree = new JPanel();
            JPanel jPanelOnePointFour = new JPanel();
            JLabel studentSno = new JLabel("Account:" + student.getSno());
            JLabel studentName = new JLabel("Name:" + student.getSname());
            JLabel studentClass = new JLabel("Class:" + student.getSclass());
            JButton jButton = new JButton("Update");

            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ThreadAdminUserStudentUpdateFrame(student.getSno()).start();
                }
            });

            jPanelOnePointOne.add(studentSno);
            jPanelOnePointTwo.add(studentName);
            jPanelOnePointThree.add(studentClass);
            jPanelOnePointFour.add(jButton);

            this.add(jPanelOnePointOne);
            this.add(jPanelOnePointTwo);
            this.add(jPanelOnePointThree);
            this.add(jPanelOnePointFour);
        }

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
