package com.example.demo.controllers;



import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.UtilisateurDTO;
import com.example.demo.exceptions.PersonneNotFoundException;
import com.example.demo.security.AuthService;
import com.example.demo.security.AuthenticationRequest;
import com.example.demo.security.AuthenticationResponse;
import com.example.demo.security.JwtService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authentication")
@CrossOrigin("*")
public class AuthenticationController {
    private final AuthService authService;
    private final JwtService jwtservice;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UtilisateurDTO personneDTO) throws PersonneNotFoundException {
        AuthenticationResponse authResponse = authService.register(personneDTO);
        if (authResponse.getErrorMessage() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(authResponse);
        }
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse authResponse = authService.authenticate(authenticationRequest);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String jwt = authHeader.substring(7);
        jwtservice.setTokenExpirationToPast(jwt);
    }
}