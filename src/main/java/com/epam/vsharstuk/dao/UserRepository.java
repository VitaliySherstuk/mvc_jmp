package com.epam.vsharstuk.dao;

import com.epam.vsharstuk.model.User;

import java.util.List;

public interface UserRepository {

    User createUser(User user);
    List<User> findUserByName(String name);
    List<User> findUserById(Integer id);
}
