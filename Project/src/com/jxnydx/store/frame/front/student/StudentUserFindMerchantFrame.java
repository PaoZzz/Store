package com.jxnydx.store.frame.front.student;

import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Merchant;
import com.jxnydx.util.threadframe.student.ThreadStudentUserFindGoodsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class StudentUserFindMerchantFrame extends JFrame {
    private List<Merchant> merchantList;

    public StudentUserFindMerchantFrame(String frameName, final String sno) {
        try {
            this.merchantList = ServiceFrontFactory.getIStudentServiceFrontInstance().getAllMerchant();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(500, 600);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(this.merchantList.size(),4));

        Iterator<Merchant> iter = merchantList.iterator();
        while (iter.hasNext()) {
            final Merchant merchant = iter.next();
            JPanel jPanelOnePointOne = new JPanel();
            JPanel jPanelOnePointTwo = new JPanel();
            JPanel jPanelOnePointThree = new JPanel();
            JPanel jPanelOnePointFour = new JPanel();
            JLabel merchantName = new JLabel(merchant.getMname());
            JLabel merchantLocate = new JLabel(merchant.getMlocate());
            JLabel merchantPhone = new JLabel("电话:" + merchant.getMphone());
            JButton jButton = new JButton("Goods");

            //Goods按钮的监听事件
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ThreadStudentUserFindGoodsFrame(merchant.getMid(), sno).start();
                }
            });

            jPanelOnePointOne.add(merchantName);
            jPanelOnePointTwo.add(merchantLocate);
            jPanelOnePointThree.add(merchantPhone);
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
