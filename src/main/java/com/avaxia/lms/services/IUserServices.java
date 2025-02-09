package com.avaxia.lms.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserServices {
    UserDetailsService userDetailsService();

    /*User saveUser(User user);

    User findUserByUsername(String username);

    User addRoleToUser(String username, Role role);

    List<User> getUsersByRole(Role role);

    List<User> getAllUsers();

    User updateUser(String username, User user);

    void deleteUser(String username);



    User registerUser(String username, String password, String role);
    */
}
