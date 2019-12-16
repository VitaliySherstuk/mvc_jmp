package com.epam.vsharstuk.service;

import com.epam.vsharstuk.model.User;

public interface UserService {

    User createUser(User user);
    User findUserById(Long id);
    User findUserByName(String name);
}
