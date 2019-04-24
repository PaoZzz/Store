package com.jxnydx.store.frame.front.merchant;

import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Merchant;
import com.jxnydx.util.validate.ValidateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MerchantUserUpdateFrame extends JFrame{
    private Merchant merchant;

    private JPanel jPanelOne;
    private JPanel jPanelTwo;
    private JPanel jPanelThree;
    private JPanel jPanelFour;
    private JPanel jPanelFive;
    private JPanel jPanelSix;
    private JPanel jPanelSeven;
    private JPanel jPanelEight;

    private JLabel introduction;
    private JLabel jLabelMid;
    private JLabel jLabelMname;
    private JLabel jLabelMmoney;
    private JLabel jLabelMstatus;
    private JLabel jLabelMlocate;
    private JLabel jLabelMphone;

    private JTextField jTextFieldName;
    private JTextField jTextFieldLocate;
    private JTextField jTextFieldPhone;

    private JButton jButton;

    public MerchantUserUpdateFrame(String frameName, String id) {
        try {
            this.merchant = ServiceFrontFactory.getIMerchantServiceFrontInstance().getMerchantInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(500, 600);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(8,1));

        this.jPanelOne = new JPanel();
        this.jPanelTwo = new JPanel();
        this.jPanelThree = new JPanel();
        this.jPanelFour = new JPanel();
        this.jPanelFive = new JPanel();
        this.jPanelSix = new JPanel();
        this.jPanelSeven = new JPanel();
        this.jPanelEight = new JPanel();

        this.introduction = new JLabel("商家信息简介");
        this.jLabelMid = new JLabel("账号: " + this.merchant.getMid());
        this.jLabelMname = new JLabel("店名: ");
        this.jLabelMmoney = new JLabel("余额: " + this.merchant.getMmoney());
        if (this.merchant.getMstatus() == 0) {
            this.jLabelMstatus = new JLabel("状态: " +  "未激活");
        } else if (this.merchant.getMstatus() == 1) {
            this.jLabelMstatus = new JLabel("状态: " +  "已激活");
        } else if(this.merchant.getMstatus() == 2) {
            this.jLabelMstatus = new JLabel("状态: " +  "已冻结");
        }
        this.jLabelMlocate = new JLabel("地址:");
        this.jLabelMphone = new JLabel("电话:");

        this.jTextFieldName = new JTextField(this.merchant.getMname(), 10);
        this.jTextFieldLocate = new JTextField(this.merchant.getMlocate(), 12);
        this.jTextFieldPhone = new JTextField(this.merchant.getMphone(), 9);

        this.jButton = new JButton("Update");

        //Update按钮的监听事件
        this.jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ValidateUtil.validateEmpty(jTextFieldName.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldLocate.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldPhone.getText())) {
                    merchant.setMname(jTextFieldName.getText());
                    merchant.setMlocate(jTextFieldLocate.getText());
                    merchant.setMphone(jTextFieldPhone.getText());
                    try {
                        if (ServiceFrontFactory.getIMerchantServiceFrontInstance().update(merchant)) {
                            JOptionPane.showMessageDialog(null, "Success for Updating");
                            setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Failure for Updating");
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error for Inputing");
                }
            }
        });

        this.jPanelOne.add(this.introduction);

        this.jPanelTwo.add(this.jLabelMid);

        this.jPanelThree.add(this.jLabelMname);
        this.jPanelThree.add(this.jTextFieldName);

        this.jPanelFour.add(this.jLabelMmoney);

        this.jPanelFive.add(this.jLabelMstatus);

        this.jPanelSix.add(this.jLabelMlocate);
        this.jPanelSix.add(this.jTextFieldLocate);

        this.jPanelSeven.add(this.jLabelMphone);
        this.jPanelSeven.add(this.jTextFieldPhone);

        this.jPanelEight.add(this.jButton);

        this.add(this.jPanelOne);
        this.add(this.jPanelTwo);
        this.add(this.jPanelThree);
        this.add(this.jPanelFour);
        this.add(this.jPanelFive);
        this.add(this.jPanelSix);
        this.add(this.jPanelSeven);
        this.add(this.jPanelEight);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
