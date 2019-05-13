package br.com.klb.desafio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.klb.desafio.model.Cliente;
import br.com.klb.desafio.model.TipoEnum;

@RestController
@RequestMapping({ "/api" })
public class ClienteController {

    @Autowired
    private ClienteResource resource;

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        for (TipoEnum tipo : cliente.getTipo()) {
            if (tipo.equals(TipoEnum.B)) {
                cliente.setTaxaJuros(10);
            } else if (tipo.equals(TipoEnum.C)) {
                cliente.setTaxaJuros(20);
                break;
            }
        }
        return resource.create(cliente);
    }

    @GetMapping(path = { "/{id}" })
    public Optional<Cliente> findOne(@PathVariable("id") Long id) {
        return resource.findOne(id);
    }

    @DeleteMapping(path = { "/{id}" })
    public void delete(@RequestBody Cliente cliente) {
        resource.delete(cliente);
    }

    @GetMapping
    public Iterable<? extends Cliente> findAll() {
        return resource.findAll();
    }
}