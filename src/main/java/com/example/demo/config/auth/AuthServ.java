package com.example.demo.config.auth;

import com.example.demo.config.AuthResponse;
import com.example.demo.model.Login;
import com.example.demo.model.Registro;
import com.example.demo.model.Role;
import com.example.demo.model.Usuarios;
import com.example.demo.repository.UsuarioRep;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServ {

    private final UsuarioRep usuarioRep;
    private final JwtServ jwtServ;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse loginC(Login login) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        UserDetails user=usuarioRep.findByUsername(login.getUsername()).orElseThrow();
        System.out.println("Usuario: "+user);
        System.out.println("Login: "+login);
        String token=jwtServ.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }


    public AuthResponse registroC(Registro registro) {
        Usuarios usuario= Usuarios.builder()
                .email(registro.getEmail())
                .password(passwordEncoder.encode(registro.getPassword()))
                .username(registro.getUsername())
                .role(Role.USER)
                .build();
        usuarioRep.save(usuario);
        return AuthResponse.builder()
                .token(jwtServ.getToken(usuario)).build();
    }
}
