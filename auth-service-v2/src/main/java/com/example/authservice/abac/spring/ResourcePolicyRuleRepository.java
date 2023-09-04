package com.example.authservice.abac.spring;

import com.example.authservice.abac.policy.model.ResourcePolicyRule;
import com.example.authservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourcePolicyRuleRepository extends JpaRepository<ResourcePolicyRule, Long> {
    List<ResourcePolicyRule> findAllByRoleAndResourceId(Role role, Long resourceId);
    List<ResourcePolicyRule> findAllByRole(Role role);
}
