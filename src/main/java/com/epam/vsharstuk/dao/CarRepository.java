package com.epam.vsharstuk.dao;

import com.epam.vsharstuk.model.Car;
import com.epam.vsharstuk.service.CarSearchCriteria;

import java.util.List;

public interface CarRepository {

    void addCar(Car car);
    List<Car> findCarByMake(String make);
    List<Car> findCarById(Integer id);
    List<Car> findCarByUserId(Integer userId);
    List<Car> findCarByCriteria(CarSearchCriteria criteria);
    void update(Car car);
    void delete(Integer id);
}
