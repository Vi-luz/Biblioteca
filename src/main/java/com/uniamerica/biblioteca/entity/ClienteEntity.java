package com.uniamerica.biblioteca.entity;

import com.uniamerica.biblioteca.entity.enums.StatusCliente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ClienteEntity {

    private long id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDateTime dataCadastro;
    private StatusCliente status;
}