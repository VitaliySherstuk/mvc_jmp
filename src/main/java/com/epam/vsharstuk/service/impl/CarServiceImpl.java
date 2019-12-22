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
    public void addCar(String make, String model, String year, String cost, Integer userId) {
        Car car = new Car();
        car.setMake(make);
        car.setModel(model);
        car.setYear(Integer.valueOf(year));
        car.setCost(Integer.valueOf(cost));
        car.setUserId(userId);
        carRepository.addCar(car);
    }

    @Override
    public List<Car> findCarByMake(String make) {
        if (make == null) {
            return Collections.emptyList();
        }
        return carRepository.findCarByMake(make);
    }

    @Override
    public List<Car> findCarById(Integer id) {
        if (id == null) {
            return Collections.emptyList();
        }
        return carRepository.findCarById(id);
    }

    @Override
    public List<Car> findCarByUserId(Integer userId) {
        if (userId == null) {
            return Collections.emptyList();
        }
        return carRepository.findCarByUserId(userId);
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
