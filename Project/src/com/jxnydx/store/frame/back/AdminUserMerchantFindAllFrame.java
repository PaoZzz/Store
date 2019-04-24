package com.jxnydx.store.frame.back;

import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Merchant;
import com.jxnydx.util.threadframe.admin.ThreadAdminUserMerchantIntroFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class AdminUserMerchantFindAllFrame extends JFrame {
    private List<Merchant> merchantList;

    public AdminUserMerchantFindAllFrame(String frameName) {
        try {
            this.merchantList = ServiceFrontFactory.getIStudentServiceFrontInstance().getAllMerchant();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(500, 500);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(this.merchantList.size(),3));

        Iterator<Merchant> iter = merchantList.iterator();
        while (iter.hasNext()) {
            final Merchant merchant = iter.next();
            JPanel jPanelOnePointOne = new JPanel();
            JPanel jPanelOnePointTwo = new JPanel();
            JPanel jPanelOnePointThree = new JPanel();
            JLabel merchantName = new JLabel(merchant.getMid());
            JLabel merchantLocate = new JLabel(merchant.getMname());
            JButton jButton = new JButton("Intro");

            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ThreadAdminUserMerchantIntroFrame(merchant.getMid()).start();
                }
            });

            jPanelOnePointOne.add(merchantName);
            jPanelOnePointTwo.add(merchantLocate);
            jPanelOnePointThree.add(jButton);

            this.add(jPanelOnePointOne);
            this.add(jPanelOnePointTwo);
            this.add(jPanelOnePointThree);
        }

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
