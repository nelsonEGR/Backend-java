package com.nelson.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nelson.api.repository.Cliente1Repository;
import com.nelson.api.model.Cliente1;

import java.util.Optional;

@Service
public class Cliente1Service {

    @Autowired
    private Cliente1Repository repo;

    public Optional<Cliente1> obtenerPorId(Long id) {
        return repo.findById(id);
    }
}