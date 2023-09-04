package com.example.authservice.abac.policy;


import com.example.authservice.abac.policy.model.Resource;

import java.util.List;

public interface ResourceInterface {
    List<Resource> getResources();
}
