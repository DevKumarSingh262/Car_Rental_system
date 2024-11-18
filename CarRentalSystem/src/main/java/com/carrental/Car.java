/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carrental;

/**
 *
 * @author dks31
 */
public class Car {
     private int id;
    private String model;
    private String brand;
    private double rentPrice;
    private boolean isRented;

    public Car(int id, String model, String brand, double rentPrice) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.rentPrice = rentPrice;
        this.isRented = false;
    }

    public int getId() { return id; }
    public String getModel() { return model; }
    public String getBrand() { return brand; }
    public double getRentPrice() { return rentPrice; }
    public boolean isRented() { return isRented; }
    public void setRented(boolean rented) { isRented = rented; }
}
