package com.example.authservice.abac.policy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PolicyRuleResponse extends SuccessMessage {

    private List<ResourcePolicyRuleModel> policyRuleModels;

    public PolicyRuleResponse(int code, String message, List<ResourcePolicyRuleModel> policyRuleModels) {
        super(code, message);
        this.policyRuleModels = policyRuleModels;
    }
}
