package com.epam.vsharstuk.service.impl;

import com.epam.vsharstuk.dao.CarRepository;
import com.epam.vsharstuk.model.Car;
import com.epam.vsharstuk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void addCar(Car car) {
        carRepository.addCar(car);
    }

    @Override
    public Car findCarByMake(String make) {
        return carRepository.findCarByMake(make);
    }
}
