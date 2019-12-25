package com.epam.vsharstuk.dao;

import com.epam.vsharstuk.model.Car;
import com.epam.vsharstuk.service.CarSearchCriteria;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
    public List<Car> findCarByCriteria(CarSearchCriteria criteria) {
        StringBuilder builder = new StringBuilder();
        String sql = "SELECT id, make, model, year, user_id, cost FROM cars ";
        List<Object> parameters = new ArrayList<>();
        builder.append(sql);

        if (StringUtils.isNoneBlank(criteria.getMake())) {
            builder = addParameter(parameters, builder, criteria.getMake());
            parameters.add(criteria.getMake());
        }

        if (StringUtils.isNoneBlank(criteria.getModel())) {
            builder =  addParameter(parameters, builder, criteria.getModel());
            parameters.add(criteria.getModel());
        }

        if (criteria.getYear() != null) {
            builder = addParameter(parameters, builder, String.valueOf(criteria.getYear()));
            parameters.add(criteria.getYear());
        }

        if (criteria.getCost() != null) {
            builder = addParameter(parameters, builder, String.valueOf(criteria.getCost()));
            parameters.add(criteria.getCost());
        }

        if (CollectionUtils.isNotEmpty(parameters)) {
            Object[] objects = parameters.toArray();
            builder = builder.insert(0, "WHERE ");
            return jdbcTemplate.query(builder.toString(), objects, carRowMapper);
        }

        return jdbcTemplate.query(sql, carRowMapper);
    }

    private StringBuilder addParameter(List<Object> parameters, StringBuilder builder, String parameter) {
        builder = CollectionUtils.isEmpty(parameters) ? builder.append(" and " + parameter + "=?") : builder.append(parameter + "=?");
        return builder;
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
