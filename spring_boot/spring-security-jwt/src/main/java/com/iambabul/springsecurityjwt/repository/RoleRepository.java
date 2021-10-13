package com.iambabul.springsecurityjwt.repository;

import com.iambabul.springsecurityjwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
