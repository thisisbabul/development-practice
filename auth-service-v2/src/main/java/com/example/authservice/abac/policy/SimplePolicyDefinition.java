package com.example.authservice.abac.policy;

import com.example.authservice.abac.policy.model.PolicyRule;
import jakarta.annotation.PostConstruct;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimplePolicyDefinition implements PolicyDefinition {
	private List<PolicyRule> rules;
	
	@PostConstruct
	private void init(){
		ExpressionParser exp = new SpelExpressionParser();
		rules = new ArrayList<>();
		
		PolicyRule newRule = new PolicyRule();
		newRule.setName("ResourceOwner");
		newRule.setDescription("Resource owner should have access to it.");
		newRule.setCondition(exp.parseExpression("true"));
		newRule.setTarget(exp.parseExpression("subject.name == resource.owner"));
		rules.add(newRule);
	}
	public List<PolicyRule> getAllPolicyRules() {
		return rules;
	}

}
