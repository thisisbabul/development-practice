package com.example.authservice.exception;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEvents {
    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failures) throws Exception {
        throw new AuthException(failures.getException().getMessage());
    }
}
