package com.jxnydx.store.frame.back;

import com.jxnydx.store.vo.Admin;

import javax.swing.*;
import java.awt.*;

public class AdminUserShowFrame extends JFrame {
    private Admin admin;

    private JPanel jPanel;

    private JLabel jLabel;

    public AdminUserShowFrame(String frameName) {
        this.setSize(400, 400);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(1, 1));

        this.jPanel = new JPanel();

        this.jLabel = new JLabel("Admin is sosososo Cool OR Beautiful!");

        this.jPanel.add(this.jLabel);

        this.add(this.jPanel);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}