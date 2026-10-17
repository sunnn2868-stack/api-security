package com.example.api_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityDemoController {

    @GetMapping("/api/security/public")
    public String publicEndpoint() {
        return "This endpoint is public.";
    }

    @GetMapping("/api/security/private")
    public String privateEndpoint() {
        return "You are authenticated and can access this endpoint.";
    }

    @GetMapping("/api/security/admin")
    public String adminEndpoint() {
        return "Welcome, administrator!";
    }
}