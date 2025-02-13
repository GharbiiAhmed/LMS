package com.avaxia.lms.controllers;


import com.avaxia.lms.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
        import org.springframework.web.bind.annotation.*;
import com.avaxia.lms.entities.User;
import com.avaxia.lms.entities.enumerations.Role;
import com.avaxia.lms.services.auth.JwtUtils;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /*@PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        userRepository.save(user);
        return "User registered successfully";
    }

     */
    @PostMapping("/register/{userType}")
    public String register(@PathVariable String userType, @RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        // Assign role based on userType
        switch (userType.toLowerCase()) {
            case "admin":
                user.setRole(Role.ADMIN);
                break;
            case "trainer":
                user.setRole(Role.TRAINER);
                break;
            case "trainer_assistant":
                user.setRole(Role.TRAINER_ASSISTANT);
                break;
            case "learner":
                user.setRole(Role.LEARNER);
                break;
            default:
                throw new IllegalArgumentException("Invalid user type");
        }

        userRepository.save(user);
        return "User registered successfully as " + user.getRole();
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsername(username);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return JwtUtils.generateToken(user.getUsername());
    }
}

