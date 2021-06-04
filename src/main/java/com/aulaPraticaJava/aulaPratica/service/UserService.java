package com.aulaPraticaJava.aulaPratica.service;

import com.aulaPraticaJava.aulaPratica.model.Cliente;
import com.aulaPraticaJava.aulaPratica.model.UserResponse;
import com.aulaPraticaJava.aulaPratica.repository.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var cliente = clienteRepository.findByEmail(email);
        if(cliente == null){
            throw new UsernameNotFoundException(email);
        }
        return new UserResponse(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getPassword(), cliente.getNickname());
    }

    public Cliente buscaUsuario(Integer idUser) {
        var usuario = new Cliente();
        if (idUser != null)
            usuario = clienteRepository.findById(idUser).orElseThrow(
                    () -> new ObjectNotFoundException(idUser, "Usuario"));
        return usuario;
    }
}
