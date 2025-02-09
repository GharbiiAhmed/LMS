package com.avaxia.lms.services;

import com.avaxia.lms.dtos.TrainerDTO;
import com.avaxia.lms.dtos.TrainerAssistantDTO;
import com.avaxia.lms.dtos.UserDTO;
import com.avaxia.lms.entities.AuthenticationResponse;
import com.avaxia.lms.entities.RefreshTokenRequest;
import com.avaxia.lms.entities.User;

import java.util.HashMap;

public interface IAuthenticationService {

    // Register a Trainer
    TrainerDTO registerTrainer(TrainerDTO trainerDTO);

    // Register a Trainer Assistant
    TrainerAssistantDTO registerTrainerAssistant(TrainerAssistantDTO trainerAssistantDTO);

    // Register a User (General user registration, if needed)
    UserDTO registerUser(UserDTO userDTO);

    AuthenticationResponse login(String email, String password);

    AuthenticationResponse refreshToken(RefreshTokenRequest refreshToken);

    HashMap<String, String> forgetPassword(String email);

    HashMap<String, String> resetPassword(String passwordResetToken, String newPassword);

    User validateToken(String code);

    boolean validateVerificationCode(String code);

    boolean emailExists(String email);
}
