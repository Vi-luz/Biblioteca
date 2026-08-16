package com.uniamerica.biblioteca.repository;

import com.uniamerica.biblioteca.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {


}
