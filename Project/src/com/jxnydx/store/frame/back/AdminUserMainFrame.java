package com.jxnydx.store.frame.back;

import com.jxnydx.util.threadframe.admin.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUserMainFrame extends JFrame {
    private JPanel jPanelOne;
    private JPanel jPanelTwo;
    private JPanel jPanelThree;
    private JPanel jPanelFour;
    private JPanel jPanelFive;
    private JPanel jPanelSix;
    private JPanel jPanelSeven;
    private JPanel jPanelEight;
    private JPanel jPanelNine;
    private JPanel jPanelTen;

    private JLabel jLabelName;

    private JButton jButtonStudentAdd;
    private JButton jButtonStudeentUpdate;
    private JButton jButtonMerchantAdd;
    private JButton jButtonOrdersList;
    private JButton jButtonMerchantList;
    private JButton jButtonMerchantUpdate;
    private JButton jButtonChangePassword;
    private JButton jButtonIntruction;
    private JButton jButtonStudentList;

    public AdminUserMainFrame(String frameName, final String id) {
        this.setSize(500, 500);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(10,1));

        this.jPanelOne = new JPanel();
        this.jPanelTwo = new JPanel();
        this.jPanelThree = new JPanel();
        this.jPanelFour = new JPanel();
        this.jPanelFive = new JPanel();
        this.jPanelSix = new JPanel();
        this.jPanelSeven = new JPanel();
        this.jPanelEight = new JPanel();
        this.jPanelNine = new JPanel();
        this.jPanelTen = new JPanel();

        this.jLabelName = new JLabel("Hello, Admin!");
        this.jButtonStudentAdd = new JButton("Add Student");
        this.jButtonStudentList = new JButton("All Student");
        this.jButtonStudeentUpdate = new JButton("Update Student");
        this.jButtonMerchantAdd = new JButton("Add Merchant");
        this.jButtonMerchantList = new JButton("All Merchant");
        this.jButtonMerchantUpdate = new JButton("Update Merchant");
        this.jButtonOrdersList = new JButton("All Orders");
        this.jButtonIntruction = new JButton("Show");
        this.jButtonChangePassword = new JButton("Change Password");

        //Add Student按钮的监听事件
        this.jButtonStudentAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadAdminUserStudentAddFrame().start();
            }
        });

        //All Student按钮的监听事件
        this.jButtonStudentList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadAdminUserStudentFindAllFrame().start();
            }
        });

        //Update Student按钮的监听事件
        this.jButtonStudeentUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadAdminUserStudentUpdateAllFrame().start();
            }
        });

        //Add Merchant按钮的监听事件
        this.jButtonMerchantAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadAdminUserMerchantAddFrame().start();
            }
        });

        //All Merchant按钮的监听事件
        this.jButtonMerchantList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadAdminUserMerchantFindAllFrame().start();
            }
        });

        //Update Merchant按钮的监听事件
        this.jButtonMerchantUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadAdminUserMerchantUpdateAllFrame().start();
            }
        });

        //All Orders按钮的监听事件
        this.jButtonOrdersList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadAdminUserOrdersAllFrame().start();
            }
        });

        //Show按钮的监听事件
        this.jButtonIntruction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadAdminUserShowFrame().start();
            }
        });

        //Change Password按钮的监听事件
        this.jButtonChangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadAdminUserChangePasswordFrame(id).start();
            }
        });

        this.jPanelOne.add(this.jLabelName);

        this.jPanelTwo.add(this.jButtonStudentAdd);

        this.jPanelThree.add(this.jButtonStudentList);

        this.jPanelFour.add(this.jButtonStudeentUpdate);

        this.jPanelFive.add(this.jButtonMerchantAdd);

        this.jPanelSix.add(this.jButtonMerchantList);

        this.jPanelSeven.add(this.jButtonMerchantUpdate);

        this.jPanelEight.add(this.jButtonOrdersList);

        this.jPanelNine.add(this.jButtonIntruction);

        this.jPanelTen.add(this.jButtonChangePassword);

        this.add(this.jPanelOne);
        this.add(this.jPanelTwo);
        this.add(this.jPanelThree);
        this.add(this.jPanelFour);
        this.add(this.jPanelFive);
        this.add(this.jPanelSix);
        this.add(this.jPanelSeven);
        this.add(this.jPanelEight);
        this.add(this.jPanelNine);
        this.add(this.jPanelTen);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AdminUserMainFrame("Admin", "admin");
    }

}
