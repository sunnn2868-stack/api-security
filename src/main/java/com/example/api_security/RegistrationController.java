package com.example.api_security;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RegistrationController {

    @PostMapping("/api/security/register")
    public String register(
            @Valid @RequestBody RegistrationRequest request) {

        if ("admin".equalsIgnoreCase(request.getUsername())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Username is already taken"
            );
        }

        return "Registration request is valid for username: "
                + request.getUsername();
    }
}