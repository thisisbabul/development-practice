package com.iambabul.springsecurityjwt.service;

import com.iambabul.springsecurityjwt.entity.Role;
import com.iambabul.springsecurityjwt.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
