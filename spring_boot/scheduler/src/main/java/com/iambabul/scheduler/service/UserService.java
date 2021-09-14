package com.iambabul.scheduler.service;

import com.iambabul.scheduler.entity.User;
import com.iambabul.scheduler.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Scheduled(fixedRate = 5000)
    public void addUser() {
        User user = new User();
        user.setName("user " + new Random().nextInt(374483));
        userRepository.save(user);
        log.info("add user service call in " + new Date().toString());
    }

    @Scheduled(fixedRate = 15000)
    public void getUsers() {
        List<User> users = userRepository.findAll();
        log.info("get users service call in " + new Date().toString());
        log.info("users = " + users);
    }
}
