package com.avaxia.lms.controller;

import com.avaxia.lms.services.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/verification")
public class VerificationController {

    @Autowired
    private IAuthenticationService userService;

    @GetMapping("/validate")
    public ResponseEntity<String> validateCode(@RequestParam String code) {
        boolean isValid = userService.validateVerificationCode(code);
        if (isValid) {
            return ResponseEntity.ok("your account is valid !.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid verification code !.");
        }
    }
}