package com.jxnydx.store.frame.front.student;

import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Student;

import javax.swing.*;
import java.awt.*;

public class StudentUserShowFrame extends JFrame{
    private Student student;

    private JPanel jPanelOne;
    private JPanel jPanelTwo;
    private JPanel jPanelThree;
    private JPanel jPanelFour;
    private JPanel jPanelFive;
    private JPanel jPanelSix;
    private JPanel jPanelSeven;
    private JPanel jPanelEight;

    private JLabel introduction;
    private JLabel jLabelSno;
    private JLabel jLabelSname;
    private JLabel jLabelSmoney;
    private JLabel jLabelSstatus;
    private JLabel jLabelSclass;
    private JLabel jLabelSlocate;
    private JLabel jLabelSphone;

    public StudentUserShowFrame(String frameName, String id) {
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

        this.introduction = new JLabel("学生信息简介");
        this.jLabelSno = new JLabel("账号: " + this.student.getSno());
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
        this.jLabelSlocate = new JLabel("地址:" + this.student.getSlocate());
        this.jLabelSphone = new JLabel("电话:" + this.student.getSphone());

        this.jPanelOne.add(this.introduction);

        this.jPanelTwo.add(this.jLabelSno);

        this.jPanelThree.add(this.jLabelSname);

        this.jPanelFour.add(this.jLabelSmoney);

        this.jPanelFive.add(this.jLabelSstatus);

        this.jPanelSix.add(this.jLabelSclass);

        this.jPanelSeven.add(this.jLabelSlocate);

        this.jPanelEight.add(this.jLabelSphone);

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
