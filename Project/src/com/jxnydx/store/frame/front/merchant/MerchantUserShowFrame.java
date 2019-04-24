package com.jxnydx.store.frame.front.merchant;

import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Merchant;

import javax.swing.*;
import java.awt.*;

public class MerchantUserShowFrame extends JFrame{
    private Merchant merchant;

    private JPanel jPanelOne;
    private JPanel jPanelTwo;
    private JPanel jPanelThree;
    private JPanel jPanelFour;
    private JPanel jPanelFive;
    private JPanel jPanelSix;
    private JPanel jPanelSeven;

    private JLabel introduction;
    private JLabel jLabelMid;
    private JLabel jLabelMname;
    private JLabel jLabelMmoney;
    private JLabel jLabelMstatus;
    private JLabel jLabelMlocate;
    private JLabel jLabelMphone;

    public MerchantUserShowFrame(String frameName, String id) {
        try {
            this.merchant = ServiceFrontFactory.getIMerchantServiceFrontInstance().getMerchantInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(500, 600);
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
        this.jLabelMid = new JLabel("账号: " + this.merchant.getMid());
        this.jLabelMname = new JLabel("店名: " + this.merchant.getMname());
        this.jLabelMmoney = new JLabel("余额: " + this.merchant.getMmoney());
        if (this.merchant.getMstatus() == 0) {
            this.jLabelMstatus = new JLabel("状态: " +  "未激活");
        } else if (this.merchant.getMstatus() == 1) {
            this.jLabelMstatus = new JLabel("状态: " +  "已激活");
        } else if(this.merchant.getMstatus() == 2) {
            this.jLabelMstatus = new JLabel("状态: " +  "已冻结");
        }
        this.jLabelMlocate = new JLabel("地址:" + this.merchant.getMlocate());
        this.jLabelMphone = new JLabel("电话:" + this.merchant.getMphone());

        this.jPanelOne.add(this.introduction);

        this.jPanelTwo.add(this.jLabelMid);

        this.jPanelThree.add(this.jLabelMname);

        this.jPanelFour.add(this.jLabelMmoney);

        this.jPanelFive.add(this.jLabelMstatus);

        this.jPanelSix.add(this.jLabelMlocate);

        this.jPanelSeven.add(this.jLabelMphone);

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
}
