package com.aulaPraticaJava.aulaPratica.controller;

import com.aulaPraticaJava.aulaPratica.model.Cliente;
import com.aulaPraticaJava.aulaPratica.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/aula/oberdan")
public class ClienteControler {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> insert(@Valid @RequestBody Cliente cliente) {
        var novoCliente = clienteService.insert(cliente);
        return ResponseEntity.ok(novoCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        var cliente = clienteService.findbyId(id);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        var cliente = clienteService.findAll();
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        clienteService.delete(id);
    }
}
