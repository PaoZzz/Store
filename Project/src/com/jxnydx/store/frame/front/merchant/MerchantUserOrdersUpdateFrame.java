package com.jxnydx.store.frame.front.merchant;

import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Orders;
import com.jxnydx.util.validate.ValidateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class MerchantUserOrdersUpdateFrame extends JFrame {
    private String mid;

    private List<Orders> ordersList;

    public MerchantUserOrdersUpdateFrame(String frameName, String mid) {
        this.mid = mid;
        try {
            this.ordersList = ServiceFrontFactory.getIOrdersServiceFrontInstance().getMerchantAllOrders(this.mid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(1000, 400);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(this.ordersList.size(),6));

        Iterator<Orders> iter = ordersList.iterator();
        while (iter.hasNext()) {
            final Orders orders = iter.next();
            JPanel jPanelOnePointOne = new JPanel();
            JPanel jPanelOnePointTwo = new JPanel();
            JPanel jPanelOnePointThree = new JPanel();
            JPanel jPanelOnePointFour = new JPanel();
            JPanel jPanelOnePointFive = new JPanel();
            JPanel jPanelOnePointSix = new JPanel();
            JLabel ordersMerchant = null;
            try {
                ordersMerchant = new JLabel(ServiceFrontFactory.getIStudentServiceFrontInstance().getStudentInfo(orders.getSno()).getSname());
            } catch (Exception e) {
                e.printStackTrace();
            }
            JLabel ordersGoods = new JLabel(orders.getGname());
            JLabel ordersPrice = new JLabel(String.valueOf(orders.getPay()) + "¥");
            JLabel ordersDate = new JLabel(orders.getCredate().toString());
            JLabel ordersStatus = new JLabel("Status:");
            JTextField jTextFieldStatus = null;
            if (orders.getOstatus() == 0) {
                jTextFieldStatus = new JTextField("已处理");
            } else if (orders.getOstatus() == 1) {
                jTextFieldStatus = new JTextField("未处理");
            }
            JButton jButton = new JButton("Update");

            final JTextField finalJTextFieldStatus = jTextFieldStatus;

            //Update按钮的监听事件
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Orders vo = orders;
                    if (ValidateUtil.validateEmpty(finalJTextFieldStatus.getText())) {
                        if (finalJTextFieldStatus.getText().equals("未处理") || finalJTextFieldStatus.getText().equals("1")) {
                            if (!orders.getOstatus().equals(1)) {
                                try {
                                    if (ServiceFrontFactory.getIOrdersServiceFrontInstance().updateStatus(vo.getOid(), 1)) {
                                        JOptionPane.showMessageDialog(null, "Success for Updating");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Failure for Updating");
                                    }
                                } catch (Exception e1) {
                                    e1.printStackTrace();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Needn't Update");
                            }
                        } else if (finalJTextFieldStatus.getText().equals("已处理") || finalJTextFieldStatus.getText().equals("0")) {
                            if (!orders.getOstatus().equals(0)) {
                                try {
                                    if (ServiceFrontFactory.getIOrdersServiceFrontInstance().updateStatus(vo.getOid(), 0)) {
                                        JOptionPane.showMessageDialog(null, "Success for Updating");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Failure for Updating");
                                    }
                                } catch (Exception e1) {
                                    e1.printStackTrace();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Needn't Update");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Updating Error for Status");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Updating Error for Status");
                    }
                }
            });

            jPanelOnePointOne.add(ordersMerchant);
            jPanelOnePointTwo.add(ordersGoods);
            jPanelOnePointThree.add(ordersPrice);
            jPanelOnePointFour.add(ordersDate);
            jPanelOnePointFive.add(ordersStatus);
            jPanelOnePointFive.add(jTextFieldStatus);
            jPanelOnePointSix.add(jButton);

            this.add(jPanelOnePointOne);
            this.add(jPanelOnePointTwo);
            this.add(jPanelOnePointThree);
            this.add(jPanelOnePointFour);
            this.add(jPanelOnePointFive);
            this.add(jPanelOnePointSix);
        }

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
