package com.aulaPraticaJava.aulaPratica.controller;

import com.aulaPraticaJava.aulaPratica.model.JwtResponse;
import com.aulaPraticaJava.aulaPratica.model.LoginRequest;
import com.aulaPraticaJava.aulaPratica.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService service;

    @PostMapping
    public ResponseEntity<JwtResponse> autenticaUsuario(@Valid @RequestBody LoginRequest loginRequest){
        String token = service.autenticaUsuario(loginRequest);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
