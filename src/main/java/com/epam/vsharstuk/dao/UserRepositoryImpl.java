package com.epam.vsharstuk.dao;

import com.epam.vsharstuk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User createUser(User user) {
        String sql = "INSERT INTO users (name, password, role) VALUES (" + user.getName() +", " + user.getPassword()+ ", " + user.getRoles() +")";
        jdbcTemplate.execute(sql);
        return user;
    }

    @Override
    public User findUserByName(String name) {
        String sql = "SELECT id, name, email, password FROM users WHERE name =" + name;
        return jdbcTemplate.queryForObject(sql, User.class);
    }
}
