package com.jxnydx.store.frame.back;

import com.jxnydx.store.factory.ServiceBackFactory;
import com.jxnydx.store.vo.Merchant;
import com.jxnydx.util.threadframe.admin.ThreadAdminUserMerchantUpdateFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class AdminUserMerchantUpdateAllFrame extends JFrame {
    private List<Merchant> merchantList;

    public AdminUserMerchantUpdateAllFrame(String frameName) {
        try {
            this.merchantList = ServiceBackFactory.getIMerchantServiceBackInstance().list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(700, 400);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(this.merchantList.size(),3));

        Iterator<Merchant> iter = merchantList.iterator();
        while (iter.hasNext()) {
            final Merchant merchant = iter.next();
            JPanel jPanelOnePointOne = new JPanel();
            JPanel jPanelOnePointTwo = new JPanel();
            JPanel jPanelOnePointThree = new JPanel();
            JLabel studentSno = new JLabel("Account:" + merchant.getMid());
            JLabel studentName = new JLabel("Name:" + merchant.getMname());
            JButton jButton = new JButton("Update");

            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ThreadAdminUserMerchantUpdateFrame(merchant.getMid()).start();
                }
            });

            jPanelOnePointOne.add(studentSno);
            jPanelOnePointTwo.add(studentName);
            jPanelOnePointThree.add(jButton);

            this.add(jPanelOnePointOne);
            this.add(jPanelOnePointTwo);
            this.add(jPanelOnePointThree);
        }

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AdminUserMerchantUpdateAllFrame("Update Merchant");
    }
}
