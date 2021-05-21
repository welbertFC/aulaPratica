package com.aulaPraticaJava.aulaPratica.repository;

import com.aulaPraticaJava.aulaPratica.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
