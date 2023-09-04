package com.example.authservice.controller;

import com.example.authservice.abac.policy.model.*;
import com.example.authservice.abac.spring.ContextAwarePolicyEnforcement;
import com.example.authservice.abac.spring.ResourcePolicyRuleService;
import com.example.authservice.abac.spring.ResourceService;
import com.example.authservice.model.Role;
import com.example.authservice.repository.DBMessageSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/authorizations")
public class AuthorizationController {
    private final ContextAwarePolicyEnforcement policy;
    private final ResourcePolicyRuleService ruleService;
    private final ResourceService resourceService;
    private final DBMessageSource dbMessageSource;

    @GetMapping
    public ResponseEntity<SuccessMessage> checkPermission(@RequestParam(value = "action") String action) {
        if (policy.hasPermission(action)) {
            return new ResponseEntity<>(new SuccessMessage(HttpStatus.OK.value(), "access granted"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new SuccessMessage(HttpStatus.FORBIDDEN.value(), "access denied"), HttpStatus.FORBIDDEN);
    }

    @PostMapping
    public ResponseEntity<SuccessMessage> addPrivileges(@RequestBody PrivilegeCreate privilegeCreate) {
        ruleService.createNewPrivilege(privilegeCreate);
        return new ResponseEntity<>(new SuccessMessage(HttpStatus.CREATED.value(), "privilege saved successfully"), HttpStatus.CREATED);

    }

    @GetMapping("/policies")
    public ResponseEntity<PolicyRuleResponse> getPolicy(@RequestParam(value = "role") String role) {
        List<ResourcePolicyRuleModel> response = ruleService.getPolicyRuleByRole(Role.valueOf(role));
        if (!response.isEmpty()) {
            return new ResponseEntity<>(new PolicyRuleResponse(HttpStatus.OK.value(), "policy rule get successfully", response), HttpStatus.OK);
        }
        return new ResponseEntity<>(new PolicyRuleResponse(HttpStatus.NO_CONTENT.value(), "record no found", null), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/resources")
    public ResponseEntity<ResourceResponse> getResources() {
        List<Resource> response = resourceService.getResources();
        if (!response.isEmpty()) {
            return new ResponseEntity<>(new ResourceResponse(
                    HttpStatus.OK.value(),
                    dbMessageSource.getMessage("x0.fetched.successfully", new Object[]{dbMessageSource.getMessage("resource", null, LocaleContextHolder.getLocale())}, LocaleContextHolder.getLocale()),
                    response
            ), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResourceResponse(HttpStatus.NO_CONTENT.value(), "no record found", null), HttpStatus.NO_CONTENT);
    }
}
