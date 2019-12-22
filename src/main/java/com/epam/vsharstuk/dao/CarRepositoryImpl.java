package com.epam.vsharstuk.dao;

import com.epam.vsharstuk.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepositoryImpl implements  CarRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final RowMapper<Car> carRowMapper = (resultSet, rowNum) ->{
        Car car = new Car();
        car.setId(resultSet.getInt("id"));
        car.setMake(resultSet.getString("make"));
        car.setModel(resultSet.getString("model"));
        car.setYear(resultSet.getInt("year"));
        car.setCost(resultSet.getInt("cost"));
        car.setUserId(resultSet.getInt("user_id"));
        return car;
    };


    @Override
    public void addCar(Car car) {
        String sql = "INSERT INTO cars (make, model, year, cost, user_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getMake(), car.getModel(), car.getYear(), car.getCost(), car.getUserId());
    }

    @Override
    public List<Car> findCarByMake(String make) {
        String sql = "SELECT id, make, model, year, user_id, cost FROM cars WHERE make = ?";
        return jdbcTemplate.query(sql, new Object[]{make}, carRowMapper);
    }

    @Override
    public List<Car> findCarById(Integer id) {
        String sql = "SELECT id, make, model, year, user_id, cost FROM cars WHERE id = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, carRowMapper);
    }

    @Override
    public List<Car> findCarByUserId(Integer userId) {
        String sql = "SELECT id, make, model, year, user_id, cost FROM cars WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, carRowMapper);
    }

    @Override
    public void update(Car car) {
        String sql = "UPDATE cars SET cost = " + car.getCost() + "WHERE id = " + car.getId();
        jdbcTemplate.update(sql);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE cars WHERE id = " + id;
        jdbcTemplate.update(sql);
    }
}
