package com.example.demo.config.auth;

import com.example.demo.config.AuthResponse;
import com.example.demo.model.Login;
import com.example.demo.model.Registro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthCont {

    private final AuthServ authServ;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginC(@RequestBody Login login){
        return ResponseEntity.ok(authServ.loginC(login));
    }

    @PostMapping("/registro")
    public ResponseEntity<AuthResponse> registroC(@RequestBody Registro registro){
        return ResponseEntity.ok(authServ.registroC(registro));
    }


}
