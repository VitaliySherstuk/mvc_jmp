package com.epam.vsharstuk.dao;

import com.epam.vsharstuk.model.User;

public interface UserRepository {

    User createUser(User user);
    User findUserByName(String name);
    User findUserById(Long id);
}
