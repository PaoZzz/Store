package com.jxnydx.store.frame.front.merchant;

import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Goods;
import com.jxnydx.util.validate.ValidateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

public class MerchantUserGoodsUpdateFrame extends JFrame {
    private String mid;
    private List<Goods> goodsList;

    public MerchantUserGoodsUpdateFrame(String frameName, String mid) {
        this.mid = mid;
        try {
            goodsList = ServiceFrontFactory.getIGoodsServiceFrontInstance().getAllMerchantGoods(mid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(800, 350);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(this.goodsList.size(),4));

        Iterator<Goods> iter = this.goodsList.iterator();
        while (iter.hasNext()) {
            final Goods goods = iter.next();
            JPanel jPanelOnePointOne = new JPanel();
            JPanel jPanelOnePointTwo = new JPanel();
            JPanel jPanelOnePointThree = new JPanel();
            JPanel jPanelOnePointFour = new JPanel();

            JLabel goodsName = new JLabel("Name:");
            JLabel goodsPrice = new JLabel("Price:");
            JLabel goodsStatus = new JLabel("Status:");
            JLabel goodsPriceSign = new JLabel("¥");

            final JTextField jTextFieldName = new JTextField(goods.getGname(), 10);
            final JTextField jTextFieldPrice = new JTextField(String.valueOf(goods.getGprice()), 3);
            JTextField jTextFieldStatus = null;
            if (goods.getGstatus() == 0) {
                jTextFieldStatus = new JTextField("下架");
            } else if(goods.getGstatus() == 1) {
                jTextFieldStatus = new JTextField("上架");
            } else if(goods.getGstatus() == 2) {
                jTextFieldStatus = new JTextField("删除");
            }
            final JTextField finaljTextFieldStatus = jTextFieldStatus;
            JButton jButton = new JButton("Update");

            //Update按钮的监听事件
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Getting gid of goods, it can back me to realize method, in short, Updating.
                    Goods vo = goods;
                    String price = jTextFieldPrice.getText();
                    if (ValidateUtil.validateEmpty(jTextFieldName.getText()) &&
                            ValidateUtil.validateDouble(price) &&
                            ValidateUtil.validateEmpty(finaljTextFieldStatus.getText())) {
                        vo.setGname(jTextFieldName.getText());
                        vo.setGprice(Double.parseDouble(price));
                        if (finaljTextFieldStatus.getText().equals("上架") || finaljTextFieldStatus.getText().equals("1")) {
                            vo.setGstatus(1);
                            try {
                                if (ServiceFrontFactory.getIGoodsServiceFrontInstance().update(vo)) {
                                    JOptionPane.showMessageDialog(null, "Success for Updating");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failure for Updating");
                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        } else if (finaljTextFieldStatus.getText().equals("下架") || finaljTextFieldStatus.getText().equals("0")) {
                            vo.setGstatus(0);
                            try {
                                if (ServiceFrontFactory.getIGoodsServiceFrontInstance().update(vo)) {
                                    JOptionPane.showMessageDialog(null, "Success for Updating");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failure for Updating");
                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Updating Error for Status");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error for Inputing");
                    }
                }
            });

            jPanelOnePointOne.add(goodsName);
            jPanelOnePointOne.add(jTextFieldName);

            jPanelOnePointTwo.add(goodsPrice);
            jPanelOnePointTwo.add(jTextFieldPrice);
            jPanelOnePointTwo.add(goodsPriceSign);

            jPanelOnePointThree.add(goodsStatus);
            jPanelOnePointThree.add(jTextFieldStatus);

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
