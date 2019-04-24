package com.jxnydx.store.frame.back;

import com.jxnydx.store.factory.ServiceBackFactory;
import com.jxnydx.store.vo.Orders;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;

public class AdminUserOrdersAllFrame extends JFrame {
    private List<Orders> ordersList;

    public AdminUserOrdersAllFrame(String frameName) {
        try {
            this.ordersList = ServiceBackFactory.getIOrdersServiceBackInstance().list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(1100, 400);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(this.ordersList.size(),7));

        Iterator<Orders> iter = ordersList.iterator();
        while (iter.hasNext()) {
            final Orders orders = iter.next();
            JPanel jPanelOnePointOne = new JPanel();
            JPanel jPanelOnePointTwo = new JPanel();
            JPanel jPanelOnePointThree = new JPanel();
            JPanel jPanelOnePointFour = new JPanel();
            JPanel jPanelOnePointFive = new JPanel();
            JPanel jPanelOnePointSix = new JPanel();
            JPanel jPanelOnePointSeven = new JPanel();

            JLabel ordersNum = new JLabel("Num:" + String.valueOf(orders.getOid()));
            JLabel ordersMerchant = null;
            try {
                ordersMerchant = new JLabel("Merchant:" + ServiceBackFactory.getIMerchantServiceBackInstance().getMerchantInfo(orders.getMid()).getMname());
            } catch (Exception e) {
                e.printStackTrace();
            }
            JLabel ordersSrudent = null;
            try {
                ordersSrudent = new JLabel("Student:" + ServiceBackFactory.getIStudentServiceBackInstance().getStudentInfo(orders.getSno()).getSname());
            } catch (Exception e) {
                e.printStackTrace();
            }
            JLabel ordersGoods = new JLabel("Goods:" + orders.getGname());
            JLabel ordersPrice = new JLabel("Price:" + String.valueOf(orders.getPay()) + "¥");
            JLabel ordersDate = new JLabel(orders.getCredate().toString());
            JLabel ordersStatus = null;
            if (orders.getOstatus() == 0) {
                ordersStatus = new JLabel("已处理");
            } else if (orders.getOstatus() == 1) {
                ordersStatus = new JLabel("未处理");
            }

            jPanelOnePointSix.add(ordersNum);
            jPanelOnePointSeven.add(ordersMerchant);
            jPanelOnePointOne.add(ordersSrudent);
            jPanelOnePointTwo.add(ordersGoods);
            jPanelOnePointThree.add(ordersPrice);
            jPanelOnePointFour.add(ordersDate);
            jPanelOnePointFive.add(ordersStatus);

            this.add(jPanelOnePointSix);
            this.add(jPanelOnePointSeven);
            this.add(jPanelOnePointOne);
            this.add(jPanelOnePointTwo);
            this.add(jPanelOnePointThree);
            this.add(jPanelOnePointFour);
            this.add(jPanelOnePointFive);
        }

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
