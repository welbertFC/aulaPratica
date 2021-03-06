package com.aulaPraticaJava.aulaPratica.repository;

import com.aulaPraticaJava.aulaPratica.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.transaction.annotation.Transactional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Transactional(readOnly = true)
    Cliente findByEmail(String email);
}
