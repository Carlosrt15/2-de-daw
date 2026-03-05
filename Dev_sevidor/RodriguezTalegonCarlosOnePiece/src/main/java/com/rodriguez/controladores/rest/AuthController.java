package com.rodriguez.controladores.rest;

import com.rodriguez.dto.JwtDTO;
import com.rodriguez.dto.LoginDTO;
import com.rodriguez.security.jwt.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public JwtDTO login(@RequestBody LoginDTO loginDTO) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginDTO.getUsername(),
                                loginDTO.getPassword()
                        )
                );

        String token = jwtTokenProvider.generateToken(authentication);

        return new JwtDTO(
                token,
                authentication.getName(),
                authentication.getAuthorities()
                        .stream()
                        .map(a -> a.getAuthority())
                        .toList()
        );
    }
}