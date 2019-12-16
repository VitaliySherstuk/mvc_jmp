package com.epam.vsharstuk.service;

import com.epam.vsharstuk.model.Car;

import java.util.List;

public interface CarService {

    void addCar(Car car);
    List<Car> findCarByMake(String make);
    List<Car> findCarById(Integer id);
    Car update(Integer id, Integer cost);
    void delete(Integer id);
}
