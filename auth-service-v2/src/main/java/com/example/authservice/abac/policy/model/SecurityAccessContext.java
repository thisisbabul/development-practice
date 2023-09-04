package com.example.authservice.abac.policy.model;

import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class SecurityAccessContext {
	private Object subject;
	private Object resource;
	private Object action;
	private Object environment;
}
