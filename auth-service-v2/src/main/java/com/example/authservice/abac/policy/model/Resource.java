package com.example.authservice.abac.policy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="resources")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String action;
    private String groupName;
    private String subgroupName;
    private String requestMethod;
    private String actionType;
}
