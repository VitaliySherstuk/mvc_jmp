package com.epam.vsharstuk.service.impl;

import com.epam.vsharstuk.dao.UserRepository;
import com.epam.vsharstuk.model.User;
import com.epam.vsharstuk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(String name, String password, String phone) {
        String encodedPass = passwordEncoder.encode(password);
        User user = new User(name, encodedPass, "USER",  phone);
        return userRepository.createUser(user);
    }

    @Override
    public List<User> findUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }
}
