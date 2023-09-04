package com.example.authservice.abac.spring;

import com.example.authservice.abac.policy.ResourceInterface;
import com.example.authservice.abac.policy.model.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceService implements ResourceInterface {
    private final ResourceRepository resourceRepository;

   public List<Resource> getResources() {
        List<Resource> resources = resourceRepository.findAll();
       if (resources.isEmpty()) {
           throw new RuntimeException("Data Not Found");
       }
       return resources;
    }
}
