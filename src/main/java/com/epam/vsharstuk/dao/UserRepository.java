package com.epam.vsharstuk.dao;

import com.epam.vsharstuk.model.User;

public interface UserRepository {

    void createUser(User user);
    User findUserByName(String name);
}
