package com.aulaPraticaJava.aulaPratica.service;

import com.aulaPraticaJava.aulaPratica.model.LoginRequest;
import com.aulaPraticaJava.aulaPratica.model.UserResponse;
import com.aulaPraticaJava.aulaPratica.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutenticacaoService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserService usuarioService;

    public String autenticaUsuario(LoginRequest loginRequest){
        var usuario = (UserResponse) usuarioService.loadUserByUsername(loginRequest.getNome());

        var authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getNome(), loginRequest.getSenha()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenProvider.geraToken(authentication);
    }
}
