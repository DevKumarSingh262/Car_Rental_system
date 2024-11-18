/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.carrental;
import java.util.ArrayList;
/**
 *
 * @author dks31
 */

public class CarRentalSystem {
    private ArrayList<Car> cars = new ArrayList<>();

    // Existing methods...

    // Method to add a car
    public void addCar(Car car) {
        cars.add(car);
    }

    // Method to get available cars
    public ArrayList<Car> getAvailableCars() {
        ArrayList<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (!car.isRented()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    // Method to rent a car
    public boolean rentCar(int id) {
        for (Car car : cars) {
            if (car.getId() == id && !car.isRented()) {
                car.setRented(true);
                return true;
            }
        }
        return false;
    }

    // **New Method**: Get Rented Cars
    public ArrayList<Car> getRentedCars() {
        ArrayList<Car> rentedCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isRented()) {
                rentedCars.add(car);
            }
        }
        return rentedCars;
    }
}

