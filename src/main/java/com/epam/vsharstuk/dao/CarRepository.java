package com.epam.vsharstuk.dao;

import com.epam.vsharstuk.model.Car;

public interface CarRepository {

    void addCar(Car car);
    Car findCarByMake(String make);
}
