package com.example.authservice.abac.spring;

import com.example.authservice.abac.policy.model.PolicyRule;
import com.example.authservice.abac.policy.model.PrivilegeCreate;
import com.example.authservice.abac.policy.model.Resource;
import com.example.authservice.abac.policy.model.ResourcePolicyRule;
import com.example.authservice.abac.policy.model.ResourcePolicyRuleModel;
import com.example.authservice.model.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ResourcePolicyRuleService {
    private final ResourcePolicyRuleRepository repository;
    private final ResourceRepository resourceRepository;


    public void createNewPrivilege(PrivilegeCreate privilegeCreate) {
        List<ResourcePolicyRule> policyRules = new ArrayList<>();
        if (Objects.nonNull(privilegeCreate) && Objects.nonNull(privilegeCreate.getPrivileges()) && !privilegeCreate.getPrivileges().isEmpty()) {
            List<Resource> resources = resourceRepository.findAll();
            for (PrivilegeCreate.Privilege privilege : privilegeCreate.getPrivileges()) {
                Optional<Resource> action = resources.stream()
                        .filter(resource -> resource.getAction().equals(privilege.getAction()))
                        .findAny();
                if (action.isPresent()) {
                    ResourcePolicyRule policyRule = getResourcePolicyRule(privilegeCreate, action);
                    policyRules.add(policyRule);
                }
            }
        }
        repository.saveAll(policyRules);
    }

    private static ResourcePolicyRule getResourcePolicyRule(PrivilegeCreate privilegeCreate, Optional<Resource> resourceOptional) {
        String condition = "action == resource.action";
        String target = "subject.role.name == '" + privilegeCreate.getRole().name() + "' && resource.id == " + resourceOptional.get().getId();

        ResourcePolicyRule policyRule = new ResourcePolicyRule();
        policyRule.setRole(privilegeCreate.getRole());
        Resource resource = new Resource();
        resource.setId(resourceOptional.get().getId());
        policyRule.setResource(resource);
        policyRule.setCondition(condition);
        policyRule.setTarget(target);
        return policyRule;
    }

    public List<PolicyRule> getPolicyRuleByRoleResourceId(Role role, Long resourceId) {
        ExpressionParser exp = new SpelExpressionParser();
        List<ResourcePolicyRule> rules = repository.findAllByRoleAndResourceId(role, resourceId);

        return rules.stream().map(rule -> {
            PolicyRule policyRule = new PolicyRule();
            /*policyRule.setName(rule.getName());
            policyRule.setDescription(rule.getDescription());*/
            policyRule.setCondition(exp.parseExpression(rule.getCondition()));
            policyRule.setTarget(exp.parseExpression(rule.getTarget()));
            return policyRule;
        }).collect(Collectors.toList());
    }

    public List<ResourcePolicyRuleModel> getPolicyRuleByRole(Role role) {
        List<ResourcePolicyRule> rules = repository.findAllByRole(role);
        return rules.stream().map(rule -> {
            ResourcePolicyRuleModel model = new ResourcePolicyRuleModel();
            model.setId(rule.getId());
            model.setRole(rule.getRole());
            model.setResourceId(rule.getResource().getId());
            model.setAction(rule.getResource().getAction());
            return model;
        }).collect(Collectors.toList());
    }
}
