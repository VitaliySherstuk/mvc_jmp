package com.epam.vsharstuk.service;

import com.epam.vsharstuk.model.User;

import java.util.List;

public interface UserService {

    User createUser(String name, String password);
    List<User> findUserById(Long id);
    List<User> findUserByName(String name);
}
