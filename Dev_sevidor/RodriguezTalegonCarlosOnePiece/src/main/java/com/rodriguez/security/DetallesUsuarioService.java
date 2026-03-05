package com.rodriguez.security;

import com.rodriguez.entities.User;
import com.rodriguez.repositories.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DetallesUsuarioService implements UserDetailsService {

    private final UserRepository userRepository;

    public DetallesUsuarioService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username);

        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getUserPasswd(),
                user.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getUserRole()))
                        .collect(Collectors.toList())
        );
    }
}