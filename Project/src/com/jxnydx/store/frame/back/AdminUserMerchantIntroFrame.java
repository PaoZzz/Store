package com.jxnydx.store.frame.back;

import com.jxnydx.store.factory.ServiceBackFactory;
import com.jxnydx.store.vo.Merchant;

import javax.swing.*;
import java.awt.*;

public class AdminUserMerchantIntroFrame extends JFrame{
    private Merchant merchant;

    private JPanel jPanelOne;
    private JPanel jPanelTwo;
    private JPanel jPanelThree;
    private JPanel jPanelFour;
    private JPanel jPanelFive;
    private JPanel jPanelSix;
    private JPanel jPanelSeven;

    private JLabel introduction;
    private JLabel jLabelSno;
    private JLabel jLabelSname;
    private JLabel jLabelSmoney;
    private JLabel jLabelSstatus;
    private JLabel jLabelSlocate;
    private JLabel jLabelSphone;

    public AdminUserMerchantIntroFrame(String frameName, String id) {
        try {
            this.merchant = ServiceBackFactory.getIMerchantServiceBackInstance().getMerchantInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(500, 500);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(7,1));

        this.jPanelOne = new JPanel();
        this.jPanelTwo = new JPanel();
        this.jPanelThree = new JPanel();
        this.jPanelFour = new JPanel();
        this.jPanelFive = new JPanel();
        this.jPanelSix = new JPanel();
        this.jPanelSeven = new JPanel();

        this.introduction = new JLabel("商家信息简介");
        this.jLabelSno = new JLabel("账号: " + this.merchant.getMid());
        this.jLabelSname = new JLabel("店名: " + this.merchant.getMname());
        this.jLabelSmoney = new JLabel("资产: " + this.merchant.getMmoney());
        if (this.merchant.getMstatus() == 0) {
            this.jLabelSstatus = new JLabel("状态: " +  "未激活");
        } else if (this.merchant.getMstatus() == 1) {
            this.jLabelSstatus = new JLabel("状态: " +  "已激活");
        } else if(this.merchant.getMstatus() == 2) {
            this.jLabelSstatus = new JLabel("状态: " +  "已冻结");
        }
        this.jLabelSlocate = new JLabel("地址:" + this.merchant.getMlocate());
        this.jLabelSphone = new JLabel("电话:" + this.merchant.getMphone());

        this.jPanelOne.add(this.introduction);

        this.jPanelTwo.add(this.jLabelSno);

        this.jPanelThree.add(this.jLabelSname);

        this.jPanelFour.add(this.jLabelSmoney);

        this.jPanelFive.add(this.jLabelSstatus);

        this.jPanelSix.add(this.jLabelSlocate);

        this.jPanelSeven.add(this.jLabelSphone);

        this.add(this.jPanelOne);
        this.add(this.jPanelTwo);
        this.add(this.jPanelThree);
        this.add(this.jPanelFour);
        this.add(this.jPanelFive);
        this.add(this.jPanelSix);
        this.add(this.jPanelSeven);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AdminUserMerchantIntroFrame("Intro", "111");
    }
}
