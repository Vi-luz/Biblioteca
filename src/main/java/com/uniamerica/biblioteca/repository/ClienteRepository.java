package com.uniamerica.biblioteca.repository;

import com.uniamerica.biblioteca.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {
}
