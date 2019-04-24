package com.jxnydx.store.frame.back;

import com.jxnydx.store.factory.ServiceBackFactory;
import com.jxnydx.store.vo.Merchant;
import com.jxnydx.util.validate.ValidateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUserMerchantUpdateFrame extends JFrame{
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
    private JTextField jTextFieldStatus;
    private JTextField jTextFieldLocate;
    private JTextField jTextFieldPhone;

    private JButton jButton;

    public AdminUserMerchantUpdateFrame(String frameName, final String id) {
        try {
            this.merchant = ServiceBackFactory.getIMerchantServiceBackInstance().getMerchantInfo(id);
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

        this.introduction = new JLabel("学生信息更新");
        this.jLabelMid = new JLabel("账号: " + this.merchant.getMid());
        this.jLabelMname = new JLabel("店名: ");
        this.jLabelMmoney = new JLabel("资产: " + this.merchant.getMmoney());
        this.jLabelMstatus = new JLabel("状态: ");
        this.jLabelMlocate = new JLabel("地址:");
        this.jLabelMphone = new JLabel("电话:");

        this.jTextFieldName = new JTextField(this.merchant.getMname(), 10);
        if (this.merchant.getMstatus() == 0) {
            this.jTextFieldStatus = new JTextField("未激活", 4);
        } else if (this.merchant.getMstatus() == 1) {
            this.jTextFieldStatus = new JTextField("已激活", 4);
        } else if(this.merchant.getMstatus() == 2) {
            this.jTextFieldStatus = new JTextField("已冻结", 4);
        }
        this.jTextFieldLocate = new JTextField(this.merchant.getMlocate(), 20);
        this.jTextFieldPhone = new JTextField(this.merchant.getMphone(), 10);

        this.jButton = new JButton("Update");

        //Update按钮的监听事件
        this.jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ValidateUtil.validateEmpty(jTextFieldName.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldStatus.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldLocate.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldPhone.getText())) {
                    if (merchant.getMname().equals(jTextFieldName.getText()) &&
                            merchant.getMstatus().equals(jTextFieldStatus.getText()) &&
                            merchant.getMlocate().equals(jTextFieldLocate.getText()) &&
                            merchant.getMphone().equals(jTextFieldPhone.getText())) {
                        JOptionPane.showMessageDialog(null, "Needn't to Update");
                    } else {
                        merchant.setMname(jTextFieldName.getText());
                        merchant.setMlocate(jTextFieldLocate.getText());
                        merchant.setMphone(jTextFieldPhone.getText());
                        if (jTextFieldStatus.getText().equals("已激活") || jTextFieldStatus.getText().equals("1") || jTextFieldStatus.getText().equals("激活")) {
                            merchant.setMstatus(1);
                            try {
                                if (ServiceBackFactory.getIMerchantServiceBackInstance().update(merchant)) {
                                    JOptionPane.showMessageDialog(null, "Success for Updating");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failure for Updating");
                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        } else if (jTextFieldStatus.getText().equals("未激活") || jTextFieldStatus.getText().equals("0") || jTextFieldStatus.getText().equals("未激活")) {
                            merchant.setMstatus(0);
                            try {
                                if (ServiceBackFactory.getIMerchantServiceBackInstance().update(merchant)) {
                                    JOptionPane.showMessageDialog(null, "Success for Updating");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failure for Updating");
                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        } else if (jTextFieldStatus.getText().equals("已冻结") || jTextFieldStatus.getText().equals("2") || jTextFieldStatus.getText().equals("冻结")) {
                            merchant.setMstatus(2);
                            try {
                                if (ServiceBackFactory.getIMerchantServiceBackInstance().update(merchant)) {
                                    JOptionPane.showMessageDialog(null, "Success for Updating");
                                    setVisible(false);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failure for Updating");
                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Error for Inputing Status");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error for Inputing Empty");
                }
            }
        });

        this.jPanelOne.add(this.introduction);

        this.jPanelTwo.add(this.jLabelMid);

        this.jPanelThree.add(this.jLabelMname);
        this.jPanelThree.add(this.jTextFieldName);

        this.jPanelFour.add(this.jLabelMmoney);

        this.jPanelFive.add(this.jLabelMstatus);
        this.jPanelFive.add(this.jTextFieldStatus);

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
