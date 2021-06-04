package com.aulaPraticaJava.aulaPratica.controller;

import com.aulaPraticaJava.aulaPratica.model.Cliente;
import com.aulaPraticaJava.aulaPratica.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteControler {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        var clientes = clienteService.findall();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        var cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente){
        var newcliente = clienteService.insert(cliente);
        return ResponseEntity.ok().body(newcliente);
    }

}
