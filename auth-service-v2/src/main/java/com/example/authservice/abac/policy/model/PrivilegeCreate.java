package com.example.authservice.abac.policy.model;

import com.example.authservice.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;

@Data
public class PrivilegeCreate {
    @Enumerated(EnumType.STRING)
    public Role role;

    @JsonProperty("privileges")
    private List<Privilege> privileges;

    @Data
    public static class Privilege {
        @JsonProperty("action")
        private String action;

        @JsonProperty("requested_method")
        private String requestedMethod;
    }
}
