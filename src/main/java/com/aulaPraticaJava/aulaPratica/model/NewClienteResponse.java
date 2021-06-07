package com.aulaPraticaJava.aulaPratica.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewClienteResponse {

    private Integer id;
    private String nome;
    private String email;
    private String nickname;
    private String token;

    public NewClienteResponse(String token, UserResponse usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.nickname = usuario.getNickname();
        this.token = token;
    }
}
