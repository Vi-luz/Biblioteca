package com.uniamerica.biblioteca.repository;

import com.uniamerica.biblioteca.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/")
public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {
    ClienteEntity update(ClienteEntity cliente, long id);

    ClienteEntity delete(long id);
}
