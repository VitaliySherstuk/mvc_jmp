package com.epam.vsharstuk.dao;

import com.epam.vsharstuk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO users (name, email, password) VALUES (" + user.getName() + ", " + user.getEmail() +", " + user.getPassword()+ ")";
        jdbcTemplate.execute(sql);
    }

    @Override
    public User findUserByName(String name) {
        String sql = "SELECT id, name, email, password FROM users WHERE name =" + name;
        return jdbcTemplate.queryForObject(sql, User.class);
    }
}
