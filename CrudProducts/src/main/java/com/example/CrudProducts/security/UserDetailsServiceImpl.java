package com.example.CrudProducts.security;

import java.util.List;
import java.util.Set;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuario = getById(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        return User
                .withUsername(username)
                .password(usuario.password())
                .roles(usuario.roles().toArray(new String[0]))
                .build();
    }

    public record Usuario(String username, String password, Set<String> roles) {};

    public static Usuario getById(String username) {
        // "ezete" => [BCrypt] => "$2a$10$H1v/ZGAGnBp.Znd1FuQvEumR32RHFuLqTe9vSzcERCwz454XNVMKC"
        var password = "$2a$10$H1v/ZGAGnBp.Znd1FuQvEumR32RHFuLqTe9vSzcERCwz454XNVMKC";
        Usuario ezeUser = new Usuario(
                "ezeUser",
                password,
                Set.of("USER")
        );

        Usuario ezeAdmin = new Usuario(
                "ezeAdmin",
                password,
                Set.of("ADMIN")
        );
        var usuarios = List.of(ezeUser, ezeAdmin);

        return usuarios
                .stream()
                .filter(e -> e.username().equals(username))
                .findFirst()
                .orElse(null);
    }
}

