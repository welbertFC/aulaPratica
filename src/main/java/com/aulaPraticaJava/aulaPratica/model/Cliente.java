package com.aulaPraticaJava.aulaPratica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Campo nome não pode ser vazio")
    @NotNull(message = "Campo nome não pode ser nulo")
    private String nome;

    @Email
    @NotBlank(message = "Campo email não pode ser vazio")
    @NotNull(message = "Campo email não pode ser nulo")
    private String email;

    private LocalDate dataDeNascimento;

    public Cliente(Integer id, String nome, String email, LocalDate dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Cliente(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}
