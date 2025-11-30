package com.nelson.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nelson.api.model.Cliente1;

public interface Cliente1Repository extends JpaRepository<Cliente1, Long> {
    // Podés agregar métodos personalizados si querés, por ejemplo:
    Cliente1 findByDocumento(String documento);
}