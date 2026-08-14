package com.uniamerica.biblioteca.entity;

import com.uniamerica.biblioteca.entity.enums.StatusCliente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDateTime dataCadastro;

    @Enumerated(EnumType.STRING)
    private StatusCliente status;
}