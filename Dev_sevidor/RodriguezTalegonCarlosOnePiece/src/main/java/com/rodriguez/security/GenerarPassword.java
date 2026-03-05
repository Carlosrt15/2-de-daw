package com.rodriguez.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenerarPassword {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "1234";
        String hash = encoder.encode(password);
        System.out.println(hash);
    }
}