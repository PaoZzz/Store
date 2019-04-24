package com.jxnydx.store.frame.back;

import com.jxnydx.store.factory.ServiceBackFactory;
import com.jxnydx.store.vo.Admin;
import com.jxnydx.util.MD5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUserChangePasswordFrame extends JFrame{
    private Admin admin;

    private JPanel jPanelOne;
    private JPanel jPanelTwo;
    private JPanel jPanelThree;
    private JPanel jPanelFour;

    private JLabel jLabelOld;
    private JLabel jLabelNew;
    private JLabel jLabelAgain;

    private JTextField jTextFieldOldPassword;
    private JTextField jTextFieldNewPassword;
    private JTextField jTextFieldPasswordAgain;

    private JButton jButton;

    public AdminUserChangePasswordFrame(String frameName, final String id) {
        try {
            this.admin = ServiceBackFactory.getIAdminServiceBackInstance().getAdminInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setSize(500, 300);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(4,1));

        this.jPanelOne = new JPanel();
        this.jPanelTwo = new JPanel();
        this.jPanelThree = new JPanel();
        this.jPanelFour = new JPanel();

        this.jLabelOld = new JLabel("旧 密 码:");
        this.jLabelNew = new JLabel("新 密 码:");
        this.jLabelAgain = new JLabel("确认密码:");

        this.jTextFieldOldPassword = new JPasswordField(20);
        this.jTextFieldNewPassword = new JPasswordField(20);
        this.jTextFieldPasswordAgain = new JPasswordField(20);

        this.jButton = new JButton("Change");

        //Change按钮的监听事件
        this.jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPassword = new MD5().getkeyBeanofStr(jTextFieldOldPassword.getText());
                if (oldPassword.equals(admin.getPassword())) {
                    String newPassword = jTextFieldNewPassword.getText();
                    String againPassword = jTextFieldPasswordAgain.getText();
                    if (newPassword.equals(againPassword) && newPassword.length() >= 3) {
                        Admin vo = new Admin();
                        vo.setAid(id);
                        vo.setPassword(new MD5().getkeyBeanofStr(newPassword));
                        try {
                            if (ServiceBackFactory.getIAdminServiceBackInstance().update(vo)) {
                                JOptionPane.showMessageDialog(null, "Success for Change Password");
                                setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Failure for Change Password");
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error for New or Again Password");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error for Old Password");
                }
            }
        });

        this.jPanelOne.add(this.jLabelOld);
        this.jPanelOne.add(this.jTextFieldOldPassword);

        this.jPanelTwo.add(this.jLabelNew);
        this.jPanelTwo.add(this.jTextFieldNewPassword);

        this.jPanelThree.add(this.jLabelAgain);
        this.jPanelThree.add(this.jTextFieldPasswordAgain);

        this.jPanelFour.add(this.jButton);

        this.add(this.jPanelOne);
        this.add(this.jPanelTwo);
        this.add(this.jPanelThree);
        this.add(this.jPanelFour);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
