package com.example.authservice.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.CredentialExpiredException;
import java.security.SignatureException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(InvalidBearerTokenException.class)
    public ProblemDetail handleInvalidBearerTokenException(InvalidBearerTokenException ex) {
        ProblemDetail errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401), ex.getMessage());
        errorDetail.setProperty("access_denied_reason", "Authentication Failure");
        return errorDetail;
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ProblemDetail handleAuthentication(InsufficientAuthenticationException ex) {
        ProblemDetail errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401), ex.getMessage());
        errorDetail.setProperty("access_denied_reason", "Authentication Failure");
        return errorDetail;
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ProblemDetail handleAccessDeniedException(AccessDeniedException ex) {
        ProblemDetail errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), ex.getMessage());
        errorDetail.setProperty("access_denied_reason", "not_authorized!");
        return errorDetail;
    }

    @ExceptionHandler(SignatureException.class)
    public ProblemDetail handleSignatureException(SignatureException ex) {
        ProblemDetail errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), ex.getMessage());
        errorDetail.setProperty("access_denied_reason", "JWT Signature not valid");
        return errorDetail;
    }

    @ExceptionHandler(CredentialExpiredException.class)
    public ProblemDetail handleCredentialExpiredException(CredentialExpiredException ex) {
        ProblemDetail errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), ex.getMessage());
        errorDetail.setProperty("access_denied_reason", "JWT Token already expired !");
        return errorDetail;
    }

}
