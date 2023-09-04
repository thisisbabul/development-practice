package com.example.authservice.abac.policy.model;

import com.example.authservice.model.Role;
import com.nimbusds.jose.shaded.gson.annotations.SerializedName;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class ResourcePolicyRuleModel {
    private Long id;

    @Enumerated(EnumType.STRING)
    public Role role;

    @SerializedName(("resource_id"))
    private Long resourceId;

    private String action;

}
