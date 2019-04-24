package com.jxnydx.store.frame.front;

import com.jxnydx.store.factory.ServiceBackFactory;
import com.jxnydx.store.factory.ServiceFrontFactory;
import com.jxnydx.store.vo.Admin;
import com.jxnydx.store.vo.Merchant;
import com.jxnydx.store.vo.Student;
import com.jxnydx.util.MD5;
import com.jxnydx.util.threadframe.student.ThreadStudentUserMainFrame;
import com.jxnydx.util.threadframe.merchant.ThreadMerchantUserMainFrame;
import com.jxnydx.util.threadframe.admin.ThreadAdminUserMainFrame;
import com.jxnydx.util.validate.ValidateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserLoginFrame extends JFrame{
    private JPanel jPanelOne;
    private JPanel jPanelTwo;
    private JPanel jPanelThree;
    private JPanel jPanelFour;
    private JLabel jLabelUser;
    private JLabel jLabelPassword;
    private JTextField jTextField;
    private JPasswordField jPasswordField;
    private JButton jButton;
    private JRadioButton jRadioButtonStudent;
    private JRadioButton jRadioButtonMerchant;
    private JRadioButton jRadioButtonAdmin;
    private ButtonGroup buttonGroup;

    UserLoginFrame(String frameName) {
        this.setSize(500, 350);
        this.setTitle(frameName);
        this.setLayout(new GridLayout(4,1));

        this.jPanelOne = new JPanel();
        this.jPanelTwo = new JPanel();
        this.jPanelThree = new JPanel();
        this.jPanelFour = new JPanel();
        this.jLabelUser = new JLabel("账号:");
        this.jLabelPassword = new JLabel("密码:");
        this.jTextField = new JTextField(20);
        this.jPasswordField = new JPasswordField(20);
        this.jRadioButtonStudent=new JRadioButton("Student");
        this.jRadioButtonMerchant=new JRadioButton("Merchant");
        this.jRadioButtonAdmin = new JRadioButton("Admin");
        this.jButton = new JButton("Login");
        this.buttonGroup = new ButtonGroup();

        //Login按钮的事件处理
        this.jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jRadioButtonStudent.isSelected()) {
                    if (ValidateUtil.validateEmpty(jTextField.getText()) &&
                            ValidateUtil.validateEmpty(jPasswordField.getText())) {
                        Student vo = new Student();
                        vo.setSno(jTextField.getText());
                        vo.setSpassword(new MD5().getkeyBeanofStr(jPasswordField.getText()));
                        try {
                            if (ServiceFrontFactory.getIStudentServiceFrontInstance().login(vo)) {
                                if (ServiceFrontFactory.getIStudentServiceFrontInstance().getStudentInfo(vo.getSno()).getSstatus() == 1) {
                                    JOptionPane.showMessageDialog(null, "Success for Login");
                                    setVisible(false);
                                    new ThreadStudentUserMainFrame(vo.getSno()).start();
                                } else if (ServiceFrontFactory.getIStudentServiceFrontInstance().getStudentInfo(vo.getSno()).getSstatus() == 2){
                                    JOptionPane.showMessageDialog(null, "The Account Has Been Frozen.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "The Account Not Activated.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Failure for Login");
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error for Inputing Empty");
                    }
                } else if(jRadioButtonMerchant.isSelected()) {
                    if (ValidateUtil.validateEmpty(jTextField.getText()) &&
                            ValidateUtil.validateEmpty(jPasswordField.getText())) {
                        Merchant vo = new Merchant();
                        vo.setMid(jTextField.getText());
                        vo.setMpassword(new MD5().getkeyBeanofStr(jPasswordField.getText()));
                        try {
                            if (ServiceFrontFactory.getIMerchantServiceFrontInstance().login(vo)) {
                                JOptionPane.showMessageDialog(null, "Success for Login");
                                setVisible(false);
                                new ThreadMerchantUserMainFrame(vo.getMid()).start();
                            } else {
                                JOptionPane.showMessageDialog(null, "Failure for Login");
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error for Inputing Empty");
                    }
                } else if(jRadioButtonAdmin.isSelected()){
                    if (ValidateUtil.validateEmpty(jTextField.getText()) &&
                            ValidateUtil.validateEmpty(jPasswordField.getText())) {
                        Admin vo = new Admin();
                        vo.setAid(jTextField.getText());
                        vo.setPassword(new MD5().getkeyBeanofStr(jPasswordField.getText()));
                        try {
                            if (ServiceBackFactory.getIAdminServiceBackInstance().login(vo)) {
                                JOptionPane.showMessageDialog(null, "Success for Login");
                                setVisible(false);
                                new ThreadAdminUserMainFrame(vo.getAid()).start();
                            } else {
                                JOptionPane.showMessageDialog(null, "Failure for Login");
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error for Inputing Empty");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select a Kind");
                }
            }
        });

        this.jPanelOne.add(this.jLabelUser);
        this.jPanelOne.add(this.jTextField);

        this.jPanelTwo.add(this.jLabelPassword);
        this.jPanelTwo.add(this.jPasswordField);

        this.buttonGroup.add(this.jRadioButtonStudent);
        this.buttonGroup.add(this.jRadioButtonMerchant);
        this.buttonGroup.add(this.jRadioButtonAdmin);
        this.jPanelThree.add(this.jRadioButtonStudent);
        this.jPanelThree.add(this.jRadioButtonMerchant);
        this.jPanelThree.add(this.jRadioButtonAdmin);


        this.jPanelFour.add(this.jButton);

        this.add(this.jPanelOne);
        this.add(this.jPanelTwo);
        this.add(this.jPanelThree);
        this.add(this.jPanelFour);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new UserLoginFrame("Login");
    }
}
