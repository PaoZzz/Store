package com.jxnydx.store.frame.back;

import com.jxnydx.store.factory.ServiceBackFactory;
import com.jxnydx.store.vo.Merchant;
import com.jxnydx.util.validate.ValidateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUserMerchantAddFrame extends JFrame {
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

    private JLabel jLabel;
    private JLabel jLabelSno;
    private JLabel jLabelPassword;
    private JLabel jLabelName;
    private JLabel jLabelMoney;
    private JLabel jLabelStatus;
    private JLabel jLabelLocate;
    private JLabel jLabelPhone;

    private JTextField jTextFieldMid;
    private JTextField jTextFieldPassword;
    private JTextField jTextFieldName;
    private JTextField jTextFieldMoney;
    private JTextField jTextFieldStatus;
    private JTextField jTextFieldLocate;
    private JTextField jTextFieldPhone;

    private JButton jButton;

    public AdminUserMerchantAddFrame(String frameName) {
        this.setSize(500, 500);
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

        this.jLabel = new JLabel("Registering Merchant account");
        this.jLabelSno = new JLabel("账号:");
        this.jLabelPassword = new JLabel("密码:");
        this.jLabelName = new JLabel("店名:");
        this.jLabelMoney = new JLabel("余额:");
        this.jLabelStatus = new JLabel("状态:");
        this.jLabelLocate = new JLabel("地址:");
        this.jLabelPhone = new JLabel("电话:");

        this.jTextFieldMid = new JTextField(20);
        this.jTextFieldPassword = new JTextField(20);
        this.jTextFieldName = new JTextField(20);
        this.jTextFieldMoney = new JTextField(20);
        this.jTextFieldStatus = new JTextField(20);
        this.jTextFieldLocate = new JTextField(20);
        this.jTextFieldPhone = new JTextField(20);

        this.jButton = new JButton("Register");

        //Register按钮的监听事件
        this.jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ValidateUtil.validateEmpty(jTextFieldMid.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldPassword.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldName.getText()) &&
                        ValidateUtil.validateDouble(jTextFieldMoney.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldLocate.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldPhone.getText())) {
                    Merchant vo = new Merchant();
                    vo.setMid(jTextFieldMid.getText());
                    vo.setMpassword(jTextFieldPassword.getText());
                    vo.setMname(jTextFieldName.getText());
                    vo.setMmoney(Double.valueOf(jTextFieldMoney.getText()));
                    vo.setMlocate(jTextFieldLocate.getText());
                    vo.setMphone(jTextFieldPhone.getText());
                    if (jTextFieldStatus.getText().equals("") || jTextFieldStatus.getText().equals("激活") || jTextFieldStatus.getText().equals("1")) {
                        vo.setMstatus(1);
                        try {
                            if (ServiceBackFactory.getIMerchantServiceBackInstance().insert(vo)) {
                                JOptionPane.showMessageDialog(null, "Success for Apply account of Merchant");
                                setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Failure for Apply account of Merchant");
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } else if (jTextFieldStatus.getText().equals("不激活") || jTextFieldStatus.getText().equals("0")) {
                        vo.setMstatus(0);
                        try {
                            if (ServiceBackFactory.getIMerchantServiceBackInstance().insert(vo)) {
                                JOptionPane.showMessageDialog(null, "Success for Apply account of Merchant");
                                setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Failure for Apply account of Merchant");
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error for Inputing Status");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error for Inputing Empty");
                }
            }
        });

        this.jPanelOne.add(this.jLabel);

        this.jPanelTwo.add(this.jLabelSno);
        this.jPanelTwo.add(this.jTextFieldMid);

        this.jPanelThree.add(this.jLabelPassword);
        this.jPanelThree.add(this.jTextFieldPassword);

        this.jPanelFour.add(this.jLabelName);
        this.jPanelFour.add(this.jTextFieldName);

        this.jPanelFive.add(this.jLabelMoney);
        this.jPanelFive.add(this.jTextFieldMoney);

        this.jPanelSix.add(this.jLabelStatus);
        this.jPanelSix.add(this.jTextFieldStatus);

        this.jPanelSeven.add(this.jLabelLocate);
        this.jPanelSeven.add(this.jTextFieldLocate);

        this.jPanelEight.add(this.jLabelPhone);
        this.jPanelEight.add(this.jTextFieldPhone);

        this.jPanelNine.add(this.jButton);

        this.add(this.jPanelOne);
        this.add(this.jPanelTwo);
        this.add(this.jPanelThree);
        this.add(this.jPanelFour);
        this.add(this.jPanelFive);
        this.add(this.jPanelSix);
        this.add(this.jPanelSeven);
        this.add(this.jPanelEight);
        this.add(this.jPanelNine);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AdminUserMerchantAddFrame("Register");
    }
}
