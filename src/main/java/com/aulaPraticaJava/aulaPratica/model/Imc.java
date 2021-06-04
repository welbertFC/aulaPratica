package com.aulaPraticaJava.aulaPratica.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Imc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double altura;
    private Double peso;
    private LocalDateTime dataCreated;

    @ManyToOne
    @JoinColumn(name = "clienteID")
    private Cliente cliente;

    public Imc(){

    }

    public Imc(Integer id, Double altura, Double peso, LocalDateTime dataCreated, Cliente cliente) {
        this.id = id;
        this.altura = altura;
        this.peso = peso;
        this.dataCreated = dataCreated;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public LocalDateTime getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(LocalDateTime dataCreated) {
        this.dataCreated = dataCreated;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
