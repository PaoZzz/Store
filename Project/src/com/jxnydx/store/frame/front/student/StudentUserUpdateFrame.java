package com.jxnydx.store.frame.front.student;

import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Student;
import com.jxnydx.util.validate.ValidateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentUserUpdateFrame extends JFrame{
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

    private JTextField jTextFieldSlocate;
    private JTextField jTextFieldSphone;

    private JButton jButton;

    public StudentUserUpdateFrame(String frameName, String id) {
        try {
            this.student = ServiceFrontFactory.getIStudentServiceFrontInstance().getStudentInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(500, 600);
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

        this.introduction = new JLabel("学生信息简介");
        this.jLabelSno = new JLabel("姓名: " + this.student.getSno());
        this.jLabelSname = new JLabel("姓名: " + this.student.getSname());
        this.jLabelSmoney = new JLabel("余额: " + this.student.getSmoney());
        if (this.student.getSstatus() == 0) {
            this.jLabelSstatus = new JLabel("状态: " +  "未激活");
        } else if (this.student.getSstatus() == 1) {
            this.jLabelSstatus = new JLabel("状态: " +  "已激活");
        } else if(this.student.getSstatus() == 2) {
            this.jLabelSstatus = new JLabel("状态: " +  "已冻结");
        }
        this.jLabelSclass = new JLabel("班级: " + this.student.getSclass());
        this.jLabelSlocate = new JLabel("地址:");
        this.jLabelSphone = new JLabel("电话:");

        this.jTextFieldSlocate = new JTextField(this.student.getSlocate(), 20);
        this.jTextFieldSphone = new JTextField(this.student.getSphone(), 20);

        this.jButton = new JButton("Update");

        //Update按钮的监听事件
        this.jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student vo = student;
                if (ValidateUtil.validateEmpty(jTextFieldSlocate.getText()) &&
                        ValidateUtil.validateEmpty(jTextFieldSphone.getText())) {
                    vo.setSlocate(jTextFieldSlocate.getText());
                    vo.setSphone(jTextFieldSphone.getText());
                    try {
                        if (ServiceFrontFactory.getIStudentServiceFrontInstance().update(vo)) {
                            JOptionPane.showMessageDialog(null, "Success for Update Information");
                            setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Failure for Update Information");
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

        this.jPanelTwo.add(this.jLabelSno);

        this.jPanelThree.add(this.jLabelSname);

        this.jPanelFour.add(this.jLabelSmoney);

        this.jPanelFive.add(this.jLabelSstatus);

        this.jPanelSix.add(this.jLabelSclass);

        this.jPanelSeven.add(this.jLabelSlocate);
        this.jPanelSeven.add(this.jTextFieldSlocate);

        this.jPanelEight.add(this.jLabelSphone);
        this.jPanelEight.add(this.jTextFieldSphone);

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
