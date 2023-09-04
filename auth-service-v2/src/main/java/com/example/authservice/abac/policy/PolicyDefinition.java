package com.example.authservice.abac.policy;

import com.example.authservice.abac.policy.model.PolicyRule;

import java.util.List;

public interface PolicyDefinition {
	 List<PolicyRule> getAllPolicyRules();
}