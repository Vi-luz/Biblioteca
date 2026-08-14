package com.uniamerica.biblioteca.controller.cliente.dto;

import com.uniamerica.biblioteca.entity.enums.StatusCliente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClienteResponse(

        long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        LocalDate dataNascimento,
        LocalDateTime dataCadastro,
        StatusCliente status
) {
}