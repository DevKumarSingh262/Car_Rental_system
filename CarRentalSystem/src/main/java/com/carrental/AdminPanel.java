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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminPanel extends JFrame {
    private CarRentalSystem system;

    public AdminPanel(CarRentalSystem system) {
        this.system = system;

        // JFrame setup
        setTitle("Admin Panel - Manage Cars");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Labels and TextFields for Adding Car
        JLabel addCarLabel = new JLabel("Add Car");
        addCarLabel.setBounds(200, 10, 100, 30);
        add(addCarLabel);

        JLabel idLabel = new JLabel("Car ID:");
        idLabel.setBounds(50, 50, 100, 30);
        add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(150, 50, 200, 30);
        add(idField);

        JLabel modelLabel = new JLabel("Model:");
        modelLabel.setBounds(50, 90, 100, 30);
        add(modelLabel);

        JTextField modelField = new JTextField();
        modelField.setBounds(150, 90, 200, 30);
        add(modelField);

        JLabel brandLabel = new JLabel("Brand:");
        brandLabel.setBounds(50, 130, 100, 30);
        add(brandLabel);

        JTextField brandField = new JTextField();
        brandField.setBounds(150, 130, 200, 30);
        add(brandField);

        JLabel priceLabel = new JLabel("Rent Price:");
        priceLabel.setBounds(50, 170, 100, 30);
        add(priceLabel);

        JTextField priceField = new JTextField();
        priceField.setBounds(150, 170, 200, 30);
        add(priceField);

        // Add Car Button
        JButton addButton = new JButton("Add Car");
        addButton.setBounds(200, 220, 100, 30);
        add(addButton);

        // Add ActionListener to Add Car Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String model = modelField.getText();
                    String brand = brandField.getText();
                    double price = Double.parseDouble(priceField.getText());

                    // Add car to system
                    system.addCar(new Car(id, model, brand, price));
                    JOptionPane.showMessageDialog(null, "Car Added Successfully!");

                    // Clear input fields
                    idField.setText("");
                    modelField.setText("");
                    brandField.setText("");
                    priceField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please check the values.");
                }
            }
        });

        // **New Components**: View Rented Cars
        JButton viewRentedButton = new JButton("View Rented Cars");
        viewRentedButton.setBounds(150, 270, 200, 30);
        add(viewRentedButton);

        JTextArea rentedCarsArea = new JTextArea();
        rentedCarsArea.setBounds(50, 320, 400, 120);
        rentedCarsArea.setEditable(false);
        add(rentedCarsArea);

        // Add ActionListener to View Rented Cars Button
        viewRentedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Car> rentedCars = system.getRentedCars();
                rentedCarsArea.setText(""); // Clear previous text
                if (rentedCars.isEmpty()) {
                    rentedCarsArea.setText("No cars are currently rented.");
                } else {
                    rentedCarsArea.append("Rented Cars:\n");
                    rentedCarsArea.append("----------------------------\n");
                    for (Car car : rentedCars) {
                        rentedCarsArea.append("ID: " + car.getId() + "\n");
                        rentedCarsArea.append("Model: " + car.getModel() + "\n");
                        rentedCarsArea.append("Brand: " + car.getBrand() + "\n");
                        rentedCarsArea.append("Rent Price: $" + car.getRentPrice() + "\n");
                        rentedCarsArea.append("----------------------------\n");
                    }
                }
            }
        });

        // Optional: Add ScrollPane if using JTextArea
        JScrollPane scrollPane = new JScrollPane(rentedCarsArea);
        scrollPane.setBounds(50, 320, 400, 120);
        add(scrollPane);
    }
}

