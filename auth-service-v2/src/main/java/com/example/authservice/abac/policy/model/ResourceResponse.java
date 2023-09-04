package com.example.authservice.abac.policy.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResourceResponse extends SuccessMessage {
    private List<Resource> resources;
    public ResourceResponse(int code, String message, List<Resource> resources) {
        super(code, message);
        this.resources = resources;
    }
}
