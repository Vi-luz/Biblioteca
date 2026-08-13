package com.uniamerica.biblioteca.controller.dto.cliente;

import com.uniamerica.biblioteca.entity.enums.StatusCliente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClienteRequest(


        String nome,
        String cpf,
        String email,
        String telefone,
        LocalDate dataNascimento,
        LocalDateTime dataCadastro,
        StatusCliente status
) {
}
