package com.nelson.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nelson.api.service.Cliente1Service;
import com.nelson.api.model.Cliente1;

import java.util.Optional;

@RestController
@RequestMapping("/clientes1")
public class Cliente1Controller {

    @Autowired
    private Cliente1Service service;

    @GetMapping("/{id}")
    public Optional<Cliente1> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }
}