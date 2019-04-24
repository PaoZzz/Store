package com.jxnydx.store.frame.front.student;

import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Student;
import com.jxnydx.util.threadframe.student.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentUserMainFrame extends JFrame {
    private Student student;

    private JPanel jPanelOne;
    private JPanel jPanelThree;
    private JPanel jPanelFour;
    private JPanel jPanelFive;
    private JPanel jPanelSix;
    private JPanel jPanelSeven;

    private JLabel jLabelName;
    private JLabel jLabelMoney;

    private JButton jButtonMerchantList;
    private JButton jButtonUpdate;
    private JButton jButtonOrdersList;
    private JButton jButtonChangePassword;
    private JButton jButtonIntruction;

    public StudentUserMainFrame(String frameName, String id) {
        try {
            this.student = ServiceFrontFactory.getIStudentServiceFrontInstance().getStudentInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setSize(500, 350);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(6,1));

        this.jPanelOne = new JPanel();
        this.jPanelThree = new JPanel();
        this.jPanelFour = new JPanel();
        this.jPanelFive = new JPanel();
        this.jPanelSix = new JPanel();
        this.jPanelSeven = new JPanel();

        this.jLabelName = new JLabel(this.student.getSname());
        this.jLabelMoney = new JLabel(String.valueOf(this.student.getSmoney()) + "¥");
        this.jButtonMerchantList = new JButton("Find Merchant");
        this.jButtonOrdersList = new JButton("Find Orders");
        this.jButtonUpdate = new JButton("Update");
        this.jButtonChangePassword = new JButton("ChangePassword");
        this.jButtonIntruction = new JButton("Show");

        //Find Merchant按钮的监听事件
        this.jButtonMerchantList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadStudentUserFindMerchantFrame(student.getSno()).start();
            }
        });

        //Find Orders按钮的监听事件
        this.jButtonOrdersList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadStudentUserFindOrdersFrame(student.getSno()).start();
            }
        });

        //Update按钮的监听事件
        this.jButtonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadStudentUserUpdateFrame(student.getSno()).start();
            }
        });

        //Change Password按钮的监听事件
        this.jButtonChangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadStudentUserChangePasswordFrame(student.getSno()).start();
            }
        });

        //Show按钮的监听事件
        this.jButtonIntruction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadStudentUserShowFrame(student.getSno()).start();
            }
        });

        this.jPanelOne.add(this.jLabelName);
        this.jPanelOne.add(this.jLabelMoney);

        this.jPanelThree.add(this.jButtonMerchantList);

        this.jPanelFour.add(this.jButtonOrdersList);

        this.jPanelFive.add(this.jButtonUpdate);

        this.jPanelSix.add(this.jButtonIntruction);

        this.jPanelSeven.add(this.jButtonChangePassword);

        this.add(this.jPanelOne);
        this.add(this.jPanelThree);
        this.add(this.jPanelFour);
        this.add(this.jPanelFive);
        this.add(this.jPanelSix);
        this.add(this.jPanelSeven);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
