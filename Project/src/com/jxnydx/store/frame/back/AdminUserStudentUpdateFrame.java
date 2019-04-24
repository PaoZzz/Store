package com.jxnydx.store.frame.back;

import com.jxnydx.store.factory.ServiceBackFactory;
import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Student;
import com.jxnydx.util.validate.ValidateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUserStudentUpdateFrame extends JFrame{
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

    private JLabel introduction;
    private JLabel jLabelSno;
    private JLabel jLabelSname;
    private JLabel jLabelSmoney;
    private JLabel jLabelSstatus;
    private JLabel jLabelSclass;
    private JLabel jLabelSlocate;
    private JLabel jLabelSphone;

    private JTextField jTextFieldName;
    private JTextField jTextFieldStatus;
    private JTextField jTextFieldClass;
    private JTextField jTextFieldLocate;
    private JTextField jTextFieldPhone;

    private JButton jButton;

    public AdminUserStudentUpdateFrame(String frameName, String id) {
        try {
            this.student = ServiceFrontFactory.getIStudentServiceFrontInstance().getStudentInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(500, 600);
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


        this.introduction = new JLabel("学生信息更新");
        this.jLabelSno = new JLabel("账号: " + this.student.getSno());
        this.jLabelSname = new JLabel("姓名: ");
        this.jLabelSmoney = new JLabel("余额: " + this.student.getSmoney());
        this.jLabelSstatus = new JLabel("状态: ");
        this.jLabelSclass = new JLabel("班级: ");
        this.jLabelSlocate = new JLabel("地址:");
        this.jLabelSphone = new JLabel("电话:");

        this.jTextFieldName = new JTextField(this.student.getSname(), 4);
        if (this.student.getSstatus() == 0) {
            this.jTextFieldStatus = new JTextField("未激活", 4);
        } else if (this.student.getSstatus() == 1) {
            this.jTextFieldStatus = new JTextField("已激活", 4);
        } else if(this.student.getSstatus() == 2) {
            this.jTextFieldStatus = new JTextField("已冻结", 4);
        }
        this.jTextFieldClass = new JTextField(this.student.getSclass(), 10);
        this.jTextFieldLocate = new JTextField(this.student.getSlocate(), 10);
        this.jTextFieldPhone = new JTextField(this.student.getSphone(), 10);

        this.jButton = new JButton("Update");

        //Update按钮的监听事件
        this.jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ValidateUtil.validateEmpty(jTextFieldName.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldStatus.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldLocate.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldPhone.getText())) {
                    if (student.getSname().equals(jTextFieldName.getText()) &&
                            student.getSstatus().equals(jTextFieldStatus.getText()) &&
                            student.getSlocate().equals(jTextFieldLocate.getText()) &&
                            student.getSphone().equals(jTextFieldPhone.getText())) {
                        JOptionPane.showMessageDialog(null, "Needn't to Update");
                    } else {
                        student.setSname(jTextFieldName.getText());
                        student.setSlocate(jTextFieldLocate.getText());
                        student.setSphone(jTextFieldPhone.getText());
                        if (jTextFieldStatus.getText().equals("已激活") || jTextFieldStatus.getText().equals("1") || jTextFieldStatus.getText().equals("激活")) {
                            student.setSstatus(1);
                            try {
                                if (ServiceBackFactory.getIStudentServiceBackInstance().update(student)) {
                                    JOptionPane.showMessageDialog(null, "Success for Updating");
                                    setVisible(false);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failure for Updating");
                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        } else if (jTextFieldStatus.getText().equals("未激活") || jTextFieldStatus.getText().equals("0") || jTextFieldStatus.getText().equals("未激活")) {
                            student.setSstatus(0);
                            try {
                                if (ServiceBackFactory.getIStudentServiceBackInstance().update(student)) {
                                    JOptionPane.showMessageDialog(null, "Success for Updating");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failure for Updating");
                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        } else if (jTextFieldStatus.getText().equals("已冻结") || jTextFieldStatus.getText().equals("2") || jTextFieldStatus.getText().equals("冻结")) {
                            student.setSstatus(2);
                            try {
                                if (ServiceBackFactory.getIStudentServiceBackInstance().update(student)) {
                                    JOptionPane.showMessageDialog(null, "Success for Updating");
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

        this.jPanelTwo.add(this.jLabelSno);

        this.jPanelThree.add(this.jLabelSname);
        this.jPanelThree.add(this.jTextFieldName);

        this.jPanelFour.add(this.jLabelSmoney);

        this.jPanelFive.add(this.jLabelSstatus);
        this.jPanelFive.add(this.jTextFieldStatus);

        this.jPanelSix.add(this.jLabelSclass);
        this.jPanelSix.add(this.jTextFieldClass);

        this.jPanelSeven.add(this.jLabelSlocate);
        this.jPanelSeven.add(this.jTextFieldLocate);

        this.jPanelEight.add(this.jLabelSphone);
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
}
