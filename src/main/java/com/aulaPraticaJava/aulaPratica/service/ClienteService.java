package com.aulaPraticaJava.aulaPratica.service;

import com.aulaPraticaJava.aulaPratica.model.Cliente;
import com.aulaPraticaJava.aulaPratica.repository.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente insert(Cliente cliente){
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll(){
        return  clienteRepository.findAll();
    }

    public Cliente findbyId(Integer id){
        var cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException(id, "Cliente não encontrado"));
    }

    public void delete(Integer id){
        clienteRepository.deleteById(id);
    }
}
