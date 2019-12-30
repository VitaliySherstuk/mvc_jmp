package com.epam.vsharstuk.service;

import com.epam.vsharstuk.model.User;

import java.util.List;

public interface UserService {

    User createUser(String name, String password, String phone);
    List<User> findUserById(Integer id);
    List<User> findUserByName(String name);
}
