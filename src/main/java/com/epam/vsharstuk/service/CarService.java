package com.epam.vsharstuk.service;

import com.epam.vsharstuk.model.Car;

public interface CarService {

    void addCar(Car car);
    Car findCarByMake(String make);
}
