package com.example.authservice.abac.policy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.expression.Expression;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyRule {
	private String name;
	private String description;
	private Expression target;
	private Expression condition;
}
