package com.example.authservice.abac.policy.model;

import com.example.authservice.model.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;


@Data
@Entity
@Table(name="policy_rule")
public class ResourcePolicyRule implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    public Role role;

    @ManyToOne(optional = false)
    @JoinColumn(name = "resource_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Resource resource;

    @Column(name="[target]")
    private String target;

    @Column(name="[conditions]")
    private String condition;

}
