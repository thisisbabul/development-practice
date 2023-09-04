package com.example.authservice.abac.policy.model;

import com.example.authservice.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class Subject {
    @Enumerated(EnumType.STRING)
    public Role role;
    public Long userId;
}
