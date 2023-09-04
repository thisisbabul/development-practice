package com.example.authservice.abac.spring;

import com.example.authservice.abac.policy.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    Optional<Resource> findByAction(String action);
}
