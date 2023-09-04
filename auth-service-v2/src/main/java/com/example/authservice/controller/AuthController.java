package com.example.authservice.controller;

import com.example.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/token")
    public ResponseEntity<?> token(Authentication authentication) {
        String token = authService.generateToken(authentication);
        Map<String, String> result = new HashMap<>();
        result.put("access_token", token);
        return ResponseEntity.ok(result);
    }

    //@PreAuthorize("hasAuthority('SCOPE_read')")
    @GetMapping("/{id}")
    public String test(@PathVariable Integer id) {
        return "authentication is tested " + id;
    }
}
