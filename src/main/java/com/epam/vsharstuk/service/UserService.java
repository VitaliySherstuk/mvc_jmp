package com.epam.vsharstuk.service;

import com.epam.vsharstuk.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> findUserById(Long id);
    List<User> findUserByName(String name);
}
