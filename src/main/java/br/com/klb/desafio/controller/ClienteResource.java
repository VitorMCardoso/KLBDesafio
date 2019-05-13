package br.com.klb.desafio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.klb.desafio.model.Cliente;
import br.com.klb.desafio.repository.ClienteRepository;

@Component
public class ClienteResource {

	@Autowired
	private ClienteRepository repo;
	
    public Cliente create(@RequestBody Cliente cliente){
        return repo.save(cliente);
    }

    public Optional<Cliente> findOne(@PathVariable("id") Long id){
        return repo.findById(id);
    }

    public void delete(@RequestBody Cliente cliente) {
        repo.delete(cliente);
    }

    public Iterable<? extends Cliente>  findAll(){
        return repo.findAll();
    }
	
}
