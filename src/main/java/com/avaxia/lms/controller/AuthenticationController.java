package com.avaxia.lms.controller;

import com.avaxia.lms.dtos.TrainerDTO;
import com.avaxia.lms.dtos.UserDTO;
import com.avaxia.lms.entities.AuthenticationResponse;
import com.avaxia.lms.entities.RefreshTokenRequest;
import com.avaxia.lms.entities.User;
import com.avaxia.lms.services.IAuthenticationService;
import com.avaxia.lms.services.IUserServices;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")

public class AuthenticationController {

    private final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    private final IAuthenticationService authenticationService;
    private final IUserServices userService;
    public AuthenticationController(IAuthenticationService authenticationService, IUserServices userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }
    /*@PostMapping("/registerAdmin")
    public ResponseEntity<?> registerAdmin(@RequestParam("email") String email,
                                           @RequestParam("password") String password) {
        if (authenticationService.emailExists(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setEmail(email);
        adminDTO.setPassword(password);

        try {
            AdminDTO savedAdminDTO = authenticationService.registerAdmin(adminDTO);
            logger.info("Admin registered successfully");
            return ResponseEntity.ok(savedAdminDTO);
        } catch (Exception e) {
            logger.error("Error registering admin: ", e);
            return ResponseEntity.badRequest().body("Error registering admin: " + e.getMessage());
        }
    }*/

    @PostMapping("/registerTrainer")
    public ResponseEntity<?> registerTrainer(@RequestParam("username") String username,
                                             @RequestParam("firstname") String firstname,
                                             @RequestParam("lastname") String lastname,
                                             @RequestParam("email") String email,
                                             @RequestParam("password") String password) {
        if (authenticationService.emailExists(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        TrainerDTO trainerDTO = new TrainerDTO();
        trainerDTO.setUsername(username);
        trainerDTO.setFirstName(firstname);
        trainerDTO.setLastName(lastname);
        trainerDTO.setEmail(email);
        trainerDTO.setPassword(password);

        try {
            TrainerDTO savedTrainerDTO = authenticationService.registerTrainer(trainerDTO);
            logger.info("Trainer registered successfully");
            return ResponseEntity.ok(savedTrainerDTO);
        } catch (Exception e) {
            logger.error("Error registering trainer: ", e);
            return ResponseEntity.badRequest().body("Error registering trainer: " + e.getMessage());
        }
    }

    @PostMapping("/registerLearner")
    public ResponseEntity<?> registerLearner(@RequestParam("username") String username,
                                             @RequestParam("firstname") String firstname,
                                             @RequestParam("lastname") String lastname,
                                             @RequestParam("email") String email,
                                             @RequestParam("password") String password) {
        if (authenticationService.emailExists(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setFirstName(firstname);
        userDTO.setLastName(lastname);
        userDTO.setEmail(email);
        userDTO.setPassword(password);

        try {
            UserDTO savedUserDTO = authenticationService.registerUser(userDTO);
            logger.info("Learner registered successfully");
            return ResponseEntity.ok(savedUserDTO);
        } catch (Exception e) {
            logger.error("Error registering learner: ", e);
            return ResponseEntity.badRequest().body("Error registering learner: " + e.getMessage());
        }
    }


    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody User userDTO) {
        return authenticationService.login(userDTO.getEmail(), userDTO.getPassword());
    }

    @PostMapping("/refreshToken")
    public AuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest refreshToken) {
        return authenticationService.refreshToken(refreshToken);
    }

    @PostMapping("/forgetPassword")
    public HashMap<String, String> forgetPassword(@RequestParam String email) {
        return authenticationService.forgetPassword(email);
    }

    @PostMapping("/resetPassword/{passwordResetToken}")
    public HashMap<String, String> resetPassword(@PathVariable String passwordResetToken,
                                                 @RequestParam String newPassword) {
        return authenticationService.resetPassword(passwordResetToken, newPassword);
    }

    @GetMapping("/verifyEmail/{token}")
    public User verifyEmail(@PathVariable("token") String token) {
        return authenticationService.validateToken(token);
    }
}
