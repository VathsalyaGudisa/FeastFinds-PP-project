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
import java.util.ArrayList;
import java.util.List;

public class FoodBookingPage extends JFrame {

    private static final int MAX_ITEMS_PER_CATEGORY = 5;

    private List<MenuItem> starters;
    private List<MenuItem> riceRaitas;
    private List<MenuItem> desserts;

    private JCheckBox[] startersCheckBoxes;
    private JCheckBox[] riceRaitasCheckBoxes;
    private JCheckBox[] dessertsCheckBoxes;

    private JTextField userNameField;
    private JTextField phoneNumberField;
    private JTextField addressField;

    private JButton proceedButton;

    private double totalAmount = 0.0;

    private FinalPage finalPage;  

    public FoodBookingPage(FinalPage finalPage) {
        this.finalPage = finalPage;
        setTitle("FeastFinds - Food Booking");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("FeastFinds Food Booking");
        JLabel startersLabel = new JLabel("Starters:");
        JLabel riceRaitasLabel = new JLabel("Rice / Pulao / Biryanis / Raitas:");
        JLabel dessertsLabel = new JLabel("Desserts:");

        starters = new ArrayList<>();
        starters.add(new MenuItem("Tandoori Paneer Tikka", 220.0));
        starters.add(new MenuItem("Malai Paneer Tikka", 220.0));
        starters.add(new MenuItem("Soya Tandoori Tikka", 175.0));
        starters.add(new MenuItem("Tandoori Aloo", 179.0));
        starters.add(new MenuItem("Punjabi Soya Chap", 179.0));

        riceRaitas = new ArrayList<>();
        riceRaitas.add(new MenuItem("Steam Rice", 161.0));
        riceRaitas.add(new MenuItem("Soya Dum Biryani", 220.0));
        riceRaitas.add(new MenuItem("Veg. Pulao", 161.0));
        riceRaitas.add(new MenuItem("Mix Veg. Pulao", 161.0));
        riceRaitas.add(new MenuItem("Jeera Pulao", 161.0));

        desserts = new ArrayList<>();
        desserts.add(new MenuItem("Gulab Jamun", 60.0));
        desserts.add(new MenuItem("Halwa (Seasonal)", 60.0));

        startersCheckBoxes = new JCheckBox[MAX_ITEMS_PER_CATEGORY];
        riceRaitasCheckBoxes = new JCheckBox[MAX_ITEMS_PER_CATEGORY];
        dessertsCheckBoxes = new JCheckBox[MAX_ITEMS_PER_CATEGORY];

        for (int i = 0; i < MAX_ITEMS_PER_CATEGORY; i++) {
            startersCheckBoxes[i] = new JCheckBox();
            riceRaitasCheckBoxes[i] = new JCheckBox();
            dessertsCheckBoxes[i] = new JCheckBox();
        }

        userNameField = new JTextField(20);
        phoneNumberField = new JTextField(20);
        addressField = new JTextField(20);

        proceedButton = new JButton("Proceed to Checkout");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(28, 1));
        panel.setBackground(new Color(255, 255, 240)); 

        panel.add(titleLabel);

        panel.add(startersLabel);
        addMenuItems(starters, startersCheckBoxes, panel);

        panel.add(riceRaitasLabel);
        addMenuItems(riceRaitas, riceRaitasCheckBoxes, panel);

        panel.add(dessertsLabel);
        addMenuItems(desserts, dessertsCheckBoxes, panel);

        panel.add(new JLabel("User Name:"));
        panel.add(userNameField);
        panel.add(new JLabel("Phone Number:"));
        panel.add(phoneNumberField);
        panel.add(new JLabel("Address:"));
        panel.add(addressField);

        panel.add(proceedButton);

        getContentPane().add(BorderLayout.CENTER, panel);
        getContentPane().add(BorderLayout.NORTH, titleLabel);

        setVisible(false);
    }

    public void setProceedAction(ActionListener listener) {
        proceedButton.addActionListener(listener);
    }

    public JTextField getUserNameField() {
        return userNameField;
    }

    public JTextField getPhoneNumberField() {
        return phoneNumberField;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    String getSelectedItems() {
        StringBuilder selectedItems = new StringBuilder();
        selectedItems.append("Starters:\n");
        selectedItems.append(getSelectedItemsForCategory(starters, startersCheckBoxes));
        selectedItems.append("\nRice / Pulao / Biryanis / Raitas:\n");
        selectedItems.append(getSelectedItemsForCategory(riceRaitas, riceRaitasCheckBoxes));
        selectedItems.append("\nDesserts:\n");
        selectedItems.append(getSelectedItemsForCategory(desserts, dessertsCheckBoxes));
        return selectedItems.toString();
    }

    private String getSelectedItemsForCategory(List<MenuItem> menuItems, JCheckBox[] checkBoxes) {
        StringBuilder selectedItems = new StringBuilder();
        for (int i = 0; i < MAX_ITEMS_PER_CATEGORY; i++) {
            if (checkBoxes[i].isSelected() && i < menuItems.size()) {
                MenuItem menuItem = menuItems.get(i);
                selectedItems.append(menuItem.getName()).append(" - Rs ").append(menuItem.getPrice()).append("\n");
            }
        }
        return selectedItems.toString();
    }

    private double calculateTotalAmount() {
        double total = 0.0;
        for (int i = 0; i < MAX_ITEMS_PER_CATEGORY; i++) {
            if (startersCheckBoxes[i].isSelected() && i < starters.size()) {
                total += starters.get(i).getPrice();
            }
            if (riceRaitasCheckBoxes[i].isSelected() && i < riceRaitas.size()) {
                total += riceRaitas.get(i).getPrice();
            }
            if (dessertsCheckBoxes[i].isSelected() && i < desserts.size()) {
                total += desserts.get(i).getPrice();
            }
        }
        return total;
    }

    private void addMenuItems(List<MenuItem> menuItems, JCheckBox[] checkBoxes, JPanel panel) {
        for (int i = 0; i < MAX_ITEMS_PER_CATEGORY; i++) {
            if (i < menuItems.size()) {
                MenuItem menuItem = menuItems.get(i);
                checkBoxes[i].setText(menuItem.getName() + " - Rs " + menuItem.getPrice());
                panel.add(checkBoxes[i]);
            }
        }
    }
}

