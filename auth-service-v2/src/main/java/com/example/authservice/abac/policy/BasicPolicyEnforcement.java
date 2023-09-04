package com.example.authservice.abac.policy;

import com.example.authservice.abac.policy.model.PolicyRule;
import com.example.authservice.abac.policy.model.Resource;
import com.example.authservice.abac.policy.model.SecurityAccessContext;
import com.example.authservice.abac.policy.model.Subject;
import com.example.authservice.abac.spring.ResourcePolicyRuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.EvaluationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class BasicPolicyEnforcement implements PolicyEnforcement {
	private final ResourcePolicyRuleService ruleService;

	@Override
	public boolean check(Object subject, Object resource, Object action, Object environment) {
		Subject subjectObj = (Subject) subject;
		Resource resourceObj = (Resource) resource;

		List<PolicyRule> allRules = ruleService.getPolicyRuleByRoleResourceId(subjectObj.getRole(), resourceObj.getId());
		SecurityAccessContext cxt = new SecurityAccessContext(subject, resource, action, environment);
		List<PolicyRule> matchedRules = filterRules(allRules, cxt);
		return checkRules(matchedRules, cxt);
	}

	private List<PolicyRule> filterRules(List<PolicyRule> allRules, SecurityAccessContext cxt) {
		try {
			return allRules.stream()
					.filter(rule -> rule.getTarget().getValue(cxt, Boolean.class))
					.collect(Collectors.toList());
		}
		catch (Exception ex) {
			log.error("An error occurred while evaluating PolicyRule.", ex);
			return Collections.emptyList();
		}
	}

	private boolean checkRules(List<PolicyRule> matchedRules, SecurityAccessContext cxt) {
		try {
			return matchedRules.stream()
					.anyMatch(rule -> rule.getCondition().getValue(cxt, Boolean.class));
		}
		catch (Exception ex) {
			log.error("An error occurred while evaluating PolicyRule.", ex);
			return Boolean.FALSE;
		}
	}
}
