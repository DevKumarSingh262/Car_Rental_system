/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carrental;

/**
 *
 * @author dks31
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerPanel extends JFrame {
    private CarRentalSystem system;

    public CustomerPanel(CarRentalSystem system) {
        this.system = system;

        // JFrame setup
        setTitle("Customer Panel - Rent Cars");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Table to Display Cars
        String[] columnNames = {"ID", "Model", "Brand", "Price", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable carTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(carTable);
        scrollPane.setBounds(20, 20, 550, 200);
        add(scrollPane);

        // Rent Car Label and TextField
        JLabel rentLabel = new JLabel("Enter Car ID to Rent:");
        rentLabel.setBounds(20, 240, 150, 30);
        add(rentLabel);

        JTextField rentField = new JTextField();
        rentField.setBounds(180, 240, 100, 30);
        add(rentField);

        // Rent Button
        JButton rentButton = new JButton("Rent");
        rentButton.setBounds(300, 240, 80, 30);
        add(rentButton);

        // View Cars Button
        JButton viewCarsButton = new JButton("View Available Cars");
        viewCarsButton.setBounds(20, 300, 200, 30);
        add(viewCarsButton);

        // Action Listener for View Cars Button
        viewCarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear existing rows
                tableModel.setRowCount(0);

                // Get available cars from the system
                ArrayList<Car> availableCars = system.getAvailableCars();
                if (availableCars.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No cars are currently available for rent.");
                } else {
                    // Populate the table
                    for (Car car : availableCars) {
                        tableModel.addRow(new Object[]{
                                car.getId(),
                                car.getModel(),
                                car.getBrand(),
                                car.getRentPrice(),
                                car.isRented() ? "Rented" : "Available"
                        });
                    }
                }
            }
        });

        // Action Listener for Rent Button
        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int carId = Integer.parseInt(rentField.getText());
                    if (system.rentCar(carId)) {
                        JOptionPane.showMessageDialog(null, "Car Rented Successfully!");
                        rentField.setText("");
                        // Refresh the table
                        viewCarsButton.doClick();
                    } else {
                        JOptionPane.showMessageDialog(null, "Car Not Available!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric Car ID.");
                }
            }
        });
    }
}

