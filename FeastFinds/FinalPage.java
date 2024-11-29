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

public class FinalPage extends JFrame {

    private JButton confirmButton;
    private JTextArea detailsArea;

    private OrderSuccessPage orderSuccessPage;

    public FinalPage(OrderSuccessPage orderSuccessPage) {
        this.orderSuccessPage = orderSuccessPage;
        setTitle("FeastFinds - Final Order");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("FeastFinds Final Order");
        JLabel detailsLabel = new JLabel("Order Details:");
        detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(detailsArea);
        confirmButton = new JButton("Confirm Order");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(255, 255, 240)); // Light Cream Color
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(detailsLabel, BorderLayout.WEST);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(confirmButton, BorderLayout.SOUTH);

        getContentPane().add(panel);

        setVisible(false);
    }

    public void setConfirmAction(ActionListener listener) {
        confirmButton.addActionListener(listener);
    }

    public void setOrderDetails(String userName, String phoneNumber, String address, String orderDetails, double totalAmount) {
        detailsArea.setText("Name: " + userName + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Address: " + address + "\n\n" +
                "Order Details:\n" + orderDetails + "\n\n" +
                "Total Amount: Rs " + totalAmount);
    }
}

