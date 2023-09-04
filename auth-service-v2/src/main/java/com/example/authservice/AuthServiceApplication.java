package com.example.authservice;

import com.example.authservice.config.RsaKeyProperties;
import com.example.authservice.model.Role;
import com.example.authservice.model.User;
import com.example.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
@EnableConfigurationProperties(RsaKeyProperties.class)
public class AuthServiceApplication implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        User user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("user"))
                .role(Role.USER)
                .build();
        //userRepository.save(user);

        User admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .role(Role.ADMIN)
                .build();
        //userRepository.save(admin);
    }
}
