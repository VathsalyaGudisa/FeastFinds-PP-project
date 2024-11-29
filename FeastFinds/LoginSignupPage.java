/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vaths
 */
package com.mycompany.feastfinds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSignupPage extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;

    private FoodBookingPage foodBookingPage;

    public LoginSignupPage(FoodBookingPage foodBookingPage) {
        this.foodBookingPage = foodBookingPage;
        setTitle("FeastFinds - Login/Signup");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Feast Finds");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        signupButton = new JButton("Signup");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setBackground(new Color(255, 255, 240)); // Light Cream Color
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signupButton);

        getContentPane().add(BorderLayout.CENTER, panel);
        getContentPane().add(BorderLayout.NORTH, titleLabel);

        setVisible(false);
    }

    public void setLoginAction(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public void setSignupAction(ActionListener listener) {
        signupButton.addActionListener(listener);
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }
}
