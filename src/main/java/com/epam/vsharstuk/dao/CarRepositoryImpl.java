package com.epam.vsharstuk.dao;

import com.epam.vsharstuk.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepositoryImpl implements  CarRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addCar(Car car) {
        String sql = "INSERT INTO cars (make, model, year, user) VALUES ("
                + car.getMake() + ", " + car.getMake() +", " + car.getYear()+ ", " + car.getUser().getId() + ", " + car.getCost() +")";
        jdbcTemplate.execute(sql);
    }

    @Override
    public Car findCarByMake(String make) {
        String sql = "SELECT id, make, model, year, user_id FROM users WHERE make =" + make;
        return jdbcTemplate.queryForObject(sql, Car.class);
    }
}
