package com.aulaPraticaJava.aulaPratica.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String password;
    private String nickname;


    @OneToMany(mappedBy = "cliente")
    private List<Imc> imcs = new ArrayList<>();

    public Cliente(){

    }

    public Cliente(Integer id, String nome, String email, String password, String nickname) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.nickname = nickname;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
