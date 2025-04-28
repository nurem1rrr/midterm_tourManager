package alatoo.midterm_tourmanager.controllers;

import alatoo.midterm_tourmanager.dto.LoginRequest;
import alatoo.midterm_tourmanager.dto.RegisterRequest;
import alatoo.midterm_tourmanager.services.JwtService;
import alatoo.midterm_tourmanager.entities.RefreshToken;
import alatoo.midterm_tourmanager.services.RefreshTokenService;
import alatoo.midterm_tourmanager.entities.Role;
import alatoo.midterm_tourmanager.entities.User;
import alatoo.midterm_tourmanager.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body("Email already in use");
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtService.generateToken(user);
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);

            Map<String, String> tokens = new HashMap<>();
            tokens.put("accessToken", accessToken);
            tokens.put("refreshToken", refreshToken.getToken());

            return ResponseEntity.ok(tokens);

        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String, String> request) {
        String requestToken = request.get("refreshToken");
        return refreshTokenService.findByToken(requestToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .<ResponseEntity<?>>map(user -> {
                    String token = jwtService.generateToken(user);
                    Map<String, String> response = new HashMap<>();
                    response.put("accessToken", token);
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> ResponseEntity.status(403).body("Invalid refresh token"));
    }
}
