package com.avaxia.lms.controller;

import com.avaxia.lms.dtos.UserRegisterDTO;
import com.avaxia.lms.entities.Role;
import com.avaxia.lms.entities.User;
import com.avaxia.lms.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    /*
    @Autowired

    private IUserServices IUserServices;

    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return IUserServices.saveUser(user);
    }

    // Get a user by their username
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return IUserServices.findUserByUsername(username);
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return IUserServices.getAllUsers();
    }

    // Update a user's information by their username
    @PutMapping("/{username}")
    public User updateUser(@PathVariable String username, @RequestBody User user) {
        return IUserServices.updateUser(username, user);
    }

    // Delete a user by their username
    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        IUserServices.deleteUser(username);
    }

    // Add a role to the user
    @PutMapping("/{username}/roles/{role}")
    public User addRoleToUser(@PathVariable String username, @PathVariable Role role) {
        return IUserServices.addRoleToUser(username, role);
    }

    // Get all users with a specific role
    @GetMapping("/roles/{role}")
    public List<User> getUsersByRole(@PathVariable Role role) {
        return IUserServices.getUsersByRole(role);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        try {
            // Register user with details from the DTO
            User user = IUserServices.registerUser(
                    userRegisterDTO.getUsername(),
                    userRegisterDTO.getPassword(),
                    userRegisterDTO.getRole()
            );
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }*/
}
