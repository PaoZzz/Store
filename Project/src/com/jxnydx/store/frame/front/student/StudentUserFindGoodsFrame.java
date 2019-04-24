package com.jxnydx.store.frame.front.student;

import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Goods;
import com.jxnydx.store.vo.Merchant;
import com.jxnydx.store.vo.Orders;
import com.jxnydx.store.vo.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class StudentUserFindGoodsFrame extends JFrame {
    private String mid;
    private Student student;
    private Merchant merchant;
    private List<Goods> goodsList;

    public StudentUserFindGoodsFrame(String frameName, String mid, final String sno) {
        this.mid = mid;
        try {
            this.student = ServiceFrontFactory.getIStudentServiceFrontInstance().getStudentInfo(sno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.merchant = ServiceFrontFactory.getIMerchantServiceFrontInstance().getMerchantInfo(mid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.goodsList = ServiceFrontFactory.getIGoodsServiceFrontInstance().getAllMerchantGoods(mid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(500, 350);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(this.goodsList.size(),3));

        Iterator<Goods> iter = this.goodsList.iterator();
        while (iter.hasNext()) {
            final Goods goods = iter.next();
            if (goods.getGstatus() != 1) {
                continue;
            }
            JPanel jPanelOnePointOne = new JPanel();
            JPanel jPanelOnePointTwo = new JPanel();
            JPanel jPanelOnePointThree = new JPanel();
            JLabel goodsName = new JLabel(goods.getGname());
            JLabel goodsPrice = new JLabel(String.valueOf(goods.getGprice()) + "¥");

            JButton jButton = new JButton("Buy");

            //Buy按钮的监听事件
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (student.getSmoney() >= goods.getGprice()) {
                        Orders vo = new Orders();
                        vo.setMid(merchant.getMid());
                        vo.setSno(student.getSno());
                        vo.setGname(goods.getGname());
                        vo.setOstatus(1);
                        vo.setPay(goods.getGprice());
                        student.setSmoney(student.getSmoney() - goods.getGprice());
                        merchant.setMmoney(merchant.getMmoney() + goods.getGprice());

                        try {
                            if (ServiceFrontFactory.getIStudentServiceFrontInstance().update(student)) {
                                if (ServiceFrontFactory.getIMerchantServiceFrontInstance().update(merchant)) {
                                    if (ServiceFrontFactory.getIOrdersServiceFrontInstance().insert(vo)) {
                                        JOptionPane.showMessageDialog(null, "Success for father Orders");
                                    } else {
                                        student.setSmoney(student.getSmoney() + goods.getGprice());
                                        merchant.setMmoney(merchant.getMmoney() - goods.getGprice());
                                        ServiceFrontFactory.getIStudentServiceFrontInstance().update(student);
                                        ServiceFrontFactory.getIMerchantServiceFrontInstance().update(merchant);
                                        JOptionPane.showMessageDialog(null, "Failure for father Orders");
                                    }
                                } else {
                                    student.setSmoney(student.getSmoney() + goods.getGprice());
                                    ServiceFrontFactory.getIStudentServiceFrontInstance().update(student);
                                    JOptionPane.showMessageDialog(null, "Merchant income the wrong");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Student Pay the wrong");
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Money is not enough");
                    }
                }
            });

            jPanelOnePointOne.add(goodsName);
            jPanelOnePointTwo.add(goodsPrice);
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
