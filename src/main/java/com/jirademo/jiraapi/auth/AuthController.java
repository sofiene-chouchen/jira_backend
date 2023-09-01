package com.jirademo.jiraapi.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService service;

  @PostMapping("/registerAdmin")
  public ResponseEntity<AuthenticationResponse> registerAdmin(
          @RequestBody RegisterAdminRequest request
  ) {
    return ResponseEntity.ok(service.registerAdmin(request));
  }

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
          @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> login(
          @RequestBody LoginRequest request
  ) {
    return ResponseEntity.ok(service.login(request));
  }
}
