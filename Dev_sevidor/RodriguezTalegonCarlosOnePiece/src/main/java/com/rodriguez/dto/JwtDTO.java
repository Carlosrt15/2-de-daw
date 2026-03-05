package com.rodriguez.dto;

import java.util.List;

public class JwtDTO {

    private String token;
    private String username;
    private List<String> roles;

    public JwtDTO(String token, String username, List<String> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }

    public String getToken() { return token; }
    public String getUsername() { return username; }
    public List<String> getRoles() { return roles; }
}