package com.uniamerica.biblioteca.repository;

import com.uniamerica.biblioteca.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{
    // GET LOCALHOST:8080/API/CARROS/MARCA/fiat
    List<ClienteEntity> findByMarca(String marca);
}
