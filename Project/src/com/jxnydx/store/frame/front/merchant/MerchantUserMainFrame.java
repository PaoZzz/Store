package com.jxnydx.store.frame.front.merchant;

import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Merchant;
import com.jxnydx.util.threadframe.merchant.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MerchantUserMainFrame extends JFrame {
    private Merchant merchant;

    private JPanel jPanelOne;
    private JPanel jPanelTwo;
    private JPanel jPanelThree;
    private JPanel jPanelFour;
    private JPanel jPanelFive;
    private JPanel jPanelSix;
    private JPanel jPanelSeven;
    private JPanel jPanelEight;
    private JPanel jPanelNine;

    private JLabel jLabelName;
    private JLabel jLabelMoney;

    private JButton jButtonGoodsAdd;
    private JButton jButtonGoodsList;
    private JButton jButtonGoodsUpdate;
    private JButton jButtonUpdate;
    private JButton jButtonOrdersList;
    private JButton jButtonOrdersUpdate;
    private JButton jButtonChangePassword;
    private JButton jButtonIntruction;

    public MerchantUserMainFrame(String frameName, String id) {
        try {
            this.merchant = ServiceFrontFactory.getIMerchantServiceFrontInstance().getMerchantInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setSize(500, 350);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(9,1));

        this.jPanelOne = new JPanel();
        this.jPanelTwo = new JPanel();
        this.jPanelThree = new JPanel();
        this.jPanelFour = new JPanel();
        this.jPanelFive = new JPanel();
        this.jPanelSix = new JPanel();
        this.jPanelSeven = new JPanel();
        this.jPanelEight = new JPanel();
        this.jPanelNine = new JPanel();

        this.jLabelName = new JLabel(this.merchant.getMname());
        this.jLabelMoney = new JLabel(String.valueOf(this.merchant.getMmoney()) + "¥");
        this.jButtonGoodsAdd = new JButton("Add Goods");
        this.jButtonGoodsList = new JButton("Show Goods");
        this.jButtonGoodsUpdate = new JButton("Update Goods");
        this.jButtonOrdersList = new JButton("Find Orders");
        this.jButtonOrdersUpdate = new JButton("Update Orders");
        this.jButtonUpdate = new JButton("Update Information");
        this.jButtonIntruction = new JButton("Show");
        this.jButtonChangePassword = new JButton("ChangePassword");

        //Add Goods按钮的监听事件
        this.jButtonGoodsAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadMerchantUserGoodsAddFrame(merchant.getMid()).start();
            }
        });

        //Add Goods按钮的监听事件
        this.jButtonGoodsList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadMerchantUserGoodsShowFrame(merchant.getMid()).start();
            }
        });

        //Update Goods按钮的监听事件
        this.jButtonGoodsUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadMerchantUserGoodsUpdtaeFrame(merchant.getMid()).start();
            }
        });

        //Find Orders按钮的监听事件
        this.jButtonOrdersList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadMerchantUserOrdersFindFrame(merchant.getMid()).start();
            }
        });

        //Update Orders按钮的监听事件
        this.jButtonOrdersUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadMerchantUserOrdersUpdateFrame(merchant.getMid()).start();
            }
        });

        //Update Information按钮的监听事件
        this.jButtonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadMerchantUserUpdateFrame(merchant.getMid()).start();
            }
        });

        //Show按钮的监听事件
        this.jButtonIntruction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadMerchantUserShowFrame(merchant.getMid()).start();
            }
        });

        //Change Password按钮的监听事件
        this.jButtonChangePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThreadMerchantUserChangePasswordFrame(merchant.getMid()).start();
            }
        });

        this.jPanelOne.add(this.jLabelName);
        this.jPanelOne.add(this.jLabelMoney);

        this.jPanelTwo.add(this.jButtonGoodsList);

        this.jPanelThree.add(this.jButtonGoodsUpdate);

        this.jPanelFour.add(this.jButtonOrdersList);

        this.jPanelFive.add(this.jButtonUpdate);

        this.jPanelSix.add(this.jButtonIntruction);

        this.jPanelSeven.add(this.jButtonChangePassword);

        this.jPanelEight.add(this.jButtonOrdersUpdate);

        this.jPanelNine.add(this.jButtonGoodsAdd);

        this.add(this.jPanelOne);
        this.add(this.jPanelNine);
        this.add(this.jPanelTwo);
        this.add(this.jPanelThree);
        this.add(this.jPanelEight);
        this.add(this.jPanelFour);
        this.add(this.jPanelFive);
        this.add(this.jPanelSix);
        this.add(this.jPanelSeven);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
