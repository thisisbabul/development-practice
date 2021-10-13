package com.iambabul.springsecurityjwt;

import com.iambabul.springsecurityjwt.entity.Role;
import com.iambabul.springsecurityjwt.entity.User;
import com.iambabul.springsecurityjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
          userService.saveRole(new Role(null, "ROLE_USER"));
          userService.saveRole(new Role(null, "ROLE_MANAGER"));
          userService.saveRole(new Role(null, "ROLE_ADMIN"));
          userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

          userService.saveUser(new User(null, "babul", "123456", new ArrayList<>()));
          userService.saveUser(new User(null, "anika", "123456", new ArrayList<>()));
          userService.saveUser(new User(null, "sujon", "123456", new ArrayList<>()));
          userService.saveUser(new User(null, "samima", "123456", new ArrayList<>()));

          userService.addRoleToUser("babul", "ROLE_USER");
          userService.addRoleToUser("babul", "ROLE_MANAGER");
          userService.addRoleToUser("babul", "ROLE_ADMIN");
          userService.addRoleToUser("babul", "ROLE_SUPER_ADMIN");
          userService.addRoleToUser("anika", "ROLE_USER");
          userService.addRoleToUser("sujon", "ROLE_USER");
          userService.addRoleToUser("samima", "ROLE_USER");
        };
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
