package com.epam.vsharstuk.service.impl;

import com.epam.vsharstuk.model.Role;
import com.epam.vsharstuk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {

            com.epam.vsharstuk.model.User userByName = userService.findUserByName(username).get(0);
            System.out.println(userByName.getId());
            System.out.println(userByName.getName());
            System.out.println(userByName.getPassword());
            System.out.println(userByName.getRoles());
            System.out.println(userByName.getRolesList());
            List<GrantedAuthority> authorities = new ArrayList<>();

            for (Role role : userByName.getRolesList()) {
                authorities.add(new SimpleGrantedAuthority(role.name()));
            }

            UserDetails userDetails = new User(
                    userByName.getName(),
                    userByName.getPassword(),
                    authorities
            );

            return userDetails;
        } catch (Throwable e) {
            throw new UsernameNotFoundException(e.getMessage(), e);
        }
    }
}
