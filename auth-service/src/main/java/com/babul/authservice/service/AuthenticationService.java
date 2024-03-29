package com.babul.authservice.service;

import com.babul.authservice.dto.AuthenticationRequest;
import com.babul.authservice.dto.AuthenticationResponse;
import com.babul.authservice.dto.RegisterRequest;
import com.babul.authservice.entity.Role;
import com.babul.authservice.entity.User;
import com.babul.authservice.exception.DokanException;
import com.babul.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    public AuthenticationResponse register(RegisterRequest request) {
        try {
            User user = new User();
            user.setFirstName(request.getFirstname());
            user.setLastName(request.getLastname());
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setRole(request.getRole());
            user.setCreatedAt(LocalDateTime.now());
            user.setCreatedBy(1L);
            user.setUpdatedOn(LocalDateTime.now());
            user.setUpdatedBy(1L);
            userRepository.save(user);
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }
        catch (Exception ex) {
            throw new DokanException(AuthenticationService.class.getSimpleName(), "register", ex.getMessage());
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
