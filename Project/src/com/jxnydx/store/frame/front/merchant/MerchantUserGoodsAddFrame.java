package com.jxnydx.store.frame.front.merchant;

import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Goods;
import com.jxnydx.store.vo.Merchant;
import com.jxnydx.util.validate.ValidateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MerchantUserGoodsAddFrame extends JFrame{
    private Merchant merchant;

    private JPanel jPanelOne;
    private JPanel jPanelTwo;
    private JPanel jPanelThree;
    private JPanel jPanelFour;
    private JPanel jPanelFive;
    private JPanel jPanelSix;

    private JLabel jLabel;
    private JLabel jLabelMid;
    private JLabel jLabelNanme;
    private JLabel jLabelPrice;
    private JLabel jLabelStatus;

    private JTextField jTextFieldName;
    private JTextField jTextFieldPrice;
    private JTextField jTextFieldStatus;

    private JButton jButton;

    public MerchantUserGoodsAddFrame(String frameName, final String id) {
        try {
            this.merchant = ServiceFrontFactory.getIMerchantServiceFrontInstance().getMerchantInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(500, 350);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(6,1));

        this.jPanelOne = new JPanel();
        this.jPanelTwo = new JPanel();
        this.jPanelThree = new JPanel();
        this.jPanelFour = new JPanel();
        this.jPanelFive = new JPanel();
        this.jPanelSix = new JPanel();

        this.jLabel = new JLabel("Inserting Good");
        this.jLabelMid = new JLabel("User: " + id);
        this.jLabelNanme = new JLabel("Name: ");
        this.jLabelPrice = new JLabel("Price: ");
        this.jLabelStatus = new JLabel("Status: ");

        this.jTextFieldName = new JTextField(10);
        this.jTextFieldPrice = new JTextField(10);
        this.jTextFieldStatus = new JTextField(10);

        this.jButton = new JButton("Add");

        //Add按钮的监听事件
        this.jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Goods vo = new Goods();
                vo.setMid(id);
                if (ValidateUtil.validateEmpty(jTextFieldName.getText()) &&
                        ValidateUtil.validateDouble(jTextFieldPrice.getText())) {
                    vo.setGprice(Double.valueOf(jTextFieldPrice.getText()));
                    vo.setGname(jTextFieldName.getText());
                    vo.setGstatus(1);
                    try {
                        if (ServiceFrontFactory.getIGoodsServiceFrontInstance().insert(vo)) {
                            JOptionPane.showMessageDialog(null, "Success for Inserting");
                            setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Failure for Inserting");
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error for Inputing");
                }
            }
        });

        this.jPanelOne.add(this.jLabel);

        this.jPanelTwo.add(this.jLabelMid);

        this.jPanelThree.add(this.jLabelNanme);
        this.jPanelThree.add(this.jTextFieldName);

        this.jPanelFour.add(this.jLabelPrice);
        this.jPanelFour.add(this.jTextFieldPrice);

        this.jPanelFive.add(this.jLabelStatus);
        this.jPanelFive.add(this.jTextFieldStatus);

        this.jPanelSix.add(this.jButton);

        this.add(this.jPanelOne);
        this.add(this.jPanelTwo);
        this.add(this.jPanelThree);
        this.add(this.jPanelFour);
        this.add(this.jPanelFive);
        this.add(this.jPanelSix);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
