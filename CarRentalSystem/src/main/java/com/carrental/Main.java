/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carrental;

/**
 *
 * @author dks31
 */

public class Main {
    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();

        // Launch Admin Panel
        AdminPanel adminPanel = new AdminPanel(system);
        adminPanel.setVisible(true);

        // Launch Customer Panel
        CustomerPanel customerPanel = new CustomerPanel(system);
        customerPanel.setVisible(true);
    }
}
