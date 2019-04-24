package com.jxnydx.store.frame.back;

import com.jxnydx.store.factory.ServiceBackFactory;
import com.jxnydx.store.vo.Student;
import com.jxnydx.util.validate.ValidateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUserStudentAddFrame extends JFrame {
    private Student student;

    private JPanel jPanelOne;
    private JPanel jPanelTwo;
    private JPanel jPanelThree;
    private JPanel jPanelFour;
    private JPanel jPanelFive;
    private JPanel jPanelSix;
    private JPanel jPanelSeven;
    private JPanel jPanelEight;
    private JPanel jPanelNine;
    private JPanel jPanelTen;

    private JLabel jLabel;
    private JLabel jLabelSno;
    private JLabel jLabelPassword;
    private JLabel jLabelName;
    private JLabel jLabelMoney;
    private JLabel jLabelStatus;
    private JLabel jLabelClass;
    private JLabel jLabelLocate;
    private JLabel jLabelPhone;

    private JTextField jTextFieldSno;
    private JTextField jTextFieldPassword;
    private JTextField jTextFieldName;
    private JTextField jTextFieldMoney;
    private JTextField jTextFieldStatus;
    private JTextField jTextFieldClass;
    private JTextField jTextFieldLocate;
    private JTextField jTextFieldPhone;

    private JButton jButton;

    public AdminUserStudentAddFrame(String frameName) {
        this.setSize(500, 500);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(10,1));

        this.jPanelOne = new JPanel();
        this.jPanelTwo = new JPanel();
        this.jPanelThree = new JPanel();
        this.jPanelFour = new JPanel();
        this.jPanelFive = new JPanel();
        this.jPanelSix = new JPanel();
        this.jPanelSeven = new JPanel();
        this.jPanelEight = new JPanel();
        this.jPanelNine = new JPanel();
        this.jPanelTen = new JPanel();

        this.jLabel = new JLabel("Registering Student account");
        this.jLabelSno = new JLabel("账号:");
        this.jLabelPassword = new JLabel("密码:");
        this.jLabelName = new JLabel("姓名:");
        this.jLabelMoney = new JLabel("余额:");
        this.jLabelStatus = new JLabel("状态:");
        this.jLabelClass = new JLabel("班级:");
        this.jLabelLocate = new JLabel("地址:");
        this.jLabelPhone = new JLabel("电话:");

        this.jTextFieldSno = new JTextField(20);
        this.jTextFieldPassword = new JTextField(20);
        this.jTextFieldName = new JTextField(20);
        this.jTextFieldMoney = new JTextField(20);
        this.jTextFieldStatus = new JTextField(20);
        this.jTextFieldClass = new JTextField(20);
        this.jTextFieldLocate = new JTextField(20);
        this.jTextFieldPhone = new JTextField(20);

        this.jButton = new JButton("Register");
        //Register按钮的监听事件
        this.jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ValidateUtil.validateEmpty(jTextFieldSno.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldPassword.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldName.getText()) &&
                        ValidateUtil.validateDouble(jTextFieldMoney.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldClass.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldLocate.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldPhone.getText())) {
                    Student vo = new Student();
                    vo.setSno(jTextFieldSno.getText());
                    vo.setSpassword(jTextFieldPassword.getText());
                    vo.setSname(jTextFieldName.getText());
                    vo.setSmoney(Double.valueOf(jTextFieldMoney.getText()));
                    vo.setSclass(jTextFieldClass.getText());
                    vo.setSlocate(jTextFieldLocate.getText());
                    vo.setSphone(jTextFieldPhone.getText());
                    if (jTextFieldStatus.getText().equals("") || jTextFieldStatus.getText().equals("激活") || jTextFieldStatus.getText().equals("1")) {
                        vo.setSstatus(1);
                        try {
                            if (ServiceBackFactory.getIStudentServiceBackInstance().insert(vo)) {
                                JOptionPane.showMessageDialog(null, "Success for Apply account of Student");
                            } else {
                                JOptionPane.showMessageDialog(null, "Failure for Apply account of Student");
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } else if (jTextFieldStatus.getText().equals("不激活") || jTextFieldStatus.getText().equals("0")) {
                        vo.setSstatus(0);
                        try {
                            if (ServiceBackFactory.getIStudentServiceBackInstance().insert(vo)) {
                                JOptionPane.showMessageDialog(null, "Success for Apply account of Student");
                                setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Failure for Apply account of Student");
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
        this.jPanelTwo.add(this.jTextFieldSno);

        this.jPanelThree.add(this.jLabelPassword);
        this.jPanelThree.add(this.jTextFieldPassword);

        this.jPanelFour.add(this.jLabelName);
        this.jPanelFour.add(this.jTextFieldName);

        this.jPanelFive.add(this.jLabelMoney);
        this.jPanelFive.add(this.jTextFieldMoney);

        this.jPanelSix.add(this.jLabelStatus);
        this.jPanelSix.add(this.jTextFieldStatus);

        this.jPanelSeven.add(this.jLabelClass);
        this.jPanelSeven.add(this.jTextFieldClass);

        this.jPanelEight.add(this.jLabelLocate);
        this.jPanelEight.add(this.jTextFieldLocate);

        this.jPanelNine.add(this.jLabelPhone);
        this.jPanelNine.add(this.jTextFieldPhone);

        this.jPanelTen.add(this.jButton);

        this.add(this.jPanelOne);
        this.add(this.jPanelTwo);
        this.add(this.jPanelThree);
        this.add(this.jPanelFour);
        this.add(this.jPanelFive);
        this.add(this.jPanelSix);
        this.add(this.jPanelSeven);
        this.add(this.jPanelEight);
        this.add(this.jPanelNine);
        this.add(this.jPanelTen);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AdminUserStudentAddFrame("Register");
    }
}
