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

public class OrderSuccessPage extends JFrame {

    private JButton okButton;

    public OrderSuccessPage() {
        setTitle("FeastFinds - Order Success");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel successLabel = new JLabel("Your order has been successfully placed!");

        okButton = new JButton("OK");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.setBackground(new Color(255, 255, 240)); // Light Cream Color
        panel.add(successLabel);
        panel.add(okButton);

        getContentPane().add(panel);

        setVisible(false);
    }

    public void setOKAction(ActionListener listener) {
        okButton.addActionListener(listener);
    }
}

