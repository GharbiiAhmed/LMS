package com.avaxia.lms.services;

//import com.avaxia.lms.config.EmailSender;
//import com.avaxia.lms.config.EmailService;
import com.avaxia.lms.dtos.*;
import com.avaxia.lms.entities.*;
import com.avaxia.lms.mappers.*;
import com.avaxia.lms.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
        import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

        import java.util.*;

@Service
@Slf4j

public class IAuthenticationServiceImpl implements IAuthenticationService {

    private final UserRepository userRepository;
    //private final RoleRepository roleRepository;
    private final IJWTServices jwtServices;
    //private final EmailService emailService;
    private final UserMapperImpl userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    //private final EmailSender emailSender;
    private final VerificationTokenRepository verificationTokenRepo;
    private final TrainerMapperImpl trainerMapperImpl;  // Injected here
    private final TrainerAssistantMapperImpl trainerAssistantMapperImpl;  // Injected here


    private String verificationUrl;

    @Autowired
    public IAuthenticationServiceImpl(
            UserRepository userRepository,
            IJWTServices jwtServices,
            UserMapperImpl userMapper,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            VerificationTokenRepository verificationTokenRepo,
            TrainerMapperImpl trainerMapperImpl,
            TrainerAssistantMapperImpl trainerAssistantMapperImpl
    ) {
        this.userRepository = userRepository;
        this.jwtServices = jwtServices;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.verificationTokenRepo = verificationTokenRepo;
        this.trainerMapperImpl = trainerMapperImpl;
        this.trainerAssistantMapperImpl = trainerAssistantMapperImpl;
    }
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }


    @Override
    public TrainerDTO registerTrainer(TrainerDTO trainerDTO) {
        // Use the correct DTO (trainerDTO) here
        User user = userMapper.fromUserDTO(trainerDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(Role.TRAINER)); // Assign Trainer role

        // Save user to the database
        User savedUser = userRepository.save(user);

        String code = this.generateCode();
        VerificationToken token = new VerificationToken(code, savedUser);
        verificationTokenRepo.save(token);

        // Fix method call from 'fromUser' to 'fromTrainerDTO' as defined in the Mapper
        return trainerMapperImpl.fromTrainer((Trainer) savedUser);
    }

    @Override
    public TrainerAssistantDTO registerTrainerAssistant(TrainerAssistantDTO trainerAssistantDTO) {
        // Use the correct DTO (trainerAssistantDTO) here
        User user = userMapper.fromUserDTO(trainerAssistantDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(Role.TRAINER_ASSISTANT)); // Assign Trainer Assistant role

        // Save user to the database
        User savedUser = userRepository.save(user);

        String code = this.generateCode();
        VerificationToken token = new VerificationToken(code, savedUser);
        verificationTokenRepo.save(token);

        // Fix method call from 'fromUser' to 'fromTrainerAssistantDTO'
        return trainerAssistantMapperImpl.fromTrainerAssistant((TrainerAssistant) savedUser);
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = userMapper.fromUserDTO(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(Role.LEARNER)); // Assign Learner role (default role)

        // Save user to the database
        User savedUser = userRepository.save(user);

        String code = this.generateCode();
        VerificationToken token = new VerificationToken(code, savedUser);
        verificationTokenRepo.save(token);

        return userMapper.fromUser(savedUser);
    }


/*
    // Register a Trainer
    @Override
    public TrainerDTO registerTrainer(UserDTO userDTO) {
        User user = userMapper.fromUserDTO(userDTO); // You can leave this as is
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(Role.TRAINER)); // Assign Trainer role

        // Save user to the database
        User savedUser = userRepository.save(user);

        String code = this.generateCode();
        VerificationToken token = new VerificationToken(code, savedUser);
        verificationTokenRepo.save(token);

        // Fix method call from 'fromUser' to 'fromTrainerDTO' as defined in the Mapper
        return trainerMapperImpl.fromTrainer((Trainer) savedUser);
    }
*/
    /*
    // Register a Trainer Assistant
    @Override
    public TrainerAssistantDTO registerTrainerAssistant(UserDTO userDTO) {
        User user = userMapper.fromUserDTO(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(Role.TRAINER_ASSISTANT)); // Assign Trainer Assistant role

        // Save user to the database
        User savedUser = userRepository.save(user);

        String code = this.generateCode();
        VerificationToken token = new VerificationToken(code, savedUser);
        verificationTokenRepo.save(token);

        // Fix method call from 'fromUser' to 'fromTrainerAssistantDTO'
        return trainerAssistantMapperImpl.fromTrainerAssistant((TrainerAssistant) savedUser);
    }
*/
    public String generateCode() {
        Random random = new Random();
        Integer code = 100000 + random.nextInt(900000);
        return code.toString();
    }

    /*public void sendVerificationEmail(User user, String code) {
        String emailBody = getEmailTemplate();
        emailBody = emailBody.replace("{{name}}", user.getName());
        emailBody = emailBody.replace("{{code}}", code);
        emailBody = emailBody.replace("{{verificationLink}}", verificationUrl + "?code=" + code);

        emailSender.sendEmail(user.getEmail(), "Account Verification", emailBody);
    }*/
/*
    private String getEmailTemplate() {
        try {
            ClassPathResource resource = new ClassPathResource("./emailTemplate.html");
            return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read email template", e);
        }
    }*/

    @Override
    public AuthenticationResponse login(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.isEnabled()) {
            throw new IllegalArgumentException("Please confirm your account to proceed.");
        } else {
            var jwt = jwtServices.generateToken(user);
            var refreshToken = jwtServices.generateRefreshToken(new HashMap<>(), user);

            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setAccessToken(jwt);
            authenticationResponse.setRefreshToken(refreshToken);
            authenticationResponse.setUserDetails(userMapper.fromUser(user));

            return authenticationResponse;
        }
    }

    @Override
    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshToken) {
        String userEmail = jwtServices.extractUsername(refreshToken.getRefreshToken());
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));

        if (jwtServices.isTokenValid(refreshToken.getRefreshToken(), user)) {
            var jwt = jwtServices.generateToken(user);

            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setAccessToken(jwt);
            authenticationResponse.setRefreshToken(refreshToken.getRefreshToken());

            return authenticationResponse;
        }

        return null;
    }


    @Override
    public HashMap<String, String> forgetPassword(String email) {
        HashMap<String, String> message = new HashMap<>();
        User existingUser = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
/*
        UUID token = UUID.randomUUID();
        existingUser.setPasswordResetToken(token.toString());
        userRepository.save(existingUser);

        // Send email
        emailService.sendSimpleEmail(new Mail(existingUser.getEmail(), "Reset Password",
                "Your reset token is: http://localhost:4200/resetpassword/" + token));

        message.put("message", "Password reset email sent.");*/
        return message;
    }

    @Override
    public HashMap<String, String> resetPassword(String passwordResetToken, String newPassword) {
        HashMap<String, String> message = new HashMap<>();
        User existingUser = userRepository.findByResetToken(passwordResetToken).orElseThrow(() -> new RuntimeException("User not found"));
/*
        existingUser.setPassword(passwordEncoder.encode(newPassword));
        existingUser.setPasswordResetToken(null);
        userRepository.save(existingUser);

        message.put("resetPassword", "Success");*/
        return message;
    }

    public User validateToken(String code) {
        VerificationToken token = verificationTokenRepo.findByToken(code);
        if (token == null) {
            throw new InvalidTokenException("Invalid Token");
        }

        User user = token.getUser();
        Calendar calendar = Calendar.getInstance();
        if (token.getExpiryDate().getTime() - calendar.getTime().getTime() <= 0) {
            verificationTokenRepo.delete(token);
            throw new ExpiredTokenException("Expired Token");
        }

        user.setEnabled(true);
        userRepository.save(user);
        return user;
    }

    public boolean validateVerificationCode(String code) {
        VerificationToken token = verificationTokenRepo.findByCode(code);
        if (token != null) {
            User user = token.getUser();
            user.setEnabled(true);
            userRepository.save(user);
            verificationTokenRepo.delete(token);
            return true;
        }

        return false;
    }
}
