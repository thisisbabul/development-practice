package com.example.authservice.abac.spring;

import com.example.authservice.abac.policy.PolicyEnforcement;
import com.example.authservice.abac.policy.model.Resource;
import com.example.authservice.abac.policy.model.Subject;
import com.example.authservice.model.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContextAwarePolicyEnforcement {
	private final PolicyEnforcement policy;
	private final ResourceRepository resourceRepository;

	public boolean hasPermission(String action) {
		Map<String, Object> environment = new HashMap<>();

		Optional<Resource> resource = resourceRepository.findByAction(action);
		if (resource.isEmpty())
			throw new RuntimeException("Content not found");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Optional<? extends GrantedAuthority> authority = auth.getAuthorities().stream().findFirst();
		if (authority.isPresent()) {
			String roleStr = split(authority.get().getAuthority(), "\\_").get(1);
			Role role = Role.valueOf(roleStr);
			Subject subject = getSubject(role);

			environment.put("time", new Date());

			if (policy.check(subject, resource.get(), action, environment)) {
				return Boolean.TRUE;
			}
		}
		throw new AccessDeniedException("Unauthorized the target resource");
	}

	public Subject getSubject(Role role) {
		Subject subject = new Subject();
		subject.setRole(role);
		//subject.setUserId();
		return subject;
	}

	public static List<String> split(String str, String regex){
		return Stream.of(str.split(regex))
				.map(String::new)
				.collect(Collectors.toList());
	}
}
