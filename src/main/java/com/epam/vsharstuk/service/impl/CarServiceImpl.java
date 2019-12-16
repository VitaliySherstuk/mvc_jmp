package com.epam.vsharstuk.service.impl;

import com.epam.vsharstuk.dao.CarRepository;
import com.epam.vsharstuk.model.Car;
import com.epam.vsharstuk.service.CarService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void addCar(Car car) {
        if (car != null) {
            carRepository.addCar(car);
        }
    }

    @Override
    public List<Car> findCarByMake(String make) {
        if (make != null) {
            return carRepository.findCarByMake(make);
        }
        return Collections.emptyList();
    }

    @Override
    public List<Car> findCarById(Integer id) {
        if (id != null) {
            return carRepository.findCarById(id);
        }
        return Collections.emptyList();
    }

    @Override
    public Car update(Integer id, Integer cost) {
        List<Car> cars = carRepository.findCarById(Integer.valueOf(id));
        Car car = cars.get(0);
        car.setCost(Integer.valueOf(cost));
        carRepository.update(car);
        return  car;
    }

    @Override
    public void delete(Integer id) {
        carRepository.delete(id);
    }
}
