package com.aulaPraticaJava.aulaPratica.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginRequest {

    @NotNull
    @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String senha;
}
